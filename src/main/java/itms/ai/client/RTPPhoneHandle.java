package itms.ai.client;

import javaforce.voip.RTPChannel;
import javaforce.voip.RTPInterface;
import javaforce.voip.SIPClient;
import javaforce.voip.g729a;

/**
 * Created by Administrator on 2018/12/10.
 */
public class RTPPhoneHandle implements RTPInterface{
    static final String ext="this is phone...";
    g729a coder;
    private void setCoder(RTPChannel channel){
        if(channel!=null){
            coder=new g729a(channel.rtp);
        }
    }
    @Override
    public void rtpSamples(RTPChannel rtp) {
        setCoder(rtp);
    }

    @Override
    public void rtpDigit(RTPChannel rtp, char digit) {
        setCoder(rtp);

    }

    @Override
    public void rtpPacket(RTPChannel rtp, byte[] data, int off, int len) {
        setCoder(rtp);
    }

    @Override
    public void rtcpPacket(RTPChannel rtp, byte[] data, int off, int len) {
        setCoder(rtp);

    }

    @Override
    public void rtpH263(RTPChannel rtp, byte[] data, int off, int len) {
        setCoder(rtp);

    }

    @Override
    public void rtpH263_1998(RTPChannel rtp, byte[] data, int off, int len) {
        setCoder(rtp);

    }

    @Override
    public void rtpH263_2000(RTPChannel rtp, byte[] data, int off, int len) {
        setCoder(rtp);

    }

    @Override
    public void rtpH264(RTPChannel rtp, byte[] data, int off, int len) {
        setCoder(rtp);

    }

    @Override
    public void rtpVP8(RTPChannel rtp, byte[] data, int off, int len) {
        setCoder(rtp);

    }

    @Override
    public void rtpJPEG(RTPChannel rtp, byte[] data, int off, int len) {
        setCoder(rtp);

    }

    @Override
    public void rtpInactive(RTPChannel rtp) {
        setCoder(rtp);

    }
}
