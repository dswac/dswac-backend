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
import unl.dswac.application.model.Cliente;
import unl.dswac.application.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/all")
	public ArrayList<Cliente> getClientes() {
		return this.clienteService.getClientes();
	}

	@GetMapping("/find/{id}")
	public Optional<Cliente> getClientePorId(@PathVariable("id") Long id) {
		return this.clienteService.getClientePorId(id);
	}

	@GetMapping("/findIdentificacion/{identificacion}")
	public Optional<Cliente> getClientePorIdentificacion(@PathVariable("identificacion") String identificacion) {
		return this.clienteService.getClientePorIdentificacion(identificacion);
	}

	@PostMapping("/save")
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		return this.clienteService.guardarCliente(cliente);
	};

	@DeleteMapping("/delete/{id}")
	public Respuesta borrarClientePorId(@PathVariable("id") Long id) {
		return this.clienteService.borrarClientePorId(id) ? new Respuesta("OK") : new Respuesta("ERROR");
	};

}
