package RunRevolution.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RunRevolution.model.domain.Produto;
import RunRevolution.model.repositories.ProdutoRepository;
import RunRevolution.exceptions.ProdutoNaoEncontradoException;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void incluir(Produto produto){
        produtoRepository.save(produto);
    }

    public Collection<Produto> obterLista(){
        return (Collection<Produto>) produtoRepository.findAll();
    }

    public void excluir(Integer id) {
        produtoRepository.deleteById(id);
    }

    public void atualizar(Produto produto) {
        Optional<Produto> produtoExistente = produtoRepository.findById(produto.getId());

        if (produtoExistente.isPresent()) {
            Produto produtoAtualizado = produtoExistente.get();
            produtoRepository.save(produtoAtualizado);
        } else
            throw new ProdutoNaoEncontradoException("Produto com ID " + produto.getId() + " não encontrado.");
    }
}
