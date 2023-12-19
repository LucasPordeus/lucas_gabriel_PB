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
        Optional<Roupa> roupaExistente = roupaRepository.findById(roupa.getId());

        if (roupaExistente.isPresent()) {
            Roupa roupaAtualizado = roupaExistente.get();
            roupaRepository.save(roupaAtualizado);
        } else
            throw new RoupaNaoEncontradaException("Roupa com ID " + roupa.getId() + " não encontrado.");
    }
}
