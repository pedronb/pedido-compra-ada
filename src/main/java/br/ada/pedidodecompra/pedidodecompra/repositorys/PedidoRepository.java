package br.ada.pedidodecompra.pedidodecompra.repositorys;

import br.ada.pedidodecompra.pedidodecompra.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
