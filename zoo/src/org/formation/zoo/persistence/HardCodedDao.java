package org.formation.zoo.persistence;

import java.util.ArrayList;
import java.util.List;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.service.GazellePOJO;

public class HardCodedDao implements Dao<CagePOJO> {
	private List<CagePOJO> pojos;
	
	public HardCodedDao() {
		pojos = new ArrayList<CagePOJO>();
		init();
	}

	private void init() {
		pojos.add(addPojo(1,1,0, "Lion","Simba",10,123));
		pojos.add(addPojo(1,10,1,"Elephant","Djumbo",2,1125));
		pojos.add(addGazelle(1,20,2,"Gazelle","Bambi",3,70,0,15));
	}
		
	private CagePOJO addGazelle(int x, int y, int idAnimal, String codeAnimal, String name, int age,
			double weight, int idGazelle, int hornsLength) {
			CagePOJO cp = addPojo(x, y, idAnimal, codeAnimal, name, age, weight);
			cp.setGaz(new GazellePOJO(idGazelle,idAnimal,hornsLength));
			return cp;
	}

	private CagePOJO addPojo(int x, int y, int idAnimal, String codeAnimal, String name, int age,
			double weight) {
		CagePOJO cagePOJO = new CagePOJO();
		cagePOJO.setAge(age);
		cagePOJO.setCodeAnimal(codeAnimal);
		cagePOJO.setIdAnimal(idAnimal);
		cagePOJO.setName(name);
		cagePOJO.setWeight(weight);
		cagePOJO.setX(x);
		cagePOJO.setY(y);
		return cagePOJO;
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
