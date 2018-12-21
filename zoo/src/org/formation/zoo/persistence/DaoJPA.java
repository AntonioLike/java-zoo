package org.formation.zoo.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class DaoJPA<T> implements Dao<T> {
	private EntityManager em;
	public DaoJPA() {
		em = Persistence.createEntityManagerFactory("zoo").createEntityManager();
	}

	@Override
	public void create(T obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();

	}

	@Override
	public T read(int key) {
		return (T) em.createNamedQuery("CagePOJO.findById").setParameter(0, key);
	}

	@Override
	public List<T> readAll() {
		return em.createNamedQuery("CagePOJO.findAll").getResultList();
	}

	@Override
	public void update(int key, T obj) {
	    em.getTransaction().begin();
	    em.merge(obj);
	    em.getTransaction().commit();
	}

	@Override
	public void delete(int key) {
		em.getTransaction().begin();
		em.remove(read(key));
		em.getTransaction().commit();

	}

}
