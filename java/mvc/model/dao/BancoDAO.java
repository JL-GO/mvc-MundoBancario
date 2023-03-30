package mvc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mvc.model.entity.Banco;

public class BancoDAO{
	
	private EntityManager manager = Persistence.createEntityManagerFactory("MUNDOBANCARIO_PU").createEntityManager();

	public void create(Banco banco) {
		manager.getTransaction().begin();
		manager.persist(banco);
		manager.getTransaction().commit();
	}

	public  void update(Banco banco) {
		manager.getTransaction().begin();
		manager.merge(banco);
		manager.getTransaction().commit();
	}

	public Banco read(int id) {
		return manager.find(Banco.class, id);	
	}

	public void delete(Banco banco) {
		manager.getTransaction().begin();
		manager.remove(banco);
		manager.getTransaction().commit();
	}

	public  List<Banco> readAll() {
		String hql = "FROM Banco";
		Query query = manager.createQuery(hql);
		List<Banco> result = null;
		result = query.getResultList();

		return result;
	}

}
