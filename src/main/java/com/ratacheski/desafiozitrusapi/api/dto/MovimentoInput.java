package com.ratacheski.desafiozitrusapi.api.dto;

import com.ratacheski.desafiozitrusapi.domain.enums.TipoMovimentacao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class MovimentoInput {
    @NotNull
    @Min(0)
    private BigDecimal valor;
    @NotNull
    @Min(0)
    private BigDecimal quantidade;
    @NotNull
    private TipoMovimentacao tipoMovimentacao;
}
