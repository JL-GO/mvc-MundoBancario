package mvc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mvc.model.entity.Cliente;

public class ClienteDAO {

	private EntityManager manager = Persistence.createEntityManagerFactory("MUNDOBANCARIO_PU").createEntityManager();

	public void create(Cliente cliente) {
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
	}

	public  void update(Cliente cliente) {
		manager.getTransaction().begin();
		manager.merge(cliente);
		manager.getTransaction().commit();
	}

	public Cliente read(String dni) {
		return manager.find(Cliente.class, dni);	
	}

	public void delete(Cliente cliente) {
		manager.getTransaction().begin();
		manager.remove(cliente);
		manager.getTransaction().commit();
	}

	public  List<Cliente> readAll() {
		String hql = "FROM Cliente";
		Query query = manager.createQuery(hql);
		List<Cliente> result = null;
		result = query.getResultList();

		return result;
	}
}
