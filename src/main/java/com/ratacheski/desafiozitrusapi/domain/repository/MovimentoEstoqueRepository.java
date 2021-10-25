package com.ratacheski.desafiozitrusapi.domain.repository;

import com.ratacheski.desafiozitrusapi.api.dto.LucroProdutoDTO;
import com.ratacheski.desafiozitrusapi.domain.model.MovimentoEstoque;
import com.ratacheski.desafiozitrusapi.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque, UUID> {

    @Query("select sum(m.quantidadeMovimentada) " +
            "from MovimentoEstoque m " +
            "where m.produto.codigo = :codigoProduto " +
            "and m.tipoMovimentacao = com.ratacheski.desafiozitrusapi.domain.enums.TipoMovimentacao.SAIDA")
    BigDecimal obterTotalSaidaPorProduto(UUID codigoProduto);

    @SuppressWarnings("JpaQlInspection")
    @Query("select new com.ratacheski.desafiozitrusapi.api.dto.LucroProdutoDTO(" +
            "m.produto, " +
            "sum(m.quantidadeMovimentada * (m.valorVenda - m.valorCusto))," +
            "sum(m.quantidadeMovimentada))" +
            "from MovimentoEstoque m " +
            "where m.produto = :produto " +
            "and m.tipoMovimentacao = com.ratacheski.desafiozitrusapi.domain.enums.TipoMovimentacao.SAIDA " +
            "group by m.produto")
    LucroProdutoDTO obterLucroProduto(Produto produto);
}
