package br.ada.pedidodecompra.pedidodecompra.controllers;

import br.ada.pedidodecompra.pedidodecompra.entities.Cliente;
import br.ada.pedidodecompra.pedidodecompra.repositorys.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody @Valid Cliente cliente) {
        return cliente;
    }
}
