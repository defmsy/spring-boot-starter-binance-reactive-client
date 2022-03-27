package net.defmsy.binance.webclient;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(BinanceWebClientProperties.class)
@ConditionalOnProperty(value = "binance.webclient.enabled", matchIfMissing = true)
@AutoConfigureAfter({WebFluxAutoConfiguration.class})
public class BinanceWebClientAutoConfiguration {

  private final BinanceWebClientProperties properties;

  public BinanceWebClientAutoConfiguration(
      BinanceWebClientProperties properties) {
    this.properties = properties;
  }

  @Bean
  public BinanceWebClient getBinanceWebClient() {
    return new BinanceWebClientImpl(
        properties.getBaseUrl(),
        properties.getApiKey(),
        properties.getSecretKey()
    );
  }
}
