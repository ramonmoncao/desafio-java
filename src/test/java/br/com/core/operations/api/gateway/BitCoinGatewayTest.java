package br.com.core.operations.api.gateway;

import br.com.core.operations.adapter.gateway.client.BitCoinGatewayClient;
import br.com.core.operations.adapter.gateway.impl.BitCoinGatewayImpl;
import br.com.core.operations.core.entity.coinbase.response.CoinBaseResponse;
import br.com.core.operations.core.entity.coinbase.response.CoinBaseResponseData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BitCoinGatewayTest {

    @MockBean
    private BitCoinGatewayClient client;

    @Autowired
    private BitCoinGatewayImpl bitCoinGateway;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarTodosComSucesso(){
        CoinBaseResponse usd = new CoinBaseResponse(new CoinBaseResponseData("BTC", "USD", null));
        CoinBaseResponse brl = new CoinBaseResponse(new CoinBaseResponseData("BTC", "BRL", null));
        CoinBaseResponse eur = new CoinBaseResponse(new CoinBaseResponseData("BTC", "EUR", null));


        when(client.getQuotation("USD")).thenReturn(usd);
        when(client.getQuotation("BRL")).thenReturn(brl);
        when(client.getQuotation("EUR")).thenReturn(eur);

        List<CoinBaseResponse> result = bitCoinGateway.getAll();

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(usd, result.get(0));
        assertEquals(brl, result.get(1));
        assertEquals(eur, result.get(2));

        verify(client).getQuotation("USD");
        verify(client).getQuotation("BRL");
        verify(client).getQuotation("EUR");
    }
}
