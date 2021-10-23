package com.ratacheski.desafiozitrusapi.domain.service;

import com.ratacheski.desafiozitrusapi.domain.model.Produto;
import com.ratacheski.desafiozitrusapi.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
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
    public Produto atualizar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void remover(UUID codigo) {
        obterPorCodigo(codigo);
        produtoRepository.deleteById(codigo);
    }
}
