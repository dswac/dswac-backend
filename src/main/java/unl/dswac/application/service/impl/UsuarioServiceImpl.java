package unl.dswac.application.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unl.dswac.application.model.Usuario;
import unl.dswac.application.model.repository.UsuarioRepository;
import unl.dswac.application.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public ArrayList<Usuario> getUsuarios() {
		return (ArrayList<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> getUsuarioPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public Optional<Usuario> getUsuarioPorCodigoUsuario(String codigoUsuario) {
		return usuarioRepository.findByCodigoUsuario(codigoUsuario);
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		try {
			return usuarioRepository.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean borrarUsuarioPorId(Long id) {
		try {
			Optional<Usuario> usuario = this.getUsuarioPorId(id);
			usuarioRepository.delete(usuario.get());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
