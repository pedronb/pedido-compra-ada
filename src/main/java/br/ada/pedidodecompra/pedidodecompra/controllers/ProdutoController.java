package br.ada.pedidodecompra.pedidodecompra.controllers;

import br.ada.pedidodecompra.pedidodecompra.entities.Produto;
import br.ada.pedidodecompra.pedidodecompra.repositorys.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrarProduto(@RequestBody @Valid Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    /*
    TODO:
        - Atualizar Produto especifico;
        - Retornar Produto especifico;
    */
}
