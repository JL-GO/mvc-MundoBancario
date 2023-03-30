package mvc.model.service;

import mvc.model.dao.ClienteDAO;
import mvc.model.entity.Cliente;

//logica de negocio de mi app para clientes

public class ClienteService {
	
	private ClienteDAO dao =  new ClienteDAO();
	
	public void alta(String dni, String nombre, String direccion) {
		
		Cliente cliente = Cliente.builder().direccion(direccion).dni(dni).nombre(nombre).build();
		dao.create(cliente);
	}

	public Cliente consulta(String dni) {
		
		return dao.read(dni);
	}
	
	public Cliente borrar(String dni) {
		Cliente cliente = dao.read(dni);
		dao.delete(cliente);
		return cliente;
	}
	
	public Cliente modificarDireccion(String dni, String nuevaDireccion) {
		Cliente cliente = dao.read(dni);
		cliente.setDireccion(nuevaDireccion);
		dao.update(cliente);
		return cliente;
	}
	
}
