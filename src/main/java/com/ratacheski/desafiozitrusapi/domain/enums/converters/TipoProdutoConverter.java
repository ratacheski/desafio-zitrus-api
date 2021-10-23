package com.ratacheski.desafiozitrusapi.domain.enums.converters;

import com.ratacheski.desafiozitrusapi.domain.enums.TipoProduto;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TipoProdutoConverter implements AttributeConverter<TipoProduto, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TipoProduto tipoProduto) {
        return tipoProduto != null ? tipoProduto.getCodigo() : null;
    }

    @Override
    public TipoProduto convertToEntityAttribute(Integer codigo) {
        return TipoProduto.getByCodigo(codigo);
    }
}
