package org.formation.zoo.model;

import java.io.Serializable;

import org.formation.zoo.technical.CageException;
import org.formation.zoo.technical.YuckException;

public class Cage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xCoord;
	private int yCoord;
	private boolean empty;
	private Animal animal;
	
	public Cage() {
		this(0,0); 
	}
	
	public Cage(int x, int y) {
		xCoord = x;
		yCoord = y;
		empty = true;
		animal = null;
	}
	
	public void enter(Animal animal) throws CageException {
		if(!isEmpty())
			throw new CageException();
		this.animal = animal;
		empty = false;
	}
	
	public String displayAnimal() {
		String tmp = null;
		if(animal == null)
			tmp = "EmptyCage.";
		else 
			tmp = animal.display();
		return "Cage [x=" + xCoord + ",y=" + yCoord + "]: " + tmp;
	}
	
	public Animal exit() {
		Animal tempAnimal = animal;
		animal = null;
		empty = true;
		return tempAnimal;
	}
	
	public boolean isEmpty() {
		return empty;
	}

	protected int getxCoord() {
		return xCoord;
	}

	protected int getyCoord() {
		return yCoord;
	}
	
	@Override
	public String toString() {
		return displayAnimal();
	}

	public String getSpecies(){
		if(animal == null)
			return "";
		return animal.getClass().getSimpleName();
	}	

	public void feed(){
		if(animal != null)
			animal.eat();
	}

	public boolean isEatable(){
		return animal instanceof Eatable;
	}
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void feed(Eatable being) throws YuckException {
		if(!isEmpty())
			animal.eat(being);
	}	
}
