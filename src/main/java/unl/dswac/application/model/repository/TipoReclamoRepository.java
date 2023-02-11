package unl.dswac.application.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unl.dswac.application.model.TipoReclamo;

@Repository
public interface TipoReclamoRepository extends CrudRepository<TipoReclamo, Long> {

}
