package RunRevolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RunRevolution.model.domain.Pedido;
import RunRevolution.model.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/listar")
    public List<Pedido> obterLista(){
        return (List<Pedido>) pedidoService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Pedido pedido) {
        pedidoService.incluir(pedido);
    }

    @PutMapping(value = "/{id}/atualizar")
    public void atualizar(@PathVariable Integer id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        pedidoService.atualizar(pedido);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        pedidoService.excluir(id);
    }
}
