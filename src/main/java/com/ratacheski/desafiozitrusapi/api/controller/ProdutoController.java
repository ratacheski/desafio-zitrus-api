package com.ratacheski.desafiozitrusapi.api.controller;

import com.ratacheski.desafiozitrusapi.api.dto.ProdutoDTO;
import com.ratacheski.desafiozitrusapi.api.dto.ProdutoPorTipoOut;
import com.ratacheski.desafiozitrusapi.api.mapper.MapStructMapper;
import com.ratacheski.desafiozitrusapi.domain.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

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
                .map(mapStructMapper::produtoToProdutoDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{codigo}")
    public ProdutoDTO obterPorCodigo(@PathVariable UUID codigo){
        var produto = produtoService.obterPorCodigo(codigo);
        return mapStructMapper.produtoToProdutoDto(produto);
    }

    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable UUID codigo) {
        produtoService.remover(codigo);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ProdutoDTO criar(@Valid @RequestBody ProdutoDTO produtoDTO) {
        var produto = mapStructMapper.produtoDtoToProduto(produtoDTO);
        return mapStructMapper.produtoToProdutoDto(produtoService.criar(produto));
    }

    @PutMapping(path = "/{codigo}")
    public ProdutoDTO atualizar(@Valid @RequestBody ProdutoDTO produtoDTO, @PathVariable UUID codigo) {
        var produto = produtoService.atualizar(codigo, mapStructMapper.produtoDtoToProduto(produtoDTO));
        return mapStructMapper.produtoToProdutoDto(produto);
    }

    @GetMapping(path = "/tipo/{tipo}")
    public List<ProdutoPorTipoOut> consultarPorTipoComQuantidadeSaida(@PathVariable Integer tipo) {
        return produtoService.consultarPorTipoComQuantidadeSaida(tipo);
    }
}
