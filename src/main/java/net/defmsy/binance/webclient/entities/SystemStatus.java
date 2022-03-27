package net.defmsy.binance.webclient.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SystemStatus {

  private final Integer status;
  private final String message;

  @JsonCreator
  public SystemStatus(
      @JsonProperty("status") Integer status,
      @JsonProperty("msg") String message
  ) {
    this.status = status;
    this.message = message;
  }

  @SuppressWarnings("unused")
  public Integer getStatus() {
    return status;
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

    SystemStatus that = (SystemStatus) o;

    return new EqualsBuilder().append(status, that.status)
        .append(message, that.message).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(status).append(message).toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("status", status)
        .append("message", message)
        .toString();
  }
}
