package net.defmsy.binance.webclient;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.defmsy.binance.webclient.exceptions.BinanceSignatureGenerationException;
import org.apache.commons.codec.binary.Hex;

public class SignatureGenerator {

  private static final String HMAC_SHA256 = "HmacSHA256";

  private SignatureGenerator() {
  }

  public static String getSignature(String data, String key) {
    byte[] hmacSha256;
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), HMAC_SHA256);
      Mac mac = Mac.getInstance(HMAC_SHA256);
      mac.init(secretKeySpec);
      hmacSha256 = mac.doFinal(data.getBytes());
    } catch (Exception e) {
      throw new BinanceSignatureGenerationException("Failed to calculate hmac-sha256", e);
    }
    return Hex.encodeHexString(hmacSha256);
  }
}
