package RunRevolution.model.repositories;

import RunRevolution.model.domain.Relogio;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RelogioRepository extends CrudRepository<Relogio, Integer> {
}
