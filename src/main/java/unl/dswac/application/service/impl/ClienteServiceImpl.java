package unl.dswac.application.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unl.dswac.application.model.Cliente;
import unl.dswac.application.model.repository.ClienteRepository;
import unl.dswac.application.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public ArrayList<Cliente> getClientes() {
		return (ArrayList<Cliente>) this.clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> getClientePorId(Long id) {
		return clienteRepository.findById(id);
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		try {
			return clienteRepository.save(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean borrarClientePorId(Long id) {
		try {
			Optional<Cliente> cliente = this.getClientePorId(id);
			clienteRepository.delete(cliente.get());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Optional<Cliente> getClientePorIdentificacion(String identificacion) {
		return clienteRepository.findByIdentificacion(identificacion);
	}

}
