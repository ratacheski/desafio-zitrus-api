package com.ratacheski.desafiozitrusapi.api.dto;

import com.ratacheski.desafiozitrusapi.domain.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

@Getter
@Setter
public class LucroProdutoDTO {
    private UUID codigo;
    private String descricao;
    private BigDecimal totalLucro;
    private BigDecimal quantidadeSaida;

    public LucroProdutoDTO(Produto produto, BigDecimal totalLucro, BigDecimal quantidadeSaida) {
        this.codigo = produto.getCodigo();
        this.descricao = produto.getDescricao();
        this.totalLucro = totalLucro.setScale(2, RoundingMode.HALF_UP);
        this.quantidadeSaida = quantidadeSaida;
    }
}
