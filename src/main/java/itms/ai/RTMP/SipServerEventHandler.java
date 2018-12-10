package itms.ai.RTMP;

import javaforce.voip.CallDetailsServer;
import javaforce.voip.SIPServerInterface;

/**
 * Created by Administrator on 2018/12/10.
 */
public class SipServerEventHandler implements SIPServerInterface {
    @Override
    public CallDetailsServer createCallDetailsServer() {
        return new CallDetailsServer();
    }

    @Override
    public String getPassword(String user) {
        return null;
    }

    @Override
    public String getTrunkRegister(String ip) {
        return null;
    }

    @Override
    public void onRegister(String user, int expires, String remoteip, int remoteport) {

    }

    @Override
    public void onInvite(CallDetailsServer cd, boolean src) {

    }

    @Override
    public void onCancel(CallDetailsServer cd, boolean src) {

    }

    @Override
    public void onError(CallDetailsServer cd, int code, boolean src) {

    }

    @Override
    public void onBye(CallDetailsServer cd, boolean src) {

    }

    @Override
    public void onSuccess(CallDetailsServer cd, boolean src) {

    }

    @Override
    public void onRinging(CallDetailsServer cd, boolean src) {

    }

    @Override
    public void onTrying(CallDetailsServer cd, boolean src) {

    }

    @Override
    public void onFeature(CallDetailsServer cd, String cmd, String data, boolean src) {

    }
}
