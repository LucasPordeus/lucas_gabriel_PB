package RunRevolution.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RunRevolution.model.domain.Tenis;
import RunRevolution.model.repositories.TenisRepository;
import RunRevolution.exceptions.TenisNaoEncontradoException;

@Service
public class TenisService {
    @Autowired
    private TenisRepository tenisRepository;

    public void incluir(Tenis tenis){
        tenisRepository.save(tenis);
    }

    public Collection<Tenis> obterLista(){
        return (Collection<Tenis>) tenisRepository.findAll();
    }

    public void excluir(Integer id) {
        tenisRepository.deleteById(id);
    }

    public void atualizar(Tenis tenis) {
        Optional<Tenis> tenisExistente = tenisRepository.findById(tenis.getId());

        if (tenisExistente.isPresent()) {
            Tenis tenisAtualizado = tenisExistente.get();
            tenisRepository.save(tenisAtualizado);
        } else
            throw new TenisNaoEncontradoException("Tenis com ID " + tenis.getId() + " não encontrado.");
    }
}
