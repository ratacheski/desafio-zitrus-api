package com.ratacheski.desafiozitrusapi.domain.repository;

import com.ratacheski.desafiozitrusapi.domain.enums.TipoProduto;
import com.ratacheski.desafiozitrusapi.domain.model.MovimentoEstoque;
import com.ratacheski.desafiozitrusapi.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque, UUID> {

    List<MovimentoEstoque> findAllByProduto(Produto produto);

    @Query("select sum(m.quantidadeMovimentada) " +
            "from MovimentoEstoque m " +
            "where m.produto.codigo = :codigoProduto " +
            "and m.tipoMovimentacao = com.ratacheski.desafiozitrusapi.domain.enums.TipoMovimentacao.SAIDA")
    BigDecimal obterTotalSaidaPorProduto(UUID codigoProduto);
}
