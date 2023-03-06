package br.com.core.operations.application.mapper;

import br.com.core.operations.core.entity.Quotation;
import br.com.core.operations.core.entity.coinbase.response.CoinBaseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public abstract class QuotationMapper {
    public static final QuotationMapper INSTANCE = getMapper(QuotationMapper.class);


    @Mapping(target = "currency", source = "data.currency")
    @Mapping(target = "amount", source = "data.amount")
    public abstract Quotation toEntity(CoinBaseResponse coinBaseResponse);

}

