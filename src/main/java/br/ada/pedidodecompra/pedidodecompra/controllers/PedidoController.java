package br.ada.pedidodecompra.pedidodecompra.controllers;

import br.ada.pedidodecompra.pedidodecompra.dto.ItemPedidoDTO;
import br.ada.pedidodecompra.pedidodecompra.entities.Pedido;
import br.ada.pedidodecompra.pedidodecompra.services.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService pedidoService;
    
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
    
    @PostMapping("/{clienteId}")
    public ResponseEntity<?> realizar(@PathVariable Integer clienteId, @RequestBody List<ItemPedidoDTO> itens) {
        Pedido pedido = pedidoService.realizarPedido(clienteId, itens);
        
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pedido);
    }

    @GetMapping
    public ResponseEntity<Object> listarPedidos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

}
