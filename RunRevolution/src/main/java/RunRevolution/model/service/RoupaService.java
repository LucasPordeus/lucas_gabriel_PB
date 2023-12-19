package RunRevolution.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RunRevolution.model.domain.Roupa;
import RunRevolution.model.repositories.RoupaRepository;
import RunRevolution.exceptions.RoupaNaoEncontradaException;

@Service
public class RoupaService {
    @Autowired
    private RoupaRepository roupaRepository;

    public void incluir(Roupa roupa){
        roupaRepository.save(roupa);
    }

    public Collection<Roupa> obterLista(){
        return (Collection<Roupa>) roupaRepository.findAll();
    }

    public void excluir(Integer id) {
        roupaRepository.deleteById(id);
    }

    public void atualizar(Roupa roupa) {
        Optional<Roupa> roupaExistenteOptional = roupaRepository.findById(roupa.getId());

        if (roupaExistenteOptional.isPresent()) {
            Roupa roupaExistente = roupaExistenteOptional.get();
            roupaExistente.setNome(roupa.getNome());
            roupaExistente.setValor(roupa.getValor());
            roupaExistente.setQuantidade(roupa.getQuantidade());

            roupaRepository.save(roupaExistente);
        } else {
            throw new RoupaNaoEncontradaException("Roupa com ID " + roupa.getId() + " não encontrado.");
        }
    }
}
