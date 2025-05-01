package br.ada.pedidodecompra.pedidodecompra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Data
@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    @NotEmpty(message = "Nome obrigatório")
    private String nome;

    @Column(name = "email")
    @NotEmpty(message = "Email obrigatório")
    private String email;

    @Column(name = "cpf", length = 11)
    @NotEmpty(message = "cpf é obrigatório")
    @CPF(message = "informe um cpf válido")
    private String cpf;

    @NotBlank
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}
