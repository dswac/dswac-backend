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
import unl.dswac.application.model.Reclamo;
import unl.dswac.application.service.ReclamoService;

@RestController
@RequestMapping("/reclamo")
public class ReclamoController {

	@Autowired
	private ReclamoService reclamoService;

	@GetMapping("/hola")
	public String prueba() {
		System.out.println("HOLAAAAA");
		return "hola";
	}

	@GetMapping("/all")
	public ArrayList<Reclamo> getReclamos() {
		return this.reclamoService.getReclamos();
	}

	@GetMapping("/find/{id}")
	public Optional<Reclamo> getReclamoPorId(@PathVariable("id") Long id) {
		return this.reclamoService.getReclamoPorId(id);
	}

	@PostMapping("/save")
	public Reclamo guardarReclamo(@RequestBody Reclamo reclamo) {
		return this.reclamoService.guardarReclamo(reclamo);
	};

	@DeleteMapping("/delete/{id}")
	public Respuesta borrarReclamoPorId(@PathVariable("id") Long id) {
		return this.reclamoService.borrarReclamoPorId(id) ? new Respuesta("OK") : new Respuesta("ERROR");
	};

}
