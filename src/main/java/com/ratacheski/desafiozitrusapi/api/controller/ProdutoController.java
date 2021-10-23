package com.ratacheski.desafiozitrusapi.api.controller;

import com.ratacheski.desafiozitrusapi.api.dto.ProdutoDTO;
import com.ratacheski.desafiozitrusapi.api.mapper.MapStructMapper;
import com.ratacheski.desafiozitrusapi.domain.model.Produto;
import com.ratacheski.desafiozitrusapi.domain.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    private final MapStructMapper mapStructMapper;

    private final ProdutoService produtoService;

    public ProdutoController(MapStructMapper mapStructMapper, ProdutoService produtoService) {
        this.mapStructMapper = mapStructMapper;
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<ProdutoDTO> listar() {
        var produtos = produtoService.listar();
        return produtos
                .stream()
                .map(produto -> mapStructMapper.ProdutoToProdutoDto(produto))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ProdutoDTO criar(@Valid @RequestBody ProdutoDTO produtoDTO) {
        var produto = mapStructMapper.ProdutoDtoToProduto(produtoDTO);
        return mapStructMapper.ProdutoToProdutoDto(produtoService.criar(produto));
    }
}
