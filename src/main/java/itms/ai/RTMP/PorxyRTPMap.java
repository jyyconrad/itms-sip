package itms.ai.RTMP;

import javaforce.voip.RTP;

import java.util.HashMap;
import java.util.Map;

public class PorxyRTPMap {
   private static Map<String,RTP> rtpMaps;
    public PorxyRTPMap(){
        rtpMaps=new HashMap<String,RTP>();
    }
    public static   void addRTP(String key,RTP rtp){

        rtpMaps.put(key,rtp);
    }
    public static   RTP getRTP(String key){
        return rtpMaps.get(key);
    }

}
