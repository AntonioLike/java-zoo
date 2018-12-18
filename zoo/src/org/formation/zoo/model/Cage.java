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
	private boolean open;
	private Animal animal;
	
	public Cage() {
		this(0,0); 
	}
	
	public Cage(int x, int y) {
		xCoord = x;
		yCoord = y;
		open = false;
		animal = null;
	}
	
	public void enter(Animal animal) throws CageException {
		if(isOpen())
			throw new CageException();
		this.animal = animal;
		open = true;
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
		open = false;
		return tempAnimal;
	}
	
	public boolean isOpen() {
		return open;
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

	public void feed() throws CageException{
		if(animal != null)
			animal.eat();
	}

	public boolean isEatable() throws CageException {
		return animal instanceof Eatable;
	}
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void feed(Eatable being) throws YuckException {
		if(isOpen())
			animal.eat(being);
	}	
}
