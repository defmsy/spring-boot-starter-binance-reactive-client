package net.defmsy.binance.webclient;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = BinanceWebClientProperties.BINANCE_WEBCLIENT_PREFIX)
public class BinanceWebClientProperties {

  public static final String BINANCE_WEBCLIENT_PREFIX = "binance.webclient";

  private Boolean enabled;

  private String baseUrl;

  private String apiKey;

  private String secretKey;

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }
}
