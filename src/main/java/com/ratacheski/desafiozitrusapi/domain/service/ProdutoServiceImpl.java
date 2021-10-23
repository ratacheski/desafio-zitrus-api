package com.ratacheski.desafiozitrusapi.domain.service;

import com.ratacheski.desafiozitrusapi.api.dto.ProdutoPorTipoOut;
import com.ratacheski.desafiozitrusapi.api.mapper.MapStructMapper;
import com.ratacheski.desafiozitrusapi.domain.enums.TipoProduto;
import com.ratacheski.desafiozitrusapi.domain.model.Produto;
import com.ratacheski.desafiozitrusapi.domain.repository.MovimentoEstoqueRepository;
import com.ratacheski.desafiozitrusapi.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final MovimentoEstoqueRepository estoqueRepository;
    private final MapStructMapper mapper;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, MovimentoEstoqueRepository estoqueRepository, MapStructMapper mapper) {
        this.produtoRepository = produtoRepository;
        this.estoqueRepository = estoqueRepository;
        this.mapper = mapper;
    }


    @Override
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto obterPorCodigo(UUID codigo) {
        return produtoRepository.findById(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o código " + codigo));
    }

    @Override
    public Produto criar(Produto produto) {
        if (produtoRepository.findByDescricao(produto.getDescricao()).isPresent())
            throw new EntityExistsException("Produto já cadastrado com a descrição " + produto.getDescricao());
        return produtoRepository.save(produto);
    }

    @Override
    public Produto atualizar(UUID codigo, Produto produto) {
        var byId = obterPorCodigo(codigo);
        produto.setCodigo(byId.getCodigo());
        return produtoRepository.save(produto);
    }

    @Override
    public void remover(UUID codigo) {
        obterPorCodigo(codigo);
        produtoRepository.deleteById(codigo);
    }

    @Override
    public List<ProdutoPorTipoOut> consultarPorTipoComQuantidadeSaida(Integer tipo) {
        List<ProdutoPorTipoOut> outs = new ArrayList<>();
        var produtos = produtoRepository.findProdutosByTipo(TipoProduto.getByCodigo(tipo));
        produtos.forEach(produto -> {
            var totalSaida = estoqueRepository.obterTotalSaidaPorProduto(produto.getCodigo());
            var produtoPorTipoOut = mapper.produtoToProdutoPorTipoOut(produto);
            produtoPorTipoOut.setQuantidadeSaida(totalSaida != null ? totalSaida : BigDecimal.ZERO);
            outs.add(produtoPorTipoOut);
        });
        return outs;
    }
}
