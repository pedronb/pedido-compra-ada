package br.ada.pedidodecompra.pedidodecompra.controllers;

import br.ada.pedidodecompra.pedidodecompra.dto.ClienteDTO;
import br.ada.pedidodecompra.pedidodecompra.entities.Cliente;
import br.ada.pedidodecompra.pedidodecompra.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteService clienteService;
    
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid Cliente cliente) {
        clienteService.cadastraCliente(cliente);
        
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cliente);
    }

    @GetMapping
    public ResponseEntity<Object> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> retornarCliente(@PathVariable Integer id) {
        try {
            Cliente cliente = clienteService.listarClientes().stream()
                    .filter(c -> c.getId().equals(id))
                    .findFirst()
                    .orElse(null);
            
            if (cliente == null) throw new RuntimeException("Cliente não existe.");
            
            return ResponseEntity.ok(cliente);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<?> deletarCliente(@PathVariable Integer id) {
        Cliente cliente = clienteService.listarClientes().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        if (cliente == null) throw new RuntimeException("Cliente não existe");
        
        clienteService.listarClientes().remove(cliente);
        
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PatchMapping("/{clienteId}")
    public ResponseEntity<?> atualizarCliente(@PathVariable Integer clienteId, @RequestBody @Valid ClienteDTO cliente) {
        Cliente atualizado = clienteService.atualizar(clienteId, cliente);
        return ResponseEntity.ok(atualizado);
    }

}
