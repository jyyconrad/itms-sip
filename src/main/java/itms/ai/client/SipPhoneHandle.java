package itms.ai.client;

import javaforce.JF;
import javaforce.JFLog;
import javaforce.media.AudioBuffer;
import javaforce.voip.*;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by Administrator on 2018/12/10.
 */
public class SipPhoneHandle implements SIPClientInterface {
    public static short[] bytesToShort(byte[] bytes) {
        if(bytes==null){
            return null;
        }
        short[] shorts = new short[bytes.length/2];
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(shorts);
        return shorts;
    }
    public static byte[] shortToBytes(short[] shorts) {
        if(shorts==null){
            return null;
        }
        byte[] bytes = new byte[shorts.length * 2];
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(shorts);

        return bytes;
    }


    static final String ext="this is phone..";
    static final String filePath="D:\\DevelopCode\\Git\\Java\\Sip\\javaforce\\projects\\jfpbx\\sounds\\en\\conf-no-admin.wav";
    @Override
    public void onRegister(SIPClient client, boolean status) {
        JFLog.log(ext+"onRegister...status="+status+"User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
    }

    @Override
    public void onTrying(SIPClient client, String callid) {
        JFLog.log(ext+"onTrying...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());

    }

    @Override
    public void onRinging(SIPClient client, String callid) {
        JFLog.log(ext+"onRinging...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());

    }
    RTP rtp;
    RTPPhoneHandle rtpClientHandle=new RTPPhoneHandle();
    @Override
    public void onSuccess(SIPClient client, String callid, SDP sdp, boolean complete) {
        JFLog.log(ext+"onSuccess...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
        JFLog.log(ext+"SDP...="+sdp.toString());


        try {
            g729a coder=new g729a(rtp);
            FileInputStream  fis = new FileInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte d[]=new byte[160];
            int off=0;

//             AudioBuffer buffer = new AudioBuffer(8000, 1, 2);  //freq, chs, seconds
            while (fis.read(d,off,160)!=-1){

               byte[] dd= coder.encode(bytesToShort(d));
//                buffer.add(dd,0,dd.length);
//                rtp.getDefaultChannel().writeRTP(buffer,0,160);
                rtp.getDefaultChannel().writeRTP(dd,0,160);
                off+=160;
                JF.sleep(20);
            }
            rtp.stop();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JF.sleep(1000);
        client.bye(callid);
    }

    @Override
    public void onBye(SIPClient client, String callid) {
        JFLog.log(ext+"onBye...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());

    }

    @Override
    public int onInvite(SIPClient client, String callid, String fromid, String fromnumber, SDP sdp) {
        JFLog.log(ext+"onBye...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
        JFLog.log(ext+"SDP...="+sdp.toString());
        JFLog.log(ext+"fromid="+fromid+",fromnumber="+fromnumber);
        rtp=new RTP();
        rtp.init(rtpClientHandle);
        rtp.start();
                client.rtmp=rtp;
        return 200;
    }

    @Override
    public void onCancel(SIPClient client, String callid, int code) {
        JFLog.log(ext+"onCancel...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
        JFLog.log(ext+"code="+code);
    }

    @Override
    public void onRefer(SIPClient client, String callid) {
        JFLog.log(ext+"onRefer...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());

    }

    @Override
    public void onNotify(SIPClient client, String callid, String event, String content) {
        JFLog.log(ext+"onNotify...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
        JFLog.log(ext+"event="+event+",content="+content);

    }

    @Override
    public void onAck(SIPClient client, String callid, SDP sdp) {
        JFLog.log(ext+"onAck...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
        JFLog.log(ext+"SDP...="+sdp.toString());
    }
}
