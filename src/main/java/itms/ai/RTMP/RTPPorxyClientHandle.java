package itms.ai.RTMP;

import itms.ai.client.RTPClientHandle;
import javaforce.voip.RTPChannel;
import javaforce.voip.RTPInterface;
import javaforce.voip.g729a;

public class RTPPorxyClientHandle implements RTPInterface{
    private void setCoder(RTPChannel channel){

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
