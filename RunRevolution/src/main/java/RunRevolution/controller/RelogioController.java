package RunRevolution.controller;

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

import RunRevolution.model.domain.Relogio;
import RunRevolution.model.service.RelogioService;

import java.util.List;

@RestController
@RequestMapping("/api/relogio")
@Api(value = "RelogioController", tags = "Relogio Controller")
public class RelogioController {
    @Autowired
    private RelogioService relogioService;

    @GetMapping(value = "/listar")
    @ApiOperation(value = "Obter lista de relogios", response = List.class)
    public List<Relogio> obterLista(){
        return (List<Relogio>) relogioService.obterLista();
    }

    @PostMapping(value = "/incluir")
    @ApiOperation(value = "Incluir um novo relogio")
    public void incluir(@RequestBody Relogio relogio) {
        relogioService.incluir(relogio);
    }

    @PutMapping(value = "/{id}/atualizar")
    @ApiOperation(value = "Atualizar um relogio existente")
    public void atualizar(@PathVariable @ApiParam(value = "ID do relogio a ser atualizado", required = true) Integer id,
                          @RequestBody @ApiParam(value = "Dados do relogio atualizado", required = true) Relogio relogio) {
        relogio.setId(id);
        relogioService.atualizar(relogio);
    }

    @DeleteMapping(value = "/{id}/excluir")
    @ApiOperation(value = "Excluir um produto pelo ID")
    public void excluir(@PathVariable Integer id) {
        relogioService.excluir(id);
    }
}
