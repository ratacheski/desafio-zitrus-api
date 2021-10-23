package com.ratacheski.desafiozitrusapi.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoMovimentacao {

    ENTRADA(1, "Entrada"),
    SAIDA(2, "Saída");

    @Getter
    private Integer codigo;
    @Getter
    private String descricao;

    TipoMovimentacao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }


    @JsonCreator
    public static TipoMovimentacao getByCodigo(@JsonProperty("codigo") Integer codigo) {
        if (codigo == null)
            return null;
        return Stream.of(values())
                .filter(tipoMovimentacao -> tipoMovimentacao.getCodigo().equals(codigo))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
