package RunRevolution.model.service;

import java.util.Collection;
import java.util.Optional;

import RunRevolution.exceptions.ProdutoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RunRevolution.model.domain.Produto;
import RunRevolution.model.repositories.ProdutoRepository;

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
        Optional<Produto> produtoExistenteOptional = produtoRepository.findById(produto.getId());

        if (produtoExistenteOptional.isPresent()) {
            Produto produtoExistente = produtoExistenteOptional.get();
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setValor(produto.getValor());
            produtoExistente.setQuantidade(produto.getQuantidade());

            produtoRepository.save(produtoExistente);
        } else {
            throw new ProdutoNaoEncontradoException("Produto com ID " + produto.getId() + " não encontrado.");
        }
    }
}
