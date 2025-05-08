package br.ada.pedidodecompra.pedidodecompra.dto;

import br.ada.pedidodecompra.pedidodecompra.entities.Cliente;


public class ClienteDTO {
    
    private String nome;
    private String cpf;
    private String email;

    public ClienteDTO(){}
    
    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
