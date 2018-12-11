package itms.ai.RTMP;


import javaforce.voip.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/12/10.
 */
public class RTMP_Server  {
    static final String rtmpPath="localRtmp";
    public static void main(String args[]) {
//        RTMP2SIPServer rtmp2SIPServer;
//        RTMP2SIPHandle handle=new RTMP2SIPHandle();
//        rtmp2SIPServer=new RTMP2SIPServer(handle,rtmpPath);
//        rtmp2SIPServer.startServer();

        SipServerEventHandler eventHandler=new SipServerEventHandler();

        SIPServer sipServer=new SIPServer();
        sipServer.init(5650,eventHandler, SIP.Transport.UDP);

        String reCallid="authtel10022";
        String reCallid1="authphone10011";
        try {
            char b;
            while ((b=(char)System.in.read())!='\r'){
                if(b=='1'){
                            sipServer.register("authtel","authtel","192.168.1.110",5677,3600,"authtel",reCallid);
        sipServer.register("authphone","authphone","192.168.1.110",5679,3600,"authphone",reCallid1);
                    break;
                }else{continue;}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        while (is.)
//        sipServer.register("authtel","authtel","192.168.31.37",5677,3600,"authtel",reCallid);
//        sipServer.register("authphone","authphone","192.168.31.37",5679,3600,"authphone",reCallid);
//        SIPClient client=new SIPClient();
//        client.init()
    }
}
