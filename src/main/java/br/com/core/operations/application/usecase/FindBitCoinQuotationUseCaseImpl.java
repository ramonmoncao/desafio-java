package br.com.core.operations.application.usecase;

import br.com.core.operations.application.mapper.QuotationMapper;
import br.com.core.operations.core.entity.Quotation;
import br.com.core.operations.core.interfaces.gateway.BitCoinGateway;
import br.com.core.operations.core.interfaces.usecase.FindBitCoinQuotationUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindBitCoinQuotationUseCaseImpl implements FindBitCoinQuotationUseCase {

    private final BitCoinGateway bitCoinGateway;
    @Override
    public Quotation getQuotation(String currency) {
        return QuotationMapper.INSTANCE.toEntity(bitCoinGateway.getQuotation(currency));
    }
}
