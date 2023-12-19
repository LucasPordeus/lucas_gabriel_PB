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

import RunRevolution.model.domain.Roupa;
import RunRevolution.model.service.RoupaService;

import java.util.List;

@RestController
@RequestMapping("/api/roupa")
public class RoupaController {
    @Autowired
    private RoupaService roupaService;

    @GetMapping(value = "/listar")
    public List<Roupa> obterLista(){
        return (List<Roupa>) roupaService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Roupa roupa) {
        roupaService.incluir(roupa);
    }

    @PutMapping(value = "/{id}/atualizar")
    public void atualizar(@PathVariable Integer id, @RequestBody Roupa roupa) {
        roupa.setId(id);
        roupaService.atualizar(roupa);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        roupaService.excluir(id);
    }
}
