package br.ada.pedidodecompra.pedidodecompra.services;

import br.ada.pedidodecompra.pedidodecompra.dto.ClienteDTO;
import br.ada.pedidodecompra.pedidodecompra.entities.Cliente;
import br.ada.pedidodecompra.pedidodecompra.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastraCliente(Cliente cliente) {
        
        Optional<Cliente> clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        
        if (clienteExistente.isPresent()) {
            throw new RuntimeException("Cliente já cadastrado.");
        }

        String senhaCriptografada = passwordEncoder.encode(cliente.getSenha());
        cliente.setSenha(senhaCriptografada);
        
        return clienteRepository.save(cliente);
        
    }
    
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente encontrarCliente(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
    }

    public void deletarCliente(Integer clienteId) {
        clienteRepository.deleteById(clienteId);
    }

    public Cliente atualizar(Integer clienteId, ClienteDTO cliente) {

        Cliente clienteExiste = clienteRepository.findAll().stream()
                .filter(c -> c.getId().equals(clienteId))
                .findFirst()
                .orElse(null);
        
        if (clienteExiste == null) throw new RuntimeException("Cliente não existe.");
        
        if (cliente.getNome() != null) clienteExiste.setNome(cliente.getNome());
        if (cliente.getCpf() != null) clienteExiste.setCpf(cliente.getCpf());
        if (cliente.getEmail() != null) clienteExiste.setEmail(cliente.getEmail());
        
        return clienteRepository.save(clienteExiste);
        
    }
    
}
