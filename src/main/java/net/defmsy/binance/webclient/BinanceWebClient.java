package net.defmsy.binance.webclient;

import javax.validation.constraints.NotNull;
import net.defmsy.binance.webclient.entities.CoinInformation;
import net.defmsy.binance.webclient.entities.SystemStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BinanceWebClient {

  Mono<SystemStatus> getSystemStatus();

  Flux<CoinInformation> getAllCoinsInformation(final Long recvWindow,
      @NotNull final Long timestamp);

}
