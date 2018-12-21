package org.formation.farm;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import model.Animal;

@Stateful
public class ContractImpl implements FarmContract,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="farm", type = PersistenceContextType.EXTENDED)
	private	EntityManager em;

	public ContractImpl() {
	}

	public String getDescription() {
		if(em==null)
			return "EM = ++++++++++++++++++ " + em;
		@SuppressWarnings("unchecked")
		List<Animal> a = em.createNamedQuery("Animal.findAll").getResultList();
		StringJoiner sj = new StringJoiner("\n");
		for(Animal animal: a)
			sj.add(animal.toString());
		return sj.toString();
	}

}
