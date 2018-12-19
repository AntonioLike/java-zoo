package org.formation.zoo.controller;
import java.util.List;
import java.util.Vector;

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
		Dao<CagePOJO> dao = DaoFactory.getInstance().getDao();
		List<CagePOJO> pojos = dao.readAll();
		for(CagePOJO pojo : pojos) 
			cages.add(new ManagedCage(pojo,dao));
		
		/*try {
			cages.get(0).enter(new Gazelle("Gazelle", 5, 70.0,10));
			cages.get(1).enter(new Monkey("Monkey", 7, 15));
			cages.get(2).enter(new Elephant("Elephant", 5, 7500));
			cages.get(3).enter(new Lion("Lion",3,150.0));
			cages.get(4).enter(new Lion());
			cages.get(5).enter(new Lion("Leo",2,15));
			cages.get(6).enter(new Elephant());
			cages.get(7).enter(new Gazelle());
			cages.get(8).enter(new Monkey());
			cages.get(9).enter(new Elephant());
		} catch (CageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/		
	}
	
	private Manager() {
		cages = new Vector<>();
		init();
		visitors = new Visitor[Visitor.MAX];
	}

	public static Manager getInstance() {
		return instance;
	}
	
	public String getAnimal(int id) {
		return cages.get(id).toString();
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
		String[] animalsString = new String[cages.size()];
		for (int i = 0; i < animalsString.length; i++) {
			animalsString[i] = getAnimal(i);
		}
		return animalsString;
	}
	
	public void feed() {
		for (ManagedCage cage : cages) {
			if(!cage.isEmpty())
				try {
					cage.feed();
				} catch (CageException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		}
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
