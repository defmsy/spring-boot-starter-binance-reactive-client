package net.defmsy.binance.webclient;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import net.defmsy.binance.webclient.entities.BinanceError;
import net.defmsy.binance.webclient.entities.CoinInformation;
import net.defmsy.binance.webclient.entities.SystemStatus;
import net.defmsy.binance.webclient.exceptions.BinanceWebClientException;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BinanceWebClientImpl implements BinanceWebClient {

  public static final String AUTHORIZATION_HEADER = "X-MBX-APIKEY";

  private final WebClient webClient;
  private final String apiKey;
  private final String secretKey;

  public BinanceWebClientImpl(String baseUrl, String apiKey, String secretKey) {
    this.webClient = WebClient.builder().baseUrl(baseUrl).build();
    this.apiKey = apiKey;
    this.secretKey = secretKey;
  }

  @Override
  public Mono<SystemStatus> getSystemStatus() {
    return this.webClient.get().uri("/sapi/v1/system/status").retrieve()
        .bodyToMono(SystemStatus.class);
  }

  @Override
  public Flux<CoinInformation> getAllCoinsInformation(final Long recvWindow, final Long timestamp) {
    Map<String, Object> queryParams = new HashMap<>();
    queryParams.put("timestamp", timestamp);
    Optional.ofNullable(recvWindow).ifPresent(value -> queryParams.put("recvWindow", value));
    String signature = getSignature(queryParams);
    return this.webClient.get().uri(uriBuilder -> uriBuilder.path("/sapi/v1/capital/config/getall")
            .queryParamIfPresent("recvWindow", Optional.ofNullable(recvWindow))
            .queryParam("timestamp", timestamp).queryParam("signature", signature).build())
        .header(AUTHORIZATION_HEADER, apiKey).retrieve()
        .onStatus(HttpStatus::isError, this::mapError).bodyToFlux(CoinInformation.class);
  }

  private String getSignature(Map<String, Object> queryParams) {
    var data = queryParams.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue())
        .collect(Collectors.joining("&"));
    return SignatureGenerator.getSignature(data, this.secretKey);
  }

  private Mono<Throwable> mapError(ClientResponse clientResponse) {
    return clientResponse.bodyToMono(BinanceError.class)
        .map(error -> new BinanceWebClientException(error.getCode(), error.getMessage()));
  }
}
