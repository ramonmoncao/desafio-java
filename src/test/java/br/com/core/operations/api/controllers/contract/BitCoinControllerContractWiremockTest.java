package br.com.core.operations.api.controllers.contract;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.profiles.active=test")
@AutoConfigureMockMvc
@AutoConfigureWireMock(port = 8081)
class BitCoinControllerContractWiremockTest {

    private static final String URL_USD = "/bitcoin-operations/quotation/USD";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFindUSDQuotationWithWireMock() throws Exception {

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/v2/prices/BTC-USD/spot"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"data\":{\"base\":\"BTC\",\"currency\":\"USD\",\"amount\":50000}}")));


        mockMvc.perform(get("/bitcoin-operations/quotation/USD"))
                .andExpect(jsonPath("$.moeda").value("USD"))
                .andExpect(jsonPath("$.valor").value(new BigDecimal("50000.00")))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testFindAllQuotationsWithWireMock() throws Exception {

        String[] moedas = {"USD", "EUR", "BRL"};

        for (String moeda : moedas) {
            WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/v2/prices/BTC-" + moeda + "/spot"))
                    .willReturn(WireMock.aResponse()
                            .withHeader("Content-Type", "application/json")
                            .withBody("{\"data\":{\"base\":\"BTC\",\"currency\":\"" + moeda + "\",\"amount\":50000}}")));
        }

        mockMvc.perform(get("/bitcoin-operations/quotations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cotacoes[*].moeda")
                        .value(Matchers.containsInAnyOrder("USD", "EUR", "BRL")))
                .andDo(print());
    }
}

