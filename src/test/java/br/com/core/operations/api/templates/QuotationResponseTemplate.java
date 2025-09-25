package br.com.core.operations.api.templates;

import br.com.core.operations.core.entity.AllQuotations;
import br.com.core.operations.core.entity.Quotation;
import br.com.core.operations.utils.DataUtils;

import java.math.BigDecimal;

public class QuotationResponseTemplate {
    private static final String MOEDA = "USD";
    private static final BigDecimal VALOR = BigDecimal.valueOf(111409.48);

    public static Quotation getQuotation() {

        return Quotation.builder()
                .moeda(MOEDA)
                .valor(VALOR)
                .build();
    }
}