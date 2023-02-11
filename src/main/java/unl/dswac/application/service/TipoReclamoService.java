package unl.dswac.application.service;

import java.util.ArrayList;
import java.util.Optional;

import unl.dswac.application.model.TipoReclamo;

public interface TipoReclamoService {

	public ArrayList<TipoReclamo> getTipoReclamos();

	public Optional<TipoReclamo> getTipoReclamoPorId(Long id);

	public TipoReclamo guardarTipoReclamo(TipoReclamo tipoReclamo);

	public boolean borrarTipoReclamoPorId(Long id);

}
