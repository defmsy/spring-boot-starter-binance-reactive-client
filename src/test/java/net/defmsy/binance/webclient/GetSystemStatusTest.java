package net.defmsy.binance.webclient;

import com.github.tomakehurst.wiremock.client.WireMock;
import net.defmsy.binance.webclient.entities.SystemStatus;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class GetSystemStatusTest extends AbstractBinanceWebClientTest {

  @Test
  void shouldReturnSystemStatus() {
    wireMockServer.stubFor(
        WireMock.get("/sapi/v1/system/status")
            .willReturn(
                WireMock.ok()
                    .withHeader("Content-Type", "application/json;charset=UTF-8")
                    .withBodyFile("binance/getSystemStatus_Normal.json")
            ));

    var expectedSystemStatus = new SystemStatus(0, "normal");

    binanceWebClient.getSystemStatus()
        .as(StepVerifier::create)
        .expectNext(expectedSystemStatus)
        .verifyComplete();
  }

}
