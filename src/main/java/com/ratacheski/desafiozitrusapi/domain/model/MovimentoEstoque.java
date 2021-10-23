package com.ratacheski.desafiozitrusapi.domain.model;

import com.ratacheski.desafiozitrusapi.domain.enums.TipoMovimentacao;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "movimento_estoque")
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

    private BigDecimal valorVenda;

    private OffsetDateTime dataVenda;

    @Column(name = "qtd_movimentada")
    private BigDecimal quantidadeMovimentada;
}
