package com.ratacheski.desafiozitrusapi.model;

import com.ratacheski.desafiozitrusapi.enums.TipoProduto;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGENERATOR")
    @Column(name = "codigo")
    @ColumnDefault("random_uuid()")
    private UUID codigo;

    private String descricao;

    private TipoProduto tipo;

    @Column(name = "valor_fornecedor")
    private BigDecimal valorFornecedor;

    @Column(name = "quantidade_estoque")
    private BigDecimal quantidadeEstoque;

}
