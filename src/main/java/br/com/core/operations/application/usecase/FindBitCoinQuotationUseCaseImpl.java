package br.com.core.operations.application.usecase;

import br.com.core.operations.application.mapper.QuotationMapper;
import br.com.core.operations.core.entity.AllQuotations;
import br.com.core.operations.core.entity.Quotation;
import br.com.core.operations.core.interfaces.gateway.BitCoinGateway;
import br.com.core.operations.core.interfaces.usecase.FindBitCoinQuotationUseCase;
import br.com.core.operations.utils.DataUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindBitCoinQuotationUseCaseImpl implements FindBitCoinQuotationUseCase {

    private static final String BTC = "bitcoin";

    private final BitCoinGateway bitCoinGateway;
    @Override
    public Quotation getQuotation(String currency) {
        return QuotationMapper.INSTANCE.toEntity(bitCoinGateway.getQuotation(currency));
    }

    @Override
    public AllQuotations getAll() {
        AllQuotations quotations = AllQuotations.builder()
                .moedaBase(BTC)
                .data(DataUtils.getFormatterDateTimeNow())
                .cotacoes(new ArrayList<>())
                .build();
        bitCoinGateway.getAll().forEach(q -> {
            quotations.getCotacoes().add(QuotationMapper.INSTANCE.toEntity(q));
        });

        return quotations;
    }
}
