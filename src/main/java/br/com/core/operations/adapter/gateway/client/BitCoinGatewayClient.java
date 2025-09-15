package br.com.core.operations.adapter.gateway.client;

import br.com.core.operations.core.entity.coinbase.response.CoinBaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.rest.bitcoin.name}", url = "${feign.rest.bitcoin.url}")
public interface BitCoinGatewayClient {

        @GetMapping(value = "/v2/prices/BTC-{currency}/spot", produces = MediaType.APPLICATION_JSON_VALUE)
        CoinBaseResponse getQuotation(@PathVariable("currency") String currency);

        @GetMapping(value = "/v2/prices/BTC-USD/spot", produces = MediaType.APPLICATION_JSON_VALUE)
        CoinBaseResponse getUSD();
        @GetMapping(value = "/v2/prices/BTC-EUR/spot", produces = MediaType.APPLICATION_JSON_VALUE)
        CoinBaseResponse getEUR();
        @GetMapping(value = "/v2/prices/BTC-BRL/spot", produces = MediaType.APPLICATION_JSON_VALUE)
        CoinBaseResponse getBRL();
}
