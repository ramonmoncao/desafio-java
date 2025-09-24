package br.com.core.operations.api.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWireMock
class BitCoinControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void deveRetornarUSDeBRLeEUR() throws Exception {

        mockMvc.perform(get("/bitcoin-operations/quotation"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.moedaBase").value("bitcoin"))
                .andExpect(jsonPath("$.data").exists())
                .andExpect(jsonPath("$.cotacoes").isArray())
                .andExpect(jsonPath("$.cotacoes.length()").value(3))
                .andExpect(jsonPath("$.cotacoes[?(@.moeda=='BRL')]").exists())
                .andExpect(jsonPath("$.cotacoes[?(@.moeda=='EUR')]").exists())
                .andExpect(jsonPath("$.cotacoes[?(@.moeda=='USD')]").exists());
    }
}
