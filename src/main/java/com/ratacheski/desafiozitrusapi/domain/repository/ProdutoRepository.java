package com.ratacheski.desafiozitrusapi.domain.repository;

import com.ratacheski.desafiozitrusapi.domain.enums.TipoProduto;
import com.ratacheski.desafiozitrusapi.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
    Optional<Produto> findByDescricao(String descricao);
    List<Produto> findProdutosByTipo(TipoProduto tipoProduto);
}
