package br.ada.pedidodecompra.pedidodecompra.controllers;

import br.ada.pedidodecompra.pedidodecompra.dto.ProdutoDTO;
import br.ada.pedidodecompra.pedidodecompra.entities.Produto;
import br.ada.pedidodecompra.pedidodecompra.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutoService produtoService;
    
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    
    @PostMapping
    public ResponseEntity<?> cadastrarProduto(@RequestBody @Valid Produto produto) {
        produtoService.cadastrar(produto);
        
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(produto);
    }

    @GetMapping
    public ResponseEntity<Object> listarProdutos() {
        return ResponseEntity.ok(produtoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarProdutoPorId(@PathVariable Integer id) {
        try {
            Produto produto = produtoService.listar().stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElse(null);
            
            if (produto == null) throw new RuntimeException("Produto não existe.");
            
            return ResponseEntity.ok(produto);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Integer id, @RequestBody @Valid ProdutoDTO produto) {
        Produto atualizado = produtoService.atualizar(id, produto);
        return ResponseEntity.ok(atualizado);
    }

}
