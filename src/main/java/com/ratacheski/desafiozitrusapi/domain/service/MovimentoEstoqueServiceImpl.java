package com.ratacheski.desafiozitrusapi.domain.service;

import com.ratacheski.desafiozitrusapi.api.dto.LucroProdutoDTO;
import com.ratacheski.desafiozitrusapi.domain.enums.TipoMovimentacao;
import com.ratacheski.desafiozitrusapi.domain.model.MovimentoEstoque;
import com.ratacheski.desafiozitrusapi.domain.model.Produto;
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

        popularMovimentoEstoque(movimentoEstoque, produto);

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
            //foi levado em conta que uma movimentação de entrada define um novo valor para o produto;
            produto.setValorFornecedor(movimentoEstoque.getValorVenda());
            movimentoEstoque.setValorVenda(null);
        }
        return repository.save(movimentoEstoque);
    }

    @Override
    public LucroProdutoDTO obterLucroProduto(UUID codigoProduto) {
        var produto = produtoService.obterPorCodigo(codigoProduto);
        return repository.obterLucroProduto(produto);
    }

    private void popularMovimentoEstoque(MovimentoEstoque movimentoEstoque, Produto produto) {
        movimentoEstoque.setDataVenda(OffsetDateTime.now());
        movimentoEstoque.setValorCusto(produto.getValorFornecedor());
        movimentoEstoque.setProduto(produto);
    }
}
