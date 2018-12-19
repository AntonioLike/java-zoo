package org.formation.zoo.technical;

import org.formation.zoo.model.Animal;
import org.formation.zoo.model.Cage;
import org.formation.zoo.model.Eatable;
import org.formation.zoo.persistence.Dao;
import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.tools.Conversion;

public class ManagedCage {
	
	private Cage model;
	private CagePOJO view;
	private Dao<CagePOJO> controller;
	
	public ManagedCage() {
		this(null,null);
	}
	
	public ManagedCage(CagePOJO cagePOJO, Dao<CagePOJO> dao) {
		controller = dao;
		this.view = cagePOJO;
		try {
			this.model = Conversion.createCage(cagePOJO);
		} catch (CageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void save() {
		if(!model.isEmpty())
		{
			view.setCodeAnimal(model.getSpecies());
			view.setAge(model.getAnimal().getAge());
			view.setName(model.getAnimal().getName());
			view.setWeight(model.getAnimal().getWeight());
		}else {
			view.setCodeAnimal(null);
			view.setAge(0);
			view.setName("");
			view.setWeight(0);
		}
		controller.update(view.getIdAnimal(),view);
	}
	
	public void enter(Animal animal) throws CageException {
		model.enter(animal);
		save();
	}

	public String displayAnimal() {
		return model.displayAnimal();
	}

	public Animal exit() {
		Animal ret = null;
		ret = model.exit();
		save();
		return ret;
	}

	public boolean isEmpty() {
		return model.isEmpty();
	}

	public void feed() throws CageException {
		model.feed();
		save();
	}

	public boolean isEatable() throws CageException {
		return model.isEatable();
	}

	public void feed(Eatable being) throws YuckException {
		model.feed(being);
		save();
	}

	public String getSpecies() {
		return model.getSpecies();
	}

	public String toString() {
		return model.toString();
	}	
	
}
