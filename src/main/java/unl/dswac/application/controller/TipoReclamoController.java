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
import unl.dswac.application.model.TipoReclamo;
import unl.dswac.application.service.TipoReclamoService;

@RestController
@RequestMapping("/tipoReclamo")
public class TipoReclamoController {

	@Autowired
	private TipoReclamoService tipoReclamoService;

	@GetMapping("/all")
	public ArrayList<TipoReclamo> getTipoReclamos() {
		return this.tipoReclamoService.getTipoReclamos();
	}

	@GetMapping("/find/{id}")
	public Optional<TipoReclamo> getTipoReclamoPorId(@PathVariable("id") Long id) {
		return this.tipoReclamoService.getTipoReclamoPorId(id);
	}

	@PostMapping("/save")
	public TipoReclamo guardarTipoReclamo(@RequestBody TipoReclamo tipoReclamo) {
		return this.tipoReclamoService.guardarTipoReclamo(tipoReclamo);
	};

	@DeleteMapping("/delete/{id}")
	public Respuesta borrarTipoReclamoPorId(@PathVariable("id") Long id) {
		return this.tipoReclamoService.borrarTipoReclamoPorId(id) ? new Respuesta("OK") : new Respuesta("OK");
	};

}
