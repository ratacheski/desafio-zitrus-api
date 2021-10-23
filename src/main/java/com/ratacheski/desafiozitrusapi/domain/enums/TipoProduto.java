package com.ratacheski.desafiozitrusapi.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
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

    @JsonCreator
    public static TipoProduto getByCodigo(@JsonProperty("codigo") Integer codigo) {
        if (codigo == null)
            return null;
        return Stream.of(values())
                .filter(tipoProduto -> tipoProduto.getCodigo().equals(codigo))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
