package RunRevolution.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RunRevolution.model.domain.Relogio;
import RunRevolution.model.repositories.RelogioRepository;
import RunRevolution.exceptions.RelogioNaoEncontradoException;

@Service
public class RelogioService {
    @Autowired
    private RelogioRepository relogioRepository;

    public void incluir(Relogio relogio){
        relogioRepository.save(relogio);
    }

    public Collection<Relogio> obterLista(){
        return (Collection<Relogio>) relogioRepository.findAll();
    }

    public void excluir(Integer id) {
        relogioRepository.deleteById(id);
    }

    public void atualizar(Relogio relogio) {
        Optional<Relogio> relogioExistenteOptional = relogioRepository.findById(relogio.getId());

        if (relogioExistenteOptional.isPresent()) {
            Relogio relogioExistente = relogioExistenteOptional.get();
            relogioExistente.setNome(relogio.getNome());
            relogioExistente.setValor(relogio.getValor());
            relogioExistente.setQuantidade(relogio.getQuantidade());

            relogioRepository.save(relogioExistente);
        } else {
            throw new RelogioNaoEncontradoException("Relogio com ID " + relogio.getId() + " não encontrado.");
        }
    }
}
