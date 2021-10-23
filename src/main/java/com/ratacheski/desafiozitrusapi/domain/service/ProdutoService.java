package com.ratacheski.desafiozitrusapi.domain.service;

import com.ratacheski.desafiozitrusapi.api.dto.ProdutoPorTipoOut;
import com.ratacheski.desafiozitrusapi.domain.model.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {
    List<Produto> listar();
    Produto obterPorCodigo(UUID codigo);
    Produto criar(Produto produto);
    Produto atualizar(UUID codigo, Produto produto);
    void remover(UUID codigo);
    List<ProdutoPorTipoOut> consultarPorTipoComQuantidadeSaida(Integer tipo);
}
