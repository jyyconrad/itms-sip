package itms.ai.RTMP;

import javaforce.JFLog;
import javaforce.voip.*;

/**
 * Created by Administrator on 2018/12/10.
 */
public class SipServerEventHandler implements SIPServerInterface {
    static final String ext="this is sipserver..";

    @Override
    public CallDetailsServer createCallDetailsServer() {
        return new CallDetailsServer();
    }

    @Override
    public String getPassword(String user) {
        return user;
    }

    @Override
    public String getTrunkRegister(String ip) {
        return null;
    }

    @Override
    public void onRegister(String user, int expires, String remoteip, int remoteport) {
        JFLog.log(ext+"onRegister...user="+user+",remoteip="+remoteip+":"+remoteport);

//        SIPClient.setNAT(SIPClient.NAT.ICE,"192.168.1.110",user,user);

    }

    RTP toRtp;
    @Override
    public void onInvite(CallDetailsServer cd, boolean src) {
        JFLog.log(ext+"onInvite...user="+cd.user+",remoteip="+cd.src.host);
//        SIPClient sipClient=new SIPClient();
//        sipClient.init("192.168.1.110",5679,5651,new SipClientPorxyHandle(), SIP.Transport.UDP);
//        sipClient.register("authphone","authphone","authphone","authphone");
//        SDP sdp=new SDP();
////        sipClient.setUserPass("authphone","authphone");
//
//        sipClient.invite("authphone",cd.src.sdp);

    if(src){
      CallDetailsServer cds=  cd.sip.getCallDetailsServer("authphone10011");
        cd.sip.reInvite(cds,cd.src.to[0],cd.src.sdp);
    }

//        SIPServer.Transport
    }

    @Override
    public void onCancel(CallDetailsServer cd, boolean src) {
        JFLog.log(ext+"onCancel...user="+cd.user+",remoteip="+cd.fromnumber);

    }

    @Override
    public void onError(CallDetailsServer cd, int code, boolean src) {
        JFLog.log(ext+"onError...user="+cd.user+",remoteip="+(src?cd.src.host:cd.dst.host));

    }

    @Override
    public void onBye(CallDetailsServer cd, boolean src) {
        JFLog.log(ext+"onBye...user="+cd.user+",remoteip="+cd.fromnumber);

    }

    @Override
    public void onSuccess(CallDetailsServer cd, boolean src) {
        JFLog.log(ext+"onSuccess...user="+cd.user+",remoteip="+cd.fromnumber);

        SIPTCPTransportClient transportClient=new SIPTCPTransportClient();
        if(src){
//            RTP.enableTURN();
            RTP serverRtp=new RTP();
//            RTPChannel c= serverRtp.findChannel(cd.src.host,cd.src.port);
            RTPServerhandle rtpServerhandle=new RTPServerhandle();
            serverRtp.init(rtpServerhandle);
            serverRtp.start();
//            serverRtp.getDefaultChannel().writeRTP();
        }
    }

    @Override
    public void onRinging(CallDetailsServer cd, boolean src) {
        JFLog.log(ext+"onRinging...user="+cd.user+",remoteip="+cd.fromnumber);

    }

    @Override
    public void onTrying(CallDetailsServer cd, boolean src) {
        JFLog.log(ext+"onTrying...user="+cd.user+",remoteip="+cd.fromnumber);

    }

    @Override
    public void onFeature(CallDetailsServer cd, String cmd, String data, boolean src) {
        JFLog.log(ext+"onFeature...user="+cd.user+",remoteip="+cd.fromnumber);

    }
}
