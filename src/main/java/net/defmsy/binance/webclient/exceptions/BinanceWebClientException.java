package net.defmsy.binance.webclient.exceptions;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class BinanceWebClientException extends RuntimeException {

  private final Integer code;

  public BinanceWebClientException(final Integer code, final String message) {
    super(message);
    this.code = code;
  }

  @SuppressWarnings("unused")
  public Integer getCode() {
    return code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BinanceWebClientException)) {
      return false;
    }

    BinanceWebClientException that = (BinanceWebClientException) o;

    return new EqualsBuilder().append(code, that.code).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(code).toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("code", code)
        .toString();
  }
}
