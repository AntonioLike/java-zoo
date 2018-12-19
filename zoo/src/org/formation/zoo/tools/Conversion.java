package org.formation.zoo.tools;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.formation.zoo.model.Animal;
import org.formation.zoo.model.Cage;
import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.technical.CageException;

public abstract class Conversion {
	public static final String MODEL = "org.formation.zoo.model.";

	public static Cage createCage(CagePOJO cagePOJO) throws CageException {
		Cage cage = new Cage(cagePOJO.getX(),cagePOJO.getY());
		if(cagePOJO.getCodeAnimal() != null) {
			Animal animal = null;
			Class<?> animalClass = null;
			Constructor<?> completeConstructor = null;
			Class<?> typesOfParameters[];
			Object theValues[] = null;
			
			try {
				animalClass = Class.forName(MODEL + cagePOJO.getCodeAnimal());
				if(cagePOJO.getCodeAnimal().equals("Gazelle")) {
					typesOfParameters = new Class<?>[4];
					typesOfParameters[3] = int.class;
					theValues = new Object[4];
					theValues[3] = cagePOJO.getGaz().getHornsLength();
				}
				else {
					typesOfParameters = new Class<?>[3];
					theValues = new Object[3];
				}
					
				typesOfParameters[0] = String.class;
				typesOfParameters[1] = int.class;
				typesOfParameters[2] = double.class;
				theValues[0] = cagePOJO.getName();
				theValues[1] = cagePOJO.getAge();
				theValues[2] = cagePOJO.getWeight();
				
				completeConstructor = animalClass.getConstructor(typesOfParameters);
				animal = (Animal) completeConstructor.newInstance(theValues);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cage.enter(animal);
		}
		return cage;
				 
	}
}
