package com.ratacheski.desafiozitrusapi.api.mapper;

import com.ratacheski.desafiozitrusapi.api.dto.*;
import com.ratacheski.desafiozitrusapi.domain.model.MovimentoEstoque;
import com.ratacheski.desafiozitrusapi.domain.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    Produto produtoDtoToProduto(ProdutoDTO source);

    ProdutoDTO produtoToProdutoDto(Produto destination);

    ProdutoMinimalDTO produtoToProdutoMinimalDto(Produto produto);

    @Mappings({
            @Mapping(target = "codigo", source = "codigo"),
            @Mapping(target = "descricao", source = "descricao"),
            @Mapping(target = "quantidadeDisponivel", source = "quantidadeEstoque"),
            @Mapping(target = "quantidadeSaida", ignore = true)
    })
    ProdutoPorTipoOut produtoToProdutoPorTipoOut(Produto produto);

    @Mappings({
            @Mapping(target = "valorVenda", source = "valor"),
            @Mapping(target = "quantidadeMovimentada", source = "quantidade"),
            @Mapping(target = "dataVenda", ignore = true),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "produto", ignore = true),
            @Mapping(target = "valorCusto", ignore = true)
    })
    MovimentoEstoque movimentoInputToMovimentoEstoque(MovimentoInput input);

    @Mappings({
            @Mapping(target = "valor", source = "valorVenda"),
            @Mapping(target = "quantidade", source = "quantidadeMovimentada")
    })
    MovimentoOutput movimentoEstoqueToMovimentoOutput(MovimentoEstoque movimentoEstoque);
}


