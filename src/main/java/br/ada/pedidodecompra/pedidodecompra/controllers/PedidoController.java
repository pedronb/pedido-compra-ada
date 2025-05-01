package br.ada.pedidodecompra.pedidodecompra.controllers;

import br.ada.pedidodecompra.pedidodecompra.dto.ItemPedidoDTO;
import br.ada.pedidodecompra.pedidodecompra.entities.Pedido;
import br.ada.pedidodecompra.pedidodecompra.services.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    @PostMapping("/{clienteId}")
    public Pedido realizar(@PathVariable Integer clienteId, @RequestBody List<ItemPedidoDTO> itens) {
        return pedidoService.realizarPedido(clienteId, itens);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarTodos();
    }

    /*
    TODO:
        - Atualizar Pedido;
        - Deletar Pedido;
    */

}
