package net.defmsy.binance.webclient.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(Include.NON_NULL)
public class BinanceError {

  private final Integer code;
  private final String message;

  @JsonCreator
  public BinanceError(@JsonProperty("code") Integer code, @JsonProperty("msg") String message) {
    this.code = code;
    this.message = message;
  }

  @SuppressWarnings("unused")
  public Integer getCode() {
    return code;
  }

  @SuppressWarnings("unused")
  public String getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    BinanceError that = (BinanceError) o;

    return new EqualsBuilder().append(code, that.code)
        .append(message, that.message).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(code).append(message).toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("code", code)
        .append("message", message)
        .toString();
  }
}
