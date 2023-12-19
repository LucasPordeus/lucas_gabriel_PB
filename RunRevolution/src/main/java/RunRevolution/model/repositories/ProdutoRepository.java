package RunRevolution.model.repositories;

import RunRevolution.model.domain.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
