package mvc.model.service;

import java.util.List;

import mvc.model.dao.BancoDAO;
import mvc.model.entity.Banco;

public class BancoService {

	private BancoDAO dao =  new BancoDAO();
	
	public void alta(String nombre, String ciudad) {
		
		Banco banco = Banco.builder().nombre(nombre).ciudad(ciudad).build();
		dao.create(banco);
	}

	public Banco consulta(int id) {
		
		return dao.read(id);
	}
	
	public Banco borrar(int id) {
		Banco banco = dao.read(id);
		dao.delete(banco);
		return banco;
	}
	
	public Banco modificarCiudad(int id, String nuevaCiudad) {
		Banco banco = dao.read(id);
		banco.setCiudad(nuevaCiudad);
		dao.update(banco);
		return banco;
	}
	
	public List<Banco> listarBancos(){
		return dao.readAll();
	}
	
}
