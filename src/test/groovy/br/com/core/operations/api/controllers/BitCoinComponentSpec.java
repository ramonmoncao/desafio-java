package br.com.core.operations.api.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWireMock
class BitCoinComponentTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void deveRetornarMoedaBRL() throws Exception {

        String currency = "BRL";

        mockMvc.perform(get("/bitcoin-operations/quotation/{currency}", currency))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currency").value("BRL"))
                .andExpect(jsonPath("$.amount").isNumber());

    }
    @Test
    void deveRetornarMoedaEUR() throws Exception {

        String currency = "EUR";

        mockMvc.perform(get("/bitcoin-operations/quotation/{currency}", currency))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currency").value("EUR"))
                .andExpect(jsonPath("$.amount").isNumber());

    }
    @Test
    void deveRetornarMoedaUSD() throws Exception {

        String currency = "USD";

        mockMvc.perform(get("/bitcoin-operations/quotation/{currency}", currency))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currency").value("USD"))
                .andExpect(jsonPath("$.amount").isNumber());

    }

    @Test
    void deveRetornarUSDeBRLeEUR() throws Exception {

        mockMvc.perform(get("/bitcoin-operations/quotation"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.moedaBase").value("BTC"))
                .andExpect(jsonPath("$.data").exists())
                .andExpect(jsonPath("$.cotacoes").isArray())
                .andExpect(jsonPath("$.cotacoes.length()").value(3))
                .andExpect(jsonPath("$.cotacoes[?(@.currency=='BRL')]").exists())
                .andExpect(jsonPath("$.cotacoes[?(@.currency=='EUR')]").exists())
                .andExpect(jsonPath("$.cotacoes[?(@.currency=='USD')]").exists());
    }
}
