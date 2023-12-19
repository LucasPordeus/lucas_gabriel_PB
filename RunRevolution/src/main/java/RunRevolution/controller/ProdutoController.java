package RunRevolution.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import RunRevolution.model.domain.Produto;
import RunRevolution.model.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
@Api(value = "ProdutoController", tags = "Produto Controller")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/listar")
    @ApiOperation(value = "Obter lista de produtos", response = List.class)
    public List<Produto> obterLista(){
        return (List<Produto>) produtoService.obterLista();
    }

    @PostMapping(value = "/incluir")
    @ApiOperation(value = "Incluir um novo produto")
    public void incluir(@RequestBody Produto produto) {
        produtoService.incluir(produto);
    }

    @PutMapping(value = "/{id}/atualizar")
    @ApiOperation(value = "Atualizar um produto existente")
    public void atualizar(@PathVariable @ApiParam(value = "ID do produto a ser atualizado", required = true) Integer id,
                          @RequestBody @ApiParam(value = "Dados do produto atualizado", required = true) Produto produto) {
        produto.setId(id);
        produtoService.atualizar(produto);
    }

    @DeleteMapping(value = "/{id}/excluir")
    @ApiOperation(value = "Excluir um produto pelo ID")
    public void excluir(@PathVariable Integer id) {
        produtoService.excluir(id);
    }
}
