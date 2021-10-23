package com.ratacheski.desafiozitrusapi.domain.enums;

import lombok.Getter;

import java.util.stream.Stream;

public enum TipoProduto {

    ELETRONICO(1, "Eletrônico"),
    ELETRODOMESTICO(2, "Eletrodoméstico"),
    MOVEL(3, "Móvel");

    @Getter
    private Integer codigo;
    @Getter
    private String descricao;

    TipoProduto(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TipoProduto getByCodigo(Integer codigo) {
        if (codigo == null)
            return null;
        return Stream.of(values())
                .filter(tipoProduto -> tipoProduto.getCodigo().equals(codigo))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
