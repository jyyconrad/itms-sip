package itms.ai.RTMP;

import javaforce.voip.RTPChannel;
import javaforce.voip.RTPInterface;

/**
 * Created by Administrator on 2018/12/10.
 */
public class RTPServerhandle implements RTPInterface {
    @Override
    public void rtpSamples(RTPChannel rtp) {

    }

    @Override
    public void rtpDigit(RTPChannel rtp, char digit) {

    }

    @Override
    public void rtpPacket(RTPChannel rtp, byte[] data, int off, int len) {

    }

    @Override
    public void rtcpPacket(RTPChannel rtp, byte[] data, int off, int len) {

    }

    @Override
    public void rtpH263(RTPChannel rtp, byte[] data, int off, int len) {

    }

    @Override
    public void rtpH263_1998(RTPChannel rtp, byte[] data, int off, int len) {

    }

    @Override
    public void rtpH263_2000(RTPChannel rtp, byte[] data, int off, int len) {

    }

    @Override
    public void rtpH264(RTPChannel rtp, byte[] data, int off, int len) {

    }

    @Override
    public void rtpVP8(RTPChannel rtp, byte[] data, int off, int len) {

    }

    @Override
    public void rtpJPEG(RTPChannel rtp, byte[] data, int off, int len) {

    }

    @Override
    public void rtpInactive(RTPChannel rtp) {

    }
}
