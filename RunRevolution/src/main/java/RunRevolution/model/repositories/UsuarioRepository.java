package RunRevolution.model.repositories;

import RunRevolution.model.domain.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
}
