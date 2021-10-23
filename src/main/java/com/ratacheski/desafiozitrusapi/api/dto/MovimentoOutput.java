package com.ratacheski.desafiozitrusapi.api.dto;

import com.ratacheski.desafiozitrusapi.domain.enums.TipoMovimentacao;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class MovimentoOutput {
    private UUID id;
    private ProdutoMinimalDTO produto;
    private BigDecimal valorCusto;
    private BigDecimal valor;
    private BigDecimal quantidade;
    private TipoMovimentacao tipoMovimentacao;
    private OffsetDateTime dataVenda;
}
