package org.formation.zoo.tools;

import org.formation.zoo.model.Animal;
import org.formation.zoo.model.Cage;
import org.formation.zoo.model.Gazelle;
import org.formation.zoo.model.Lion;
import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.technical.CageException;

public abstract class Conversion {

	public static Cage createCage(CagePOJO cagePOJO) throws CageException {
		Cage cage = new Cage(cagePOJO.getX(),cagePOJO.getY());
		if(cagePOJO.getCodeAnimal() != null) {
			Animal animal = null;
			switch (cagePOJO.getCodeAnimal()) {
			case "Lion":
				animal = new Lion(cagePOJO.getName(),cagePOJO.getAge(),cagePOJO.getWeight());
				break;
			case "Gazelle":
				animal = new Gazelle(cagePOJO.getName(),cagePOJO.getAge(),cagePOJO.getWeight());
			default:
				break;
			}
			cage.enter(animal);
		}
		return cage;
				 
	}
}
