package itms.ai.client;

import javaforce.voip.RTPChannel;
import javaforce.voip.RTPInterface;
import javaforce.voip.g729a;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by Administrator on 2018/12/10.
 */
public class RTPClientHandle implements RTPInterface {
    static final String filePath="D:\\DevelopCode\\Git\\Java\\sip-rtmp\\conf-no-admin.wav";
    g729a coder;
    FileOutputStream fos;
    public RTPClientHandle(){
        try {
            fos= new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
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



    @Override
    public void rtpSamples(RTPChannel rtp) {

    }

    @Override
    public void rtpDigit(RTPChannel rtp, char digit) {

    }

    @Override
    public void rtpPacket(RTPChannel rtp, byte[] data, int off, int len) {
        coder=new g729a(rtp.rtp);
        try {
            short d[]=coder.decode(data,0);
            byte dd[]=shortToBytes(d);
            fos.write(dd,0,dd.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void fulsh(){
        if(fos!=null){
            try {
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
