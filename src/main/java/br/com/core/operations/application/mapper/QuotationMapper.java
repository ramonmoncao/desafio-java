package br.com.core.operations.application.mapper;

import br.com.core.operations.core.entity.Quotation;
import br.com.core.operations.core.entity.coinbase.response.CoinBaseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public abstract class QuotationMapper {
    public static final QuotationMapper INSTANCE = getMapper(QuotationMapper.class);


    @Mapping(target = "moeda", source = "data.currency")
    @Mapping(target = "valor", expression = "java(roundToTwoDecimals(coinBaseResponse.getData().getAmount()))")
    public abstract Quotation toEntity(CoinBaseResponse coinBaseResponse);

    protected BigDecimal roundToTwoDecimals(BigDecimal value) {
        return value != null ? value.setScale(2, RoundingMode.HALF_UP) : null;
    }
}

