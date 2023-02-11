package unl.dswac.application.service;

import java.util.ArrayList;
import java.util.Optional;

import unl.dswac.application.model.Usuario;

public interface UsuarioService {

	public ArrayList<Usuario> getUsuarios();

	public Optional<Usuario> getUsuarioPorId(Long id);

	public Optional<Usuario> getUsuarioPorCodigoUsuario(String codigoUsuario);

	public Usuario guardarUsuario(Usuario usuario);

	public boolean borrarUsuarioPorId(Long id);
}
