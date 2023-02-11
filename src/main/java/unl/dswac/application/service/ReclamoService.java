package unl.dswac.application.service;

import java.util.ArrayList;
import java.util.Optional;

import unl.dswac.application.model.Reclamo;

public interface ReclamoService {

	public ArrayList<Reclamo> getReclamos();

	public Optional<Reclamo> getReclamoPorId(Long id);

	// public Optional<Cliente> getClientePorIdentificacion(String identificacion);

	public Reclamo guardarReclamo(Reclamo reclamo);

	public boolean borrarReclamoPorId(Long id);
}