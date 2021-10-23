package com.ratacheski.desafiozitrusapi.domain.service;

import com.ratacheski.desafiozitrusapi.api.dto.LucroProdutoDTO;
import com.ratacheski.desafiozitrusapi.domain.model.MovimentoEstoque;

import java.util.UUID;

public interface MovimentoEstoqueService {
    MovimentoEstoque movimentar(UUID codigoProduto, MovimentoEstoque movimentoEstoque);

    LucroProdutoDTO obterLucroProduto(UUID codigoProduto);
}
