package br.com.core.operations.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Quotation implements Serializable {
    private String moeda;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal valor;
}
