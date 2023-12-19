package RunRevolution.model.repositories;

import RunRevolution.model.domain.Roupa;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RoupaRepository extends CrudRepository<Roupa, Integer> {
}
