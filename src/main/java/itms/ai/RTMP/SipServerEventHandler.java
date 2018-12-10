package itms.ai.RTMP;

import javaforce.JFLog;
import javaforce.voip.CallDetailsServer;
import javaforce.voip.RTP;
import javaforce.voip.SIPServerInterface;

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

    }

    @Override
    public void onInvite(CallDetailsServer cd, boolean src) {
        JFLog.log(ext+"onInvite...user="+cd.user+",remoteip="+cd.fromnumber);

    }

    @Override
    public void onCancel(CallDetailsServer cd, boolean src) {
        JFLog.log(ext+"onCancel...user="+cd.user+",remoteip="+cd.fromnumber);

    }

    @Override
    public void onError(CallDetailsServer cd, int code, boolean src) {
        JFLog.log(ext+"onError...user="+cd.user+",remoteip="+cd.fromnumber);

    }

    @Override
    public void onBye(CallDetailsServer cd, boolean src) {
        JFLog.log(ext+"onBye...user="+cd.user+",remoteip="+cd.fromnumber);

    }

    @Override
    public void onSuccess(CallDetailsServer cd, boolean src) {
        JFLog.log(ext+"onSuccess...user="+cd.user+",remoteip="+cd.fromnumber);

        if(src){
            RTP serverRtp=new RTP();
            serverRtp.setMTU(2);
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
