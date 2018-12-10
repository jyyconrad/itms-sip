package itms.ai.client;

import javaforce.JF;
import javaforce.JFLog;
import javaforce.voip.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by Administrator on 2018/12/10.
 */
public class SipClientHandle implements SIPClientInterface {
    static final String ext="this is telClient..";

    @Override
    public void onRegister(SIPClient client, boolean status) {
        JFLog.log(ext+"onRegister...status="+status+"User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
    }

    @Override
    public void onTrying(SIPClient client, String callid) {
        JFLog.log(ext+"onTrying...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());

    }

    @Override
    public void onRinging(SIPClient client, String callid) {
        JFLog.log(ext+"onRinging...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());

    }

    @Override
    public void onSuccess(SIPClient client, String callid, SDP sdp, boolean complete) {
        JFLog.log(ext+"onSuccess...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
        JFLog.log(ext+"SDP...="+sdp.toString());
    }

    @Override
    public void onBye(SIPClient client, String callid) {
        JFLog.log(ext+"onBye...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
        rtpClientHandle.fulsh();
    }
    RTP rtp;
    RTPClientHandle rtpClientHandle=new RTPClientHandle();
    @Override
    public int onInvite(SIPClient client, String callid, String fromid, String fromnumber, SDP sdp) {
        JFLog.log(ext+"onBye...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
        JFLog.log(ext+"SDP...="+sdp.toString());
        JFLog.log(ext+"fromid="+fromid+",fromnumber="+fromnumber);
        rtp=new RTP();
        rtp.init(rtpClientHandle);
        client.rtmp=rtp;
        rtp.start();
        return 200;
    }

    @Override
    public void onCancel(SIPClient client, String callid, int code) {
        JFLog.log(ext+"onCancel...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
        JFLog.log(ext+"code="+code);
    }

    @Override
    public void onRefer(SIPClient client, String callid) {
        JFLog.log(ext+"onRefer...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());

    }

    @Override
    public void onNotify(SIPClient client, String callid, String event, String content) {
        JFLog.log(ext+"onNotify...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
        JFLog.log(ext+"event="+event+",content="+content);

    }

    @Override
    public void onAck(SIPClient client, String callid, SDP sdp) {
        JFLog.log(ext+"onAck...callid="+callid+",User="+client.getUser()+",ip="+client.getRemoteHost()+":"+client.getRemoteHost());
        JFLog.log(ext+"SDP...="+sdp.toString());
    }
}
