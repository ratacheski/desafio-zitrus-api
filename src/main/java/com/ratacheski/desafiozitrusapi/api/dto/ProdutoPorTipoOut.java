package com.ratacheski.desafiozitrusapi.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProdutoPorTipoOut {
    private UUID codigo;
    private String descricao;
    private BigDecimal quantidadeDisponivel;
    private BigDecimal quantidadeSaida;
}
