package unl.dswac.application.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unl.dswac.application.model.TipoReclamo;
import unl.dswac.application.model.repository.TipoReclamoRepository;
import unl.dswac.application.service.TipoReclamoService;

@Service
public class TipoReclamoServiceImpl implements TipoReclamoService {

	@Autowired
	private TipoReclamoRepository tipoReclamoRepository;

	@Override
	public ArrayList<TipoReclamo> getTipoReclamos() {
		return (ArrayList<TipoReclamo>) this.tipoReclamoRepository.findAll();
	}

	@Override
	public Optional<TipoReclamo> getTipoReclamoPorId(Long id) {
		return tipoReclamoRepository.findById(id);
	}

	@Override
	public TipoReclamo guardarTipoReclamo(TipoReclamo tipoReclamo) {
		try {
			return tipoReclamoRepository.save(tipoReclamo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean borrarTipoReclamoPorId(Long id) {
		try {
			Optional<TipoReclamo> tipoReclamo = this.getTipoReclamoPorId(id);
			tipoReclamoRepository.delete(tipoReclamo.get());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
