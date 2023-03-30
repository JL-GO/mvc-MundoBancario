package mvc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mvc.model.entity.Cuenta;

public class CuentaDAO {

	private EntityManager manager = Persistence.createEntityManagerFactory("MUNDOBANCARIO_PU").createEntityManager();

	public void create(Cuenta cuenta) {
		manager.getTransaction().begin();
		manager.persist(cuenta);
		manager.getTransaction().commit();
	}

	public  void update(Cuenta cuenta) {
		manager.getTransaction().begin();
		manager.merge(cuenta);
		manager.getTransaction().commit();
	}

	public Cuenta read(int id) {
		return manager.find(Cuenta.class, id);	
	}

	public void delete(Cuenta cuenta) {
		manager.getTransaction().begin();
		manager.remove(cuenta);
		manager.getTransaction().commit();
	}

	public  List<Cuenta> readAll() {
		String hql = "FROM Cuenta";
		Query query = manager.createQuery(hql);
		List<Cuenta> result = null;
		result = query.getResultList();

		return result;
	}
}
