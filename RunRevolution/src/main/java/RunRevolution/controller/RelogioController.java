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

import RunRevolution.model.domain.Relogio;
import RunRevolution.model.service.RelogioService;

import java.util.List;

@RestController
@RequestMapping("/api/relogio")
public class RelogioController {
    @Autowired
    private RelogioService relogioService;

    @GetMapping(value = "/listar")
    public List<Relogio> obterLista(){
        return (List<Relogio>) relogioService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Relogio relogio) {
        relogioService.incluir(relogio);
    }

    @PutMapping(value = "/{id}/atualizar")
    public void atualizar(@PathVariable Integer id, @RequestBody Relogio relogio) {
        relogio.setId(id);
        relogioService.atualizar(relogio);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        relogioService.excluir(id);
    }
}
