package RunRevolution.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RunRevolution.model.domain.Pedido;
import RunRevolution.model.repositories.PedidoRepository;
import RunRevolution.exceptions.PedidoNaoEncontradoException;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public void incluir(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public Collection<Pedido> obterLista() {
        return (Collection<Pedido>) pedidoRepository.findAll();
    }

    public void excluir(Integer id) {
        pedidoRepository.deleteById(id);
    }

    public void atualizar(Pedido pedido) {
        Optional<Pedido> pedidoExistenteOptional = pedidoRepository.findById(pedido.getId());

        if (pedidoExistenteOptional.isPresent()) {
            Pedido pedidoExistente = pedidoExistenteOptional.get();
            pedidoExistente.setData(pedido.getData());
            pedidoExistente.setDescricao(pedido.getDescricao());
            pedidoExistente.setStatus(pedido.getStatus());
            pedidoExistente.setUsuario(pedido.getUsuario());
            pedidoExistente.setProdutos(pedido.getProdutos());

            pedidoRepository.save(pedidoExistente);
        } else {
            throw new PedidoNaoEncontradoException("Pedido com ID " + pedido.getId() + " não encontrado.");
        }
    }
}
