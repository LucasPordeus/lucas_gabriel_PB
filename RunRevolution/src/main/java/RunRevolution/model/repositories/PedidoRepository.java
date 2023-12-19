package RunRevolution.model.repositories;

import RunRevolution.model.domain.Pedido;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
}
