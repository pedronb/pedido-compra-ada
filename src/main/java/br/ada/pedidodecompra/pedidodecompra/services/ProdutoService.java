package br.ada.pedidodecompra.pedidodecompra.services;

import br.ada.pedidodecompra.pedidodecompra.entities.Produto;
import br.ada.pedidodecompra.pedidodecompra.repositorys.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public Produto cadastrar(Produto produto) {

        return produtoRepository.save(produto);
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto burcarProduto(Integer produtoId) {
        return produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    public Produto atualizar(Integer id, Produto produtoAntigo) {
        Produto p = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        p.setNome(produtoAntigo.getNome());
        p.setPreco(produtoAntigo.getPreco());
        p.setEstoque(produtoAntigo.getEstoque());

        return produtoRepository.save(p);
    }
}
