package itms.ai.RTMP;


import javaforce.voip.*;

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
        sipServer.init(5650,eventHandler, SIP.Transport.TCP);


//        SIPClient client=new SIPClient();
//        client.init()
    }
}
