package RunRevolution.model.repositories;

import RunRevolution.model.domain.Tenis;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TenisRepository extends CrudRepository<Tenis, Integer> {
}
