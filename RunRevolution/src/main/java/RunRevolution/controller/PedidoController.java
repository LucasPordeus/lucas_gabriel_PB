package RunRevolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import RunRevolution.model.domain.Pedido;
import RunRevolution.model.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
@Api(value = "PedidoController", tags = "Pedido Controller")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/listar")
    @ApiOperation(value = "Obter lista de pedidos", response = List.class)
    public List<Pedido> obterLista(){
        return (List<Pedido>) pedidoService.obterLista();
    }

    @PostMapping(value = "/incluir")
    @ApiOperation(value = "Incluir um novo pedido")
    public void incluir(@RequestBody Pedido pedido) {
        pedidoService.incluir(pedido);
    }

    @PutMapping(value = "/{id}/atualizar")
    @ApiOperation(value = "Atualizar um pedido existente")
    public void atualizar(@PathVariable @ApiParam(value = "ID do pedido a ser atualizado", required = true) Integer id,
                          @RequestBody @ApiParam(value = "Dados do pedido atualizado", required = true) Pedido pedido) {
        pedido.setId(id);
        pedidoService.atualizar(pedido);
    }

    @DeleteMapping(value = "/{id}/excluir")
    @ApiOperation(value = "Excluir um pedido pelo ID")
    public void excluir(@PathVariable @ApiParam(value = "ID do pedido a ser excluído", required = true) Integer id) {
        pedidoService.excluir(id);
    }
}
