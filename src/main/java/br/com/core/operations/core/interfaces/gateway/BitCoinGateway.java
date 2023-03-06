package br.com.core.operations.core.interfaces.gateway;

import br.com.core.operations.core.entity.coinbase.response.CoinBaseResponse;

public interface BitCoinGateway {
    CoinBaseResponse getQuotation(final String currency);
}
