package com.ratacheski.desafiozitrusapi.api.mapper;

import com.ratacheski.desafiozitrusapi.api.dto.ProdutoDTO;
import com.ratacheski.desafiozitrusapi.domain.model.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    Produto ProdutoDtoToProduto(ProdutoDTO source);

    ProdutoDTO ProdutoToProdutoDto(Produto destination);
}


