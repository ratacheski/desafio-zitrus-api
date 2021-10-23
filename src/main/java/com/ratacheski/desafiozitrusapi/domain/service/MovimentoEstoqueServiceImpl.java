package com.ratacheski.desafiozitrusapi.domain.service;

import com.ratacheski.desafiozitrusapi.domain.enums.TipoMovimentacao;
import com.ratacheski.desafiozitrusapi.domain.model.MovimentoEstoque;
import com.ratacheski.desafiozitrusapi.domain.repository.MovimentoEstoqueRepository;
import com.ratacheski.desafiozitrusapi.exception.BussinessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class MovimentoEstoqueServiceImpl implements MovimentoEstoqueService {

    private final ProdutoService produtoService;
    private final MovimentoEstoqueRepository repository;

    public MovimentoEstoqueServiceImpl(ProdutoService produtoService, MovimentoEstoqueRepository repository) {
        this.produtoService = produtoService;
        this.repository = repository;
    }

    @Override
    @Transactional
    public MovimentoEstoque movimentar(UUID codigoProduto, MovimentoEstoque movimentoEstoque) {
        var produto = produtoService.obterPorCodigo(codigoProduto);
        if (movimentoEstoque.getTipoMovimentacao().equals(TipoMovimentacao.SAIDA)) {
            if (movimentoEstoque.getQuantidadeMovimentada().compareTo(produto.getQuantidadeEstoque()) > 0)
                throw new BussinessException("Quantidade solicitada para saída maior que a disponível em estoque");
            produto.setQuantidadeEstoque(
                    produto.getQuantidadeEstoque().subtract(movimentoEstoque.getQuantidadeMovimentada())
            );
        } else {
            produto.setQuantidadeEstoque(
                    produto.getQuantidadeEstoque().add(movimentoEstoque.getQuantidadeMovimentada())
            );
        }
        movimentoEstoque.setDataVenda(OffsetDateTime.now());
        movimentoEstoque.setProduto(produto);
        return repository.save(movimentoEstoque);
    }
}
