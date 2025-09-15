package br.com.core.operations.core.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllQuotations {
    private String moedaBase;
    private LocalDateTime data = LocalDateTime.now();
    private List<Quotation> cotacoes = new ArrayList<>();
}
