package unl.dswac.application.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unl.dswac.application.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	public Optional<Cliente> findByIdentificacion(String identificacion);

}
