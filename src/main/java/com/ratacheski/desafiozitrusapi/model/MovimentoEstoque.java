package com.ratacheski.desafiozitrusapi.model;

import com.ratacheski.desafiozitrusapi.enums.TipoMovimentacao;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
public class MovimentoEstoque {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @ColumnDefault("random_uuid()")
    private UUID id;

    @ManyToOne(optional = false)
    private Produto produto;

    private TipoMovimentacao tipoMovimentacao;

    @Column(name = "valor_venda")
    private BigDecimal valorVenda;

    @Column(name = "data_venda")
    private OffsetDateTime dataVenda;

    @Column(name = "qtd_movimentada")
    private BigDecimal quantidadeMovimentada;
}
