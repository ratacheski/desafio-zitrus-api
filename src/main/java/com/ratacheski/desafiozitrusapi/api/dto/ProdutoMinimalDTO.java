package com.ratacheski.desafiozitrusapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProdutoMinimalDTO {
    private UUID codigo;
    private String descricao;
}
