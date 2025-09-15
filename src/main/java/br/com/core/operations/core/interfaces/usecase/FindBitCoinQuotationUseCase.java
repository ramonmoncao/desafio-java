package br.com.core.operations.core.interfaces.usecase;

import br.com.core.operations.core.entity.AllQuotations;
import br.com.core.operations.core.entity.Quotation;

public interface FindBitCoinQuotationUseCase {

    Quotation getQuotation(String currency);

    AllQuotations getAll();
}
