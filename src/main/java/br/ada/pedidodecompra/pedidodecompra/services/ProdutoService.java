package br.ada.pedidodecompra.pedidodecompra.services;

import br.ada.pedidodecompra.pedidodecompra.dto.ProdutoDTO;
import br.ada.pedidodecompra.pedidodecompra.entities.Produto;
import br.ada.pedidodecompra.pedidodecompra.repositorys.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrar(Produto produto) {
        
        Optional<Produto> produtoExiste = produtoRepository.findByNome(produto.getNome());
        
        if (produtoExiste.isPresent()) throw new RuntimeException("Produto já cadastrado.");
        
        return produtoRepository.save(produto);
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto burcarProduto(Integer produtoId) {
        return produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    public Produto atualizar(Integer id, ProdutoDTO produtoAtualizado) {
        Produto produtoExiste = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não existe"));

        if(produtoAtualizado.getNome() != null) produtoExiste.setNome(produtoAtualizado.getNome());
        if(produtoAtualizado.getPreco() != null) produtoExiste.setPreco(produtoAtualizado.getPreco());
        if(produtoAtualizado.getEstoque() != 0) produtoExiste.setEstoque(produtoAtualizado.getEstoque());

        return produtoRepository.save(produtoExiste);
    }
}
