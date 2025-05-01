package br.ada.pedidodecompra.pedidodecompra.controllers;

import br.ada.pedidodecompra.pedidodecompra.dto.ClienteDTO;
import br.ada.pedidodecompra.pedidodecompra.entities.Cliente;
import br.ada.pedidodecompra.pedidodecompra.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO cadastrar(@RequestBody @Valid Cliente cliente) {
        return clienteService.cadastraCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente retornarCliente(@PathVariable Integer id) {
        return clienteService.encontrarCliente(id);
    }

    @DeleteMapping("/{clienteId}")
    public void deletarCliente(@PathVariable Integer id) {
        clienteService.deletarCliente(id);
    }

    @PutMapping("/{clienteId}")
    public Cliente atualizarCliente(@PathVariable Integer clienteId, @RequestBody @Valid ClienteDTO cliente) {
        return clienteService.atualizar(clienteId, cliente);
    }

}
