package unl.dswac.application.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unl.dswac.application.model.Reclamo;

@Repository
public interface ReclamoRepository extends CrudRepository<Reclamo, Long> {

}
