package net.defmsy.binance.webclient.exceptions;

public class BinanceSignatureGenerationException extends RuntimeException {

  public BinanceSignatureGenerationException(String message, Throwable cause) {
    super(message, cause);
  }
}
