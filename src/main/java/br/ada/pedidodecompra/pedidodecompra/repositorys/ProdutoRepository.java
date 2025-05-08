package br.ada.pedidodecompra.pedidodecompra.repositorys;

import br.ada.pedidodecompra.pedidodecompra.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByNome(String nome);
}
