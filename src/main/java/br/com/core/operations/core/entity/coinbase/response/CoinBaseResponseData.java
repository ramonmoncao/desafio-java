package br.com.core.operations.core.entity.coinbase.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoinBaseResponseData implements Serializable {
    private String base;
    private String currency;
    private BigDecimal amount;
}
