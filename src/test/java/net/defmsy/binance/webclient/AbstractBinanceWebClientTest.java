package net.defmsy.binance.webclient;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractBinanceWebClientTest {

  protected static final String API_KEY = "TEST_API_KEY";
  protected static final String SECRET_KEY = "TEST_SECRET_KEY";

  protected static WireMockServer wireMockServer;
  protected static BinanceWebClient binanceWebClient;

  @BeforeAll
  static void beforeAll() {
    wireMockServer = buildWireMockServer();
    wireMockServer.start();
    binanceWebClient = buildBinanceWebClient(wireMockServer.baseUrl());
  }

  @AfterAll
  static void afterAll() {
    wireMockServer.shutdown();
  }

  @BeforeEach
  protected void beforeEach() {
    wireMockServer.resetAll();
  }

  private static WireMockServer buildWireMockServer() {
    return new WireMockServer(
        new WireMockConfiguration()
            .dynamicPort()
            .extensions(new ResponseTemplateTransformer(false)));
  }

  private static BinanceWebClient buildBinanceWebClient(String baseUrl) {
    return new BinanceWebClientImpl(
        baseUrl,
        API_KEY,
        SECRET_KEY
    );
  }
}
