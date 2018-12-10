import itms.ai.client.RTPClientHandle;
import itms.ai.client.SipClientHandle;
import javaforce.JF;
import javaforce.JFLog;
import javaforce.voip.*;

import java.io.IOException;

import static javaforce.voip.RTP.CODEC_G729a;

/**
 * Created by Administrator on 2018/12/10.
 */
public class SIPClientTest {
    public static void main(String args[]) {
        SipClientHandle clientHandle=new SipClientHandle();
        SIPClient client=new SIPClient();
        client.init("192.168.31.37",5650,5677,clientHandle, SIP.Transport.TCP);
//        client.register("authtel","authtel","authtel","authtel");
//        client.getSDP()

//        RTP rtp=new RTP();
//        RTPClientHandle rtpClientHandle=new RTPClientHandle();
//        rtp.init(rtpClientHandle);
//        rtp.start();

//        rtp.getDefaultChannel()

        try {
            char b;
            while ((b=(char)System.in.read())!='\r'){
                if(b=='1'){
                    client.register("authtel","authtel","authtel","authtel");
                    JF.sleep(1000);

                    SDP sdp=new SDP();
                    sdp.addStream(SDP.Type.audio);
                    sdp.getFirstAudioStream().addCodec(CODEC_G729a);
                    String callid= client.invite("authphone",sdp);


                    JFLog.log("callid to authphohe..."+callid);
                    break;
                }else{continue;}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        rtp.getDefaultChannel().writeRTP();


//        JF.sleep(10000);

//        client.bye(callid);
    }
}
