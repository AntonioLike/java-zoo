package org.formation.zoo.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.formation.zoo.service.CagePOJO;

//<dependency>
//<groupId>javax.enterprise</groupId>
//<artifactId>cdi-api</artifactId>
//<version>2.0.SP1</version>
//<scope>provided</scope>
//</dependency>
//<dependency>
//<groupId>javax.xml.bind</groupId>
//<artifactId>jaxb-api</artifactId>
//<version>2.2.11</version>
//</dependency>	

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
		return (T) em.find(CagePOJO.class,key);
	}

	@Override
	public List<T> readAll() {
		return em.createQuery("select c from CagePOJO c").getResultList();
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
		em.detach(key);
		em.getTransaction().commit();

	}

}
