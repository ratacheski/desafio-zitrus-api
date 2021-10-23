package com.ratacheski.desafiozitrusapi.api.controller;

import com.ratacheski.desafiozitrusapi.api.dto.ProdutoDTO;
import com.ratacheski.desafiozitrusapi.api.mapper.MapStructMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    private final MapStructMapper mapStructMapper;

    public ProdutoController(MapStructMapper mapStructMapper) {
        this.mapStructMapper = mapStructMapper;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ProdutoDTO criar(@Valid @RequestBody ProdutoDTO produtoDTO) {
        return null;
    }
}
