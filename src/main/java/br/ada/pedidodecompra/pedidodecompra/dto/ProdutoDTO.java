package br.ada.pedidodecompra.pedidodecompra.dto;

public class ProdutoDTO {
    private String nome;
    private Double preco;
    private int estoque;
    
    public ProdutoDTO() {
    }
    
    public ProdutoDTO(String nome, Double preco, Integer estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Double getPreco() {
        return preco;
    }
    
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public Integer getEstoque() {
        return estoque;
    }
    
    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
    
}
