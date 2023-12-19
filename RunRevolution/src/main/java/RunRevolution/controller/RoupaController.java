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

import RunRevolution.model.domain.Roupa;
import RunRevolution.model.service.RoupaService;

import java.util.List;

@RestController
@RequestMapping("/api/roupa")
@Api(value = "RoupaController", tags = "Roupa Controller")
public class RoupaController {
    @Autowired
    private RoupaService roupaService;

    @GetMapping(value = "/listar")
    @ApiOperation(value = "Obter lista de roupas", response = List.class)
    public List<Roupa> obterLista(){
        return (List<Roupa>) roupaService.obterLista();
    }

    @PostMapping(value = "/incluir")
    @ApiOperation(value = "Incluir nova roupa")
    public void incluir(@RequestBody Roupa roupa) {
        roupaService.incluir(roupa);
    }

    @PutMapping(value = "/{id}/atualizar")
    @ApiOperation(value = "Atualizar roupa existente")
    public void atualizar(@PathVariable @ApiParam(value = "ID da roupa a ser atualizado", required = true) Integer id,
                          @RequestBody @ApiParam(value = "Dados da roupa atualizada", required = true) Roupa roupa) {
        roupa.setId(id);
        roupaService.atualizar(roupa);
    }

    @DeleteMapping(value = "/{id}/excluir")
    @ApiOperation(value = "Excluir uma roupa pelo ID")
    public void excluir(@PathVariable Integer id) {
        roupaService.excluir(id);
    }
}
