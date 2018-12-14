package org.formation.zoo.controller;
import java.util.List;
import java.util.Vector;

import org.formation.zoo.model.Animal;
import org.formation.zoo.model.Eatable;
import org.formation.zoo.model.Elephant;
import org.formation.zoo.model.Gazelle;
import org.formation.zoo.model.Lion;
import org.formation.zoo.model.Monkey;
import org.formation.zoo.model.Visitor;
import org.formation.zoo.technical.YuckException;
import org.formation.zoo.tools.Broom;
import org.formation.zoo.view.TypesOfEatable;

public final class Manager {
	private static Manager instance = new Manager();

	private List<Animal> animals; 
	
	private Visitor visitors[];	
	
	private void init()
	{
		
		animals.add(new Gazelle("Gazelle", 5, 70.0,10));
		animals.add(new Monkey("Monkey", 7, 15));
		animals.add(new Elephant("Elephant", 5, 7500));
		animals.add(new Lion("Lion",3,150.0));
		animals.add(new Lion());
		animals.add(new Lion("Leo",2,15));
		animals.add(new Elephant());
		animals.add(new Gazelle());
		animals.add(new Monkey());
		animals.add(new Elephant());
	}
	
	private Manager() {
		animals = new Vector<>();
		visitors = new Visitor[Visitor.MAX];
		init();
	}

	public static Manager getInstance() {
		return instance;
	}
	
	public String getAnimal(int id) {
		return animals.get(id).toString();
	}
	
	public String newVisitor() {
		if(Visitor.getAmount()<10) {
			visitors[Visitor.getAmount()]=new Visitor();
			return String.join(" ", "Visitor", Integer.toString(Visitor.getAmount()),"entered");
		}
		return "The zoo is full.";
	}
	
	public String visitorleaves() {
		if(Visitor.getAmount()>0) {
			visitors[Visitor.getAmount()-1]=null;
			Broom.sweep();
			return String.join(" ", "Visitor", Integer.toString(Visitor.getAmount()),"left");
		}
		return "There are no visitors";
	}

	public boolean isCageEmpty(int id) {
		return id<animals.size()? animals.get(id)==null:false;
	}
	
	public boolean isVisitorAlive(int id) {
		return id<visitors.length? visitors[id]!=null:false;
	}
	
	public int getAmountAnimals() {
		return animals.size();
	}
	
	public int getAmountVisitors() {
		return visitors.length;
	}
	
	public String getSpecies(int i) {
		return animals.get(i)==null? "":animals.get(i).getClass().getSimpleName();
	}
	
	public String[] getAnimals() {
		String[] animalsString = new String[getAmountAnimals()];
		for (int i = 0; i < animalsString.length; i++) {
			if(isCageEmpty(i))
				animalsString[i] = "Empty Cage";
			else
				animalsString[i] = getAnimal(i);
		}
		return animalsString;
	}
	
	public String display(int id) {
		return Manager.getInstance().display(id);
	}
	
	public void feed() {
		for (Animal animal : animals) {
			animal.eat();
		}
	}
	
	public String devour(int eater, int eaten,TypesOfEatable type) { 
		if(type.equals(TypesOfEatable.ANIMAL) ) {
			if(animals.get(eaten) == null || animals.get(eater) == null)
				return "The cage is empty";
			else if(!(animals.get(eaten) instanceof Eatable))
				return String.join(" ", getSpecies(eaten), "is not eatable");
			else 
				try {
					animals.get(eater).eat((Eatable) animals.get(eaten));
					animals.set(eaten, null);
					Broom.sweep();
					return "Oof!";
				} catch (YuckException e) {
					return e.getMessage();
				}
		}
		else {
			if(animals.get(eater) == null)
				return "The cage is empty";
			else if(visitors[eaten] == null)
				return "There's no visitors";
			else
				try {
					animals.get(eater).eat((Eatable) visitors[eaten]);
					visitors[eaten] = null;
					Broom.sweep();
					return "Oof!";
				} catch (YuckException e) {
					return e.getMessage();
				}
		}
	}
}
