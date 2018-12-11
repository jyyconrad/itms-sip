import itms.ai.RTMP.SipClientPorxyHandle;
import javaforce.voip.SDP;
import javaforce.voip.SIP;
import javaforce.voip.SIPClient;

public class SipCall2ClientTest {
    public static void main(String args[]) {
        SIPClient sipClient=new SIPClient();
        sipClient.init("192.168.1.110",5679,5650,new SipClientPorxyHandle(), SIP.Transport.UDP);
        sipClient.register("authphone","authphone","authphone","authphone");
        SDP sdp=new SDP();
        sipClient.invite("authphone",sdp);
    }
}
