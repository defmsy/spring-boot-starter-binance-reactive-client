package net.defmsy.binance.webclient;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.tomakehurst.wiremock.client.WireMock;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import net.defmsy.binance.webclient.entities.CoinInformation;
import net.defmsy.binance.webclient.entities.CoinInformation.Network;
import net.defmsy.binance.webclient.exceptions.BinanceWebClientException;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class GetAllCoinsInformationTest extends AbstractBinanceWebClientTest {

  private static final Long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
  private static final CoinInformation AGLD_COIN_INFORMATION = new CoinInformation(
      "AGLD",
      true,
      0d,
      0d,
      0d,
      0d,
      false,
      0d,
      "Adventure Gold",
      0d,
      true,
      true,
      0d,
      List.of(
          new Network(
              "^(0x)[0-9A-Fa-f]{40}$",
              "AGLD",
              "",
              true,
              true,
              "",
              12L,
              "Ethereum (ERC20)",
              "ETH",
              false,
              "",
              0,
              "",
              true,
              14d,
              0.00000001d,
              9999999d,
              28d,
              false
          )
      )
  );
  private static final CoinInformation STPT_COIN_INFORMATION = new CoinInformation(
      "STPT",
      true,
      0d,
      0d,
      0d,
      0d,
      false,
      0d,
      "Standard Tokenization Protocol",
      0d,
      true,
      true,
      0d,
      List.of(
          new Network(
              "^(0x)[0-9A-Fa-f]{40}$",
              "STPT",
              "",
              true,
              true,
              "",
              12L,
              "Ethereum (ERC20)",
              "ETH",
              false,
              "",
              0,
              "",
              true,
              247d,
              0.00000001d,
              10000000000d,
              494d,
              false
          )
      )
  );
  private static final CoinInformation MXN_COIN_INFORMATION = new CoinInformation(
      "MXN",
      true,
      0d,
      0d,
      0d,
      0d,
      true,
      0d,
      "Mexican Peso",
      0d,
      false,
      true,
      0d,
      List.of(
          new Network(
              "",
              "MXN",
              "",
              true,
              true,
              "",
              0L,
              "FIAT",
              "FIAT_MONEY",
              false,
              "",
              0,
              "",
              true,
              0d,
              1d,
              10000000000d,
              0d,
              false
          )
      )
  );

  @Test
  void shouldReturnCoinsInformation() {
    var signature = SignatureGenerator.getSignature("timestamp=" + timestamp, SECRET_KEY);
    wireMockServer.stubFor(
        WireMock.get(WireMock.urlPathEqualTo("/sapi/v1/capital/config/getall"))
            .withQueryParam("timestamp", WireMock.equalTo(String.valueOf(timestamp)))
            .withQueryParam("signature", WireMock.equalTo(signature))
            .willReturn(
                WireMock.ok()
                    .withHeader("Content-Type", "application/json;charset=UTF-8")
                    .withBodyFile("binance/getAllCoinsInformation_Ok.json")
            ));

    binanceWebClient.getAllCoinsInformation(null, timestamp)
        .as(StepVerifier::create)
        .expectNext(AGLD_COIN_INFORMATION)
        .expectNext(STPT_COIN_INFORMATION)
        .expectNext(MXN_COIN_INFORMATION)
        .verifyComplete();
  }

  @Test
  void shouldReturnError() {
    var signature = SignatureGenerator.getSignature("timestamp=" + timestamp, SECRET_KEY);
    wireMockServer.stubFor(
        WireMock.get(WireMock.urlPathEqualTo("/sapi/v1/capital/config/getall"))
            .withQueryParam("timestamp", WireMock.equalTo(String.valueOf(timestamp)))
            .withQueryParam("signature", WireMock.equalTo(signature))
            .willReturn(
                WireMock.badRequest()
                    .withHeader("Content-Type", "application/json;charset=UTF-8")
                    .withBodyFile("binance/getBinanceError_Template.json")
                    .withTransformers("response-template")
                    .withTransformerParameters(Map.of(
                        "code", 0,
                        "msg", "error message"
                    ))
            ));

    binanceWebClient.getAllCoinsInformation(null, timestamp)
        .as(StepVerifier::create)
        .expectErrorSatisfies(throwable -> assertThat(throwable)
            .isInstanceOf(BinanceWebClientException.class)
            .hasMessage("error message")
            .extracting("code").isEqualTo(0))
        .verify();
  }
}
