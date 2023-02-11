package unl.dswac.application.service;

import java.util.ArrayList;
import java.util.Optional;

import unl.dswac.application.model.Cliente;

public interface ClienteService {

	public ArrayList<Cliente> getClientes();

	public Optional<Cliente> getClientePorId(Long id);

	public Optional<Cliente> getClientePorIdentificacion(String identificacion);

	public Cliente guardarCliente(Cliente cliente);

	public boolean borrarClientePorId(Long id);

}
