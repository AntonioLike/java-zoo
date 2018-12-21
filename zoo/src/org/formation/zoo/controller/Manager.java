package org.formation.zoo.controller;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import org.formation.zoo.model.Animal;
import org.formation.zoo.model.Eatable;
import org.formation.zoo.model.Visitor;
import org.formation.zoo.persistence.Dao;
import org.formation.zoo.persistence.DaoFactory;
import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.technical.CageException;
import org.formation.zoo.technical.ManagedCage;
import org.formation.zoo.technical.YuckException;
import org.formation.zoo.tools.Broom;
import org.formation.zoo.view.TypesOfEatable;

public final class Manager {
	private static Manager instance = new Manager();

	private List<ManagedCage> cages; 
	
	private Visitor visitors[];	
	
	private void init()
	{	
		final Dao<CagePOJO> dao = DaoFactory.getInstance().getDao();
		cages = dao.readAll().stream().map(pojo->new ManagedCage(pojo,dao)).collect(Collectors.toList());
	}
	
	private Manager() {
		cages = new Vector<>();
		init();
		visitors = new Visitor[Visitor.MAX];
	}
	
	public static Manager getInstance() {
		return instance;
	}
	
	public void addAnimal(Animal animal, int cage) {
		try {
			cages.get(cage).enter(animal);
		} catch (CageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getAnimal(int id) {
		return cages.get(id).toString();
	}
	
	public String newVisitor() {
		if(Visitor.getAmount()<Visitor.MAX) {
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
		return id<cages.size()? cages.get(id).isEmpty():false;
	}
	
	public boolean isVisitorAlive(int id) {
		return id<visitors.length? visitors[id]!=null:false;
	}
	
	public int getAmountAnimals() {
		int amountAnimals = 0;
		for (int i = 0; i < cages.size(); i++) {
			if(!cages.get(i).isEmpty())
				amountAnimals++;
		}
		return amountAnimals;
	}
	
	public int getAmountVisitors() {
		for (int i = 0; i < visitors.length; i++) {
			if(visitors[i]==null)
				return i;
		}
		return visitors.length;
	}
	
	public String getSpecies(int i){
		return !cages.get(i).isEmpty()? cages.get(i).getSpecies():"";
	}
	
	public String[] getAnimals() {
		return cages.stream().map(cage->cage.toString()).collect(Collectors.toList()).toArray(new String[cages.size()]);
	}
	
	public void feed() {
		cages.forEach(cage->cage.feed());
	}
	
	public String devour(int eater, int eaten,TypesOfEatable type) {
		Animal eatenAnimal = null;
		if(type.equals(TypesOfEatable.ANIMAL) ) {
			if(cages.get(eaten).isEmpty() || cages.get(eater).isEmpty())
				return "The cage is empty";
			else
				try {
					if(!(cages.get(eaten).isEatable()))
						return String.join(" ", getSpecies(eaten), "is not eatable");
					else 
						eatenAnimal = cages.get(eaten).exit();
						try {
							cages.get(eater).feed((Eatable)eatenAnimal);
							Broom.sweep();
							return cages.get(eater).getSpecies() + " ate " + eatenAnimal.getName(); 
						} catch (YuckException e) {
							cages.get(eaten).enter(eatenAnimal);
							return e.getMessage();
						}
				} catch (CageException e) {
					// TODO Auto-generated catch block
					return e.getMessage();
				}
		}
		else {
			if(cages.get(eater).isEmpty())
				return "The cage is empty";
			else if(visitors[eaten] == null)
				return "There's no visitors";
			else
				try {
					cages.get(eater).feed((Eatable) visitors[eaten]);
					visitors[eaten] = null;
					Broom.sweep();
					return "Oof!";
				} catch (YuckException e) {
					return e.getMessage();
				}
		}
	}
}
