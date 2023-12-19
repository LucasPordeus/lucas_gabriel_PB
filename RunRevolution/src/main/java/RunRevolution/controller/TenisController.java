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

import RunRevolution.model.domain.Tenis;
import RunRevolution.model.service.TenisService;

import java.util.List;

@RestController
@RequestMapping("/api/tenis")
@Api(value = "TenisController", tags = "Tenis Controller")
public class TenisController {
    @Autowired
    private TenisService tenisService;

    @GetMapping(value = "/listar")
    @ApiOperation(value = "Obter lista de tenis", response = List.class)
    public List<Tenis> obterLista(){
        return (List<Tenis>) tenisService.obterLista();
    }

    @PostMapping(value = "/incluir")
    @ApiOperation(value = "Incluir novo tenis")
    public void incluir(@RequestBody Tenis tenis) {
        tenisService.incluir(tenis);
    }

    @PutMapping(value = "/{id}/atualizar")
    @ApiOperation(value = "Atualizar tenis existente")
    public void atualizar(@PathVariable @ApiParam(value = "ID do tenis a ser atualizado", required = true) Integer id,
                          @RequestBody @ApiParam(value = "Dados do tenis atualizado", required = true) Tenis tenis) {
        tenis.setId(id);
        tenisService.atualizar(tenis);
    }

    @DeleteMapping(value = "/{id}/excluir")
    @ApiOperation(value = "Excluir um tenis pelo ID")
    public void excluir(@PathVariable Integer id) {
        tenisService.excluir(id);
    }
}
