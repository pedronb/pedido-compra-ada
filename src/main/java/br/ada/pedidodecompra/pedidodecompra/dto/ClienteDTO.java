package br.ada.pedidodecompra.pedidodecompra.dto;

import br.ada.pedidodecompra.pedidodecompra.entities.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private String email;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
    }
}
