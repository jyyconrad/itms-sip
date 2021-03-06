package javaforce.voip;

/** SIP TCP Transport
 *
 * Client needs to only connect to one endpoint.
 *
 * @author pquiring
 *
 * Created : Jan 29, 2014
 */

import javaforce.JF;
import javaforce.JFLog;

import java.net.*;
import java.io.*;

public class SIPTCPTransportClient implements SIPTransport {
  protected boolean connected = false;
  protected Socket socket;
  protected OutputStream os;
  protected InputStream is;
  protected InetAddress host;
  protected int port;

  public String getName() { return "TCP"; }

  public boolean open(int localport) {
    try {
      socket = new Socket();
      socket.setSoLinger(true, 0);  //allow to reuse socket again without waiting
      socket.bind(new InetSocketAddress(InetAddress.getLocalHost(), localport));
    } catch (Exception e) {
      JFLog.log(e);
      return false;
    }
    return true;
  }

  public boolean close() {
    connected = false;
    try {
      if (socket != null) {
        socket.close();
        socket = null;
      }
    } catch (Exception e) {
      JFLog.log(e);
    }
    return true;
  }

  public boolean send(byte[] data, int off, int len, InetAddress host, int port) {
    try {
      if (!connected) {
        connect(host, port);
      }
      os.write(data, off, len);
      os.flush();
    } catch (Exception e) {
      JFLog.log(e);
      return false;
    }
    return true;
  }

  private byte extra[] = null;

  private int detectLength(byte data[], int off, int len) {
    for(int a=0;a<len-3;a++) {
      if (
        (data[off+a+0] == '\r') &&
        (data[off+a+1] == '\n') &&
        (data[off+a+2] == '\r') &&
        (data[off+a+3] == '\n')
      ) {
        return a+4;
      }
    }
    return -1;
  }

  public boolean receive(javaforce.voip.SIP.Packet packet) {
    try {
      if (is == null) {
        packet.length = 0;
        JF.sleep(100);  //wait for first send()
        return false;
      }
      if (extra != null) {
        System.arraycopy(extra, 0, packet.data, 0, extra.length);
        packet.length = extra.length;
        extra = null;
      } else {
        packet.length = is.read(packet.data);
      }
      int plen, tlen;
      do {
        //detect end of packet (double \r\n)
        plen = detectLength(packet.data, 0, packet.length);
        if (plen == -1) {
          //not enough read (frag?)
          packet.length += is.read(packet.data, packet.length, packet.data.length - packet.length);
        }
      } while (plen == -1);
      tlen = plen;
      //now find Content-Length:
      String msg[] = new String(packet.data, 0, plen).split("\r\n");
      String clenstr = javaforce.voip.SIP.getHeader("Content-Length:", msg);
      if (clenstr == null) javaforce.voip.SIP.getHeader("l:", msg);
      if (clenstr != null) {
        int clen = JF.atoi(clenstr);
        tlen += clen;
      }
      while (packet.length < tlen) {
        //not enough read (frag?)
        packet.length += is.read(packet.data, packet.length, packet.data.length - packet.length);
      }
      if (packet.length > tlen) {
        //extra read (from next packet)
        extra = new byte[packet.length - tlen];
        System.arraycopy(packet.data, tlen, extra, 0, packet.length - tlen);
        packet.length = tlen;
      }
      //host and port never change
      packet.host = host.getHostAddress();
      packet.port = port;
    } catch (Exception e) {
      if (connected) JFLog.log(e);
      return false;
    }
    return true;
  }

  protected void connect(InetAddress host, int port) throws Exception {
    this.host = host;
    this.port = port;
    socket.connect(new InetSocketAddress(host, port), 5000);
    os = socket.getOutputStream();
    is = socket.getInputStream();
    connected = true;
  }
}
