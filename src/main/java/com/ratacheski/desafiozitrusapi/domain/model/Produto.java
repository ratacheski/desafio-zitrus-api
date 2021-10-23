package com.ratacheski.desafiozitrusapi.domain.model;

import com.ratacheski.desafiozitrusapi.domain.enums.TipoProduto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "codigo")
    @ColumnDefault("random_uuid()")
    private UUID codigo;

    private String descricao;

    private TipoProduto tipo;

    private BigDecimal valorFornecedor;

    @Column(name = "qtd_estoque")
    private BigDecimal quantidadeEstoque;

}
