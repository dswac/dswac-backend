package unl.dswac.application.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unl.dswac.application.model.Reclamo;
import unl.dswac.application.model.repository.ReclamoRepository;
import unl.dswac.application.service.ReclamoService;

@Service
public class ReclamoServiceImpl implements ReclamoService {

	@Autowired
	private ReclamoRepository reclamoRepository;

	@Override
	public ArrayList<Reclamo> getReclamos() {
		return (ArrayList<Reclamo>) this.reclamoRepository.findAll();
	}

	@Override
	public Optional<Reclamo> getReclamoPorId(Long id) {
		return this.reclamoRepository.findById(id);
	}

	@Override
	public Reclamo guardarReclamo(Reclamo reclamo) {
		try {
			return reclamoRepository.save(reclamo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean borrarReclamoPorId(Long id) {
		try {
			Optional<Reclamo> reclamo = this.getReclamoPorId(id);
			this.reclamoRepository.delete(reclamo.get());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
