package org.formation.zoo.persistence;

import java.util.ArrayList;
import java.util.List;

import org.formation.zoo.service.CagePOJO;

public class HardCodedDao implements Dao<CagePOJO> {
	private List<CagePOJO> pojos;
	
	
	
	public HardCodedDao() {
		pojos = new ArrayList<CagePOJO>();
		init();
	}

	private void init() {
		addPojo(1,1,0, "Lion","Simba",10,123);
	}
	
	private void addPojo(int x, int idAnimal, int y, String codeAnimal, String name, int age,
			double weight) {
		CagePOJO cagePOJO = new CagePOJO();
		cagePOJO.setAge(age);
		cagePOJO.setCodeAnimal(codeAnimal);
		cagePOJO.setIdAnimal(idAnimal);
		cagePOJO.setName(name);
		cagePOJO.setWeight(weight);
		cagePOJO.setX(x);
		cagePOJO.setY(y);
		pojos.add(cagePOJO);
	}

	@Override
	public void create(CagePOJO obj) {
		pojos.add(obj);
	}

	@Override
	public CagePOJO read(int key) {
		return pojos.get(key);
	}

	@Override
	public List<CagePOJO> readAll() {
		return pojos;
	}

	@Override
	public void update(int key, CagePOJO obj) {
		pojos.set(key, obj);		
	}

	@Override
	public void delete(int key) {
		pojos.remove(key);		
	}

}
