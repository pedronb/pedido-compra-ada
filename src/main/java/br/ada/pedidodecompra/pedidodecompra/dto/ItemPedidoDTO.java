package br.ada.pedidodecompra.pedidodecompra.dto;

import lombok.Data;

@Data
public class ItemPedidoDTO {
    private Integer produtoId;
    private Integer quantidade;

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
