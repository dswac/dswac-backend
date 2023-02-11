package unl.dswac.application.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unl.dswac.application.controller.responses.Respuesta;
import unl.dswac.application.model.Usuario;
import unl.dswac.application.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioServicio;

	@GetMapping("/all")
	public ArrayList<Usuario> getUsuarios() {
		return this.usuarioServicio.getUsuarios();
	}

	@GetMapping("/find/{id}")
	public Optional<Usuario> getUsuarioPorId(@PathVariable("id") Long id) {
		return this.usuarioServicio.getUsuarioPorId(id);
	}

	@PostMapping("/save")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return this.usuarioServicio.guardarUsuario(usuario);
	};

	@DeleteMapping("/delete/{id}")
	public Respuesta borrarUsuarioPorId(@PathVariable("id") Long id) {
		return this.usuarioServicio.borrarUsuarioPorId(id) ? new Respuesta("OK") : new Respuesta("ERROR");
	};

}
