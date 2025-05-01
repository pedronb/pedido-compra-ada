package br.ada.pedidodecompra.pedidodecompra.controllers;

import br.ada.pedidodecompra.pedidodecompra.entities.Produto;
import br.ada.pedidodecompra.pedidodecompra.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrarProduto(@RequestBody @Valid Produto produto) {
        return produtoService.cadastrar(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable Integer id) {
        return produtoService.burcarProduto(id);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Integer id, @RequestBody @Valid Produto produto) {
        return produtoService.atualizar(id, produto);
    }

}
