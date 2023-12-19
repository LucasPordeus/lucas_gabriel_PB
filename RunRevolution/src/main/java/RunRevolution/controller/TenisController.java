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

import RunRevolution.model.domain.Tenis;
import RunRevolution.model.service.TenisService;

import java.util.List;

@RestController
@RequestMapping("/api/tenis")
public class TenisController {
    @Autowired
    private TenisService tenisService;

    @GetMapping(value = "/listar")
    public List<Tenis> obterLista(){
        return (List<Tenis>) tenisService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Tenis tenis) {
        tenisService.incluir(tenis);
    }

    @PutMapping(value = "/{id}/atualizar")
    public void atualizar(@PathVariable Integer id, @RequestBody Tenis tenis) {
        tenis.setId(id);
        tenisService.atualizar(tenis);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        tenisService.excluir(id);
    }
}
