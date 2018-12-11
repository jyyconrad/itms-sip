import itms.ai.client.RTPClientHandle;
import itms.ai.client.RTPPhoneHandle;
import itms.ai.client.SipClientHandle;
import itms.ai.client.SipPhoneHandle;
import javaforce.JF;
import javaforce.JFLog;
import javaforce.voip.*;

import java.io.IOException;

import static javaforce.voip.RTP.CODEC_G729a;

/**
 * Created by Administrator on 2018/12/10.
 */
public class SIPClient2Test {
    public static void main(String args[]) {
        SipPhoneHandle clientHandle=new SipPhoneHandle();
        SIPClient client=new SIPClient();
        client.init("192.168.1.110",5650,5679,clientHandle, SIP.Transport.UDP);

//        client.reregister();
//        client.getSDP()
//        SDP sdp=new SDP();
//        sdp.addStream(SDP.Type.audio);


//        rtp.getDefaultChannel()
//        sdp.getFirstAudioStream().addCodec(CODEC_G729a);
//        String callid= client.invite("authphone",sdp);


//        JFLog.log("callid to authphohe..."+callid);
//        rtp.getDefaultChannel().writeRTP();


        try {
            char b;
            while ((b=(char)System.in.read())!='\r'){
                if(b=='1'){
                    client.register("authphone","authphone","authphone","authphone");
                    break;
                }else{continue;}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        while (client.rtmp!=null){
//            RTP rtp=(RTP)client.rtmp;
//            if(rtp.active){
//
//            }else{
//                JF.sleep(1000);
//                client.bye(cal);
//            }
//        }

//        client.bye(callid);
    }
}
