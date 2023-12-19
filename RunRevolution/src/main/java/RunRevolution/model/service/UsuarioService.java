package RunRevolution.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RunRevolution.model.domain.Usuario;
import RunRevolution.model.domain.Endereco;
import RunRevolution.model.repositories.UsuarioRepository;
import RunRevolution.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoService enderecoService;

    public void incluir(Usuario usuario){

        String cep = usuario.getEndereco().getCep();

        Endereco endereco = enderecoService.buscarCep(cep);

        usuario.setEndereco(endereco);

        usuarioRepository.save(usuario);
    }

    public Collection<Usuario> obterLista(){
        return (Collection<Usuario>) usuarioRepository.findAll();
    }

    public void excluir(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public void atualizar(Usuario usuario) {
        Optional<Usuario> usuarioExistenteOptional = usuarioRepository.findById(usuario.getId());

        if (usuarioExistenteOptional.isPresent()) {
            Usuario usuarioExistente = usuarioExistenteOptional.get();
            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setAcesso(usuario.getAcesso());
            usuarioExistente.setLogin(usuario.getLogin());
            usuarioExistente.setSenha(usuario.getSenha());

            Endereco enderecoExistente = usuarioExistente.getEndereco();
            Endereco enderecoAtualizado = usuario.getEndereco();

            enderecoExistente.setCep(enderecoAtualizado.getCep());
            enderecoExistente.setLogradouro(enderecoAtualizado.getLogradouro());
            enderecoExistente.setComplemento(enderecoAtualizado.getComplemento());
            enderecoExistente.setBairro(enderecoAtualizado.getBairro());
            enderecoExistente.setUf(enderecoAtualizado.getUf());
            enderecoExistente.setLocalidade(enderecoAtualizado.getLocalidade());

            usuarioRepository.save(usuarioExistente);
        } else {
            throw new UsuarioNaoEncontradoException("Usuario com ID " + usuario.getId() + " não encontrado.");
        }
    }

    public Optional<Usuario> obterPorId(Integer id) {
        return usuarioRepository.findById(id);
    }
}
