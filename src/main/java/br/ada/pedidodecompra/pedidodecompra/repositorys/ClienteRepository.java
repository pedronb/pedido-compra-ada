package br.ada.pedidodecompra.pedidodecompra.repositorys;

import br.ada.pedidodecompra.pedidodecompra.dto.ClienteDTO;
import br.ada.pedidodecompra.pedidodecompra.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
