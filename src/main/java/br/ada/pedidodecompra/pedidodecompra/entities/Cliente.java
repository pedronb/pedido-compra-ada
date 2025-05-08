package br.ada.pedidodecompra.pedidodecompra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    @NotEmpty(message = "Nome obrigatório")
    private String nome;

    @Column(name = "email")
    @NotEmpty(message = "Email obrigatório")
    private String email;

    @Column(name = "cpf")
    @NotEmpty(message = "cpf é obrigatório")
    @CPF(message = "informe um cpf válido")
    private String cpf;

    @NotBlank
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, String cpf, String senha, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.pedidos = pedidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "Nome obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty(message = "Nome obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotEmpty(message = "Email obrigatório") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "Email obrigatório") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "cpf é obrigatório") @CPF(message = "informe um cpf válido") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotEmpty(message = "cpf é obrigatório") @CPF(message = "informe um cpf válido") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank String senha) {
        this.senha = senha;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                ", pedidos=" + pedidos +
                '}';
    }
}
