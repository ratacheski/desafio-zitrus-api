package com.ratacheski.desafiozitrusapi.domain.service;

import com.ratacheski.desafiozitrusapi.domain.model.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {
    List<Produto> listar();
    Produto obterPorCodigo(UUID codigo);
    Produto criar(Produto produto);
    Produto atualizar(Produto produto);
    void remover(UUID codigo);
}
