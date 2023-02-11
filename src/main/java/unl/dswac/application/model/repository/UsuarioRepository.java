package unl.dswac.application.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unl.dswac.application.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	public Optional<Usuario> findByCodigoUsuario(String codigoUsuario);

}
