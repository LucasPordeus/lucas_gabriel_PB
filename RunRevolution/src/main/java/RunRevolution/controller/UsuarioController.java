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

import RunRevolution.model.domain.Usuario;
import RunRevolution.model.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@Api(value = "UsuarioController", tags = "Usuario Controller")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/listar")
    @ApiOperation(value = "Obter lista de usuarios", response = List.class)
    public List<Usuario> obterLista(){
        return (List<Usuario>) usuarioService.obterLista();
    }

    @PostMapping(value = "/incluir")
    @ApiOperation(value = "Incluir novo usuario")
    public void incluir(@RequestBody Usuario usuario) {
        usuarioService.incluir(usuario);
    }

    @PutMapping(value = "/{id}/atualizar")
    @ApiOperation(value = "Atualizar usuario existente")
    public void atualizar(@PathVariable @ApiParam(value = "ID do usuario a ser atualizado", required = true)  Integer id,
                          @RequestBody @ApiParam(value = "Dados do usuario atualizado", required = true) Usuario usuario) {
        usuario.setId(id);
        usuarioService.atualizar(usuario);
    }

    @DeleteMapping(value = "/{id}/excluir")
    @ApiOperation(value = "Excluir um usuario pelo ID")
    public void excluir(@PathVariable Integer id) {
        usuarioService.excluir(id);
    }
}
