package br.ada.pedidodecompra.pedidodecompra.entities;

import br.ada.pedidodecompra.pedidodecompra.enums.StatusPedido;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

    private Integer id;
    private Cliente cliente;
    private LocalDate dataDoPedido;
    private Double valorTotal;
    private StatusPedido statusPedido;
    private List<?> itens;

}
