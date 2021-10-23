package com.ratacheski.desafiozitrusapi.enums;

import lombok.Getter;

import java.util.stream.Stream;

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

    public static TipoMovimentacao getByCodigo(Integer codigo) {
        if (codigo == null)
            return null;
        return Stream.of(values())
                .filter(tipoMovimentacao -> tipoMovimentacao.getCodigo().equals(codigo))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
