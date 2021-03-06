package com.ratacheski.desafiozitrusapi.api.controller;

import com.ratacheski.desafiozitrusapi.api.dto.LucroProdutoDTO;
import com.ratacheski.desafiozitrusapi.api.dto.MovimentoInput;
import com.ratacheski.desafiozitrusapi.api.dto.MovimentoOutput;
import com.ratacheski.desafiozitrusapi.api.mapper.MapStructMapper;
import com.ratacheski.desafiozitrusapi.domain.model.MovimentoEstoque;
import com.ratacheski.desafiozitrusapi.domain.service.MovimentoEstoqueService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/produtos/{codigo}")
public class EstoqueController {

    private final MovimentoEstoqueService service;

    private final MapStructMapper mapper;

    public EstoqueController(MovimentoEstoqueService service, MapStructMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping(path = "/estoque")
    public MovimentoOutput adicionarMovimentacaoEstoque(@PathVariable("codigo") UUID codigoProduto, @RequestBody MovimentoInput movimentoInput){
        var movimentoEstoque = service.movimentar(codigoProduto, mapper.movimentoInputToMovimentoEstoque(movimentoInput));
        return mapper.movimentoEstoqueToMovimentoOutput(movimentoEstoque);
    }

    @GetMapping(path = "/lucro")
    public LucroProdutoDTO obterLucroProduto(@PathVariable("codigo") UUID codigoProduto){
        return service.obterLucroProduto(codigoProduto);
    }

}
