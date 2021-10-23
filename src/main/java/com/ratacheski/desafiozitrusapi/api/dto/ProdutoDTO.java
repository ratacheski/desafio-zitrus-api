package com.ratacheski.desafiozitrusapi.api.dto;

import com.ratacheski.desafiozitrusapi.domain.enums.TipoProduto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProdutoDTO {
    private UUID codigo;
    @NotBlank
    @Size(max = 255)
    private String descricao;
    @NotNull
    @Min(0)
    private BigDecimal valorFornecedor;
    @NotNull
    @Min(0)
    private BigDecimal quantidadeEstoque;
    @NotNull
    private TipoProduto tipo;
}
