package br.com.core.operations.core.entity;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllQuotations {
    private String moedaBase;
    private String data;
    private List<Quotation> cotacoes;
}
