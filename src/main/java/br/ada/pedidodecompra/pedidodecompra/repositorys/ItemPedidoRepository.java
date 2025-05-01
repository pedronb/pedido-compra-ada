package br.ada.pedidodecompra.pedidodecompra.repositorys;

import br.ada.pedidodecompra.pedidodecompra.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
