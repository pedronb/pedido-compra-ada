package br.ada.pedidodecompra.pedidodecompra.services;

import br.ada.pedidodecompra.pedidodecompra.dto.ClienteDTO;
import br.ada.pedidodecompra.pedidodecompra.entities.Cliente;
import br.ada.pedidodecompra.pedidodecompra.repositorys.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteDTO cadastraCliente(Cliente cliente) {

        if (clienteRepository.findByEmail(cliente.getEmail()) != null) {
            throw new RuntimeException("Cliente ja cadastrado com esse email");
        }

        Cliente clienteSalvo = clienteRepository.save(cliente);
        return new ClienteDTO(clienteSalvo);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public ClienteDTO encontrarCliente(String clienteEmail) {
        return clienteRepository.findByEmail(clienteEmail);
    }

    public void deletarCliente(Integer clienteId) {
        clienteRepository.deleteById(clienteId);
    }

    public Cliente atualizar(Integer clienteId, ClienteDTO clienteDTO) {

        Optional<Cliente> c = clienteRepository.findById(clienteId);

        if (c.isEmpty()) throw new RuntimeException("Cliente não encontrado.");

        Cliente cliente = c.get();

        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());

        Cliente clienteAtualizado = clienteRepository.save(cliente);

        return clienteAtualizado;

    }
}
