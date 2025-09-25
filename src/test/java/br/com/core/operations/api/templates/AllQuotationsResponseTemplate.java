package br.com.core.operations.api.templates;

import br.com.core.operations.core.entity.AllQuotations;
import br.com.core.operations.core.entity.Quotation;
import br.com.core.operations.utils.DataUtils;

import java.math.BigDecimal;
import java.util.List;

public class AllQuotationsResponseTemplate {
    private static final String BTC = "bitcoin";

    public static AllQuotations getAllQuotations(){

        return AllQuotations.builder()
                .moedaBase(BTC)
                .data(DataUtils.getFormatterDateTimeNow())
                .cotacoes(getQuotationList())
                .build();
    }
    private static List<Quotation> getQuotationList(){
        return List.of(
                Quotation.builder()
                        .moeda("USD")
                        .valor(BigDecimal.valueOf(111409.48))
                        .build(),
                Quotation.builder()
                        .moeda("BRL")
                        .valor(BigDecimal.valueOf(590823.86))
                        .build(),
                Quotation.builder()
                        .moeda("EUR")
                        .valor(BigDecimal.valueOf(94804.25))
                        .build()
        );
    }
}
