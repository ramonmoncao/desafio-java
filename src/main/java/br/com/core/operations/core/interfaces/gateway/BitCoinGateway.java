package br.com.core.operations.core.interfaces.gateway;

import br.com.core.operations.core.entity.coinbase.response.CoinBaseResponse;

import java.util.List;

public interface BitCoinGateway {
    CoinBaseResponse getQuotation(final String currency);

    List<CoinBaseResponse> getAll();
}
