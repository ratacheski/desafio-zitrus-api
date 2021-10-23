package com.ratacheski.desafiozitrusapi.domain.enums.converters;

import com.ratacheski.desafiozitrusapi.domain.enums.TipoMovimentacao;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TipoMovimentacaoConverter implements AttributeConverter<TipoMovimentacao, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TipoMovimentacao tipoMovimentacao) {
        return tipoMovimentacao != null ? tipoMovimentacao.getCodigo() : null;
    }

    @Override
    public TipoMovimentacao convertToEntityAttribute(Integer codigo) {
        return TipoMovimentacao.getByCodigo(codigo);
    }
}
