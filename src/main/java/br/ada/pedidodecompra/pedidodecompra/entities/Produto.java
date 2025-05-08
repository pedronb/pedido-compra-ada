package br.ada.pedidodecompra.pedidodecompra.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

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

    @Column
    @Positive
    private Double preco;

    @Column(name = "estoque")
    @Min(0)
    private int estoque;

    public Produto() {
    }

    public Produto(Integer id, String nome, Double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "Nome do produto obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty(message = "Nome do produto obrigatório") String nome) {
        this.nome = nome;
    }

    public  @Positive Double getPreco() {
        return preco;
    }

    public void setPreco( @Positive Double preco) {
        this.preco = preco;
    }

    @Min(0)
    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(@Min(0) int estoque) {
        this.estoque = estoque;
    }
    
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }
}
