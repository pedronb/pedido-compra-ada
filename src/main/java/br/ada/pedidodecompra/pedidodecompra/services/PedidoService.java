package br.ada.pedidodecompra.pedidodecompra.services;

import br.ada.pedidodecompra.pedidodecompra.dto.ItemPedidoDTO;
import br.ada.pedidodecompra.pedidodecompra.entities.Cliente;
import br.ada.pedidodecompra.pedidodecompra.entities.ItemPedido;
import br.ada.pedidodecompra.pedidodecompra.entities.Pedido;
import br.ada.pedidodecompra.pedidodecompra.entities.Produto;
import br.ada.pedidodecompra.pedidodecompra.repositorys.ClienteRepository;
import br.ada.pedidodecompra.pedidodecompra.repositorys.PedidoRepository;
import br.ada.pedidodecompra.pedidodecompra.repositorys.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private ProdutoRepository produtoRepository;
    private ClienteRepository clienteRepository;

    public Pedido realizarPedido(Integer clienteId, List<ItemPedidoDTO> itens) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não enontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        for (ItemPedidoDTO dto : itens) {
            Produto produto = produtoRepository.findById(dto.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            if (produto.getEstoque() < dto.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente");
            }

            produto.setEstoque(produto.getEstoque() - dto.getQuantidade());

            ItemPedido item = new ItemPedido();
            item.setProduto(produto);
            item.setQuantidade(dto.getQuantidade());
            item.setPrecoUnitario(produto.getPreco());
            item.setPedido(pedido);
            pedido.getItens().add(item);
        }

        pedidoRepository.save(pedido);
        return pedido;

    }
}
