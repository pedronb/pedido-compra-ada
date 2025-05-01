package br.ada.pedidodecompra.pedidodecompra.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column
    @NotEmpty(message = "Nome do produto obrigatório")
    private String nome;

    @Column(name = "preco_produto")
    @NotNull(message = "preço obrigatório")
    @Positive
    private Double preco;

    @Column(name = "estoque")
    @Min(0)
    private int estoque;

}
