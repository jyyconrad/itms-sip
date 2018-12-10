package javaforce.voip;

import javaforce.voip.*;

/**
 * Interface to allow RTP to trigger callbacks.
 */
public interface RTPInterface {

  /**
   * Triggered when new voice RTP data has arrived and been decoded. It is safe
   * to call getSamples()
   */
  public void rtpSamples(javaforce.voip.RTPChannel rtp);

  /**
   * Triggered when DTMF code has arrived.
   */
  public void rtpDigit(javaforce.voip.RTPChannel rtp, char digit);

  /**
   * Triggered when RTP is using raw mode and a RTP packet is received.
   */
  public void rtpPacket(javaforce.voip.RTPChannel rtp, byte data[], int off, int len);

  /**
   * Triggered when RTP is using raw mode and a RTCP packet is received.
   */
  public void rtcpPacket(javaforce.voip.RTPChannel rtp, byte data[], int off, int len);

  /**
   * Triggered when a H.263 packet is received.
   */
  public void rtpH263(javaforce.voip.RTPChannel rtp, byte data[], int off, int len);

  /**
   * Triggered when a H.263-1998 packet is received.
   */
  public void rtpH263_1998(javaforce.voip.RTPChannel rtp, byte data[], int off, int len);

  /**
   * Triggered when a H.263-2000 packet is received.
   */
  public void rtpH263_2000(javaforce.voip.RTPChannel rtp, byte data[], int off, int len);

  /**
   * Triggered when a H.264 packet is received.
   */
  public void rtpH264(javaforce.voip.RTPChannel rtp, byte data[], int off, int len);

  /**
   * Triggered when a VP8 packet is received.
   */
  public void rtpVP8(javaforce.voip.RTPChannel rtp, byte data[], int off, int len);

  /**
   * Triggered when a JPEG packet is received.
   */
  public void rtpJPEG(javaforce.voip.RTPChannel rtp, byte data[], int off, int len);

  /**
   * Triggered when an RTPChannel has been inactive for some time.
   */
  public void rtpInactive(javaforce.voip.RTPChannel rtp);
}
