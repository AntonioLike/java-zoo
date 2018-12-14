package org.formation.zoo.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.formation.zoo.model.Animal;
import org.formation.zoo.model.Eatable;
import org.formation.zoo.model.Elephant;
import org.formation.zoo.model.Gazelle;
import org.formation.zoo.model.Lion;
import org.formation.zoo.model.Monkey;
import org.formation.zoo.model.Visitor;
import org.formation.zoo.tools.Broom;

public class Zoo {
	private Animal animals[];
	private Visitor visitors[];	
	
	
	private void init()
	{
		animals[0] = new Gazelle("Gazelle", 5, 70.0,10);
		animals[1] = new Monkey("Monkey", 7, 15);
		animals[2] = new Elephant("Elephant", 5, 7500);
		animals[3] = new Lion("Lion",3,150.0);
		animals[4] = new Lion();
		animals[5] = new Lion("Leo",2,15);
		animals[6] = new Elephant();
		animals[7] = new Gazelle();
		animals[8] = new Monkey();
		animals[9] = new Elephant();
	}
	
	public Zoo() {
		animals = new Animal[10];
		visitors = new Visitor[Visitor.MAX];
		init();
	}
	
	public void newVisitor() {
		if(Visitor.getAmount()<10)
			visitors[Visitor.getAmount()]=new Visitor();
		else 
			System.out.println("The zoo is full, you'll have to wait until a visitor leaves or dies :(!");
	}
	
	public void visitorleaves() {
		if(Visitor.getAmount()>0) {
			visitors[Visitor.getAmount()-1]=null;
			System.out.println(String.join(" ", "Visitor left", Integer.toString(Visitor.getAmount()), "left"));
		}
		Broom.sweep();
	}
	
	public void display(int id) {
		animals[id].display();
	}
	
	public boolean isCageEmpty(int id) {
		return id<animals.length? animals[id]==null:false;
	}
	
	public boolean isVisitorAlive(int id) {
		return id<visitors.length? visitors[id]!=null:false;
	}
	
	public int getAmountAnimals() {
		return animals.length;
	}
	
	public int getAmountVisitors() {
		return visitors.length;
	}
	
	public String getSpecies(int i) {
		return animals[i]==null? "":animals[i].getClass().getSimpleName();
	}
	
	public void display() {
		for (Animal animal : animals) {
			if (animal != null)
				System.out.println(animal);
			else 
				System.out.println("The cage is empty!");
		}
		for (int i = 0; i<visitors.length;i++) {
			if (visitors[i]!=null)
				System.out.println(String.join(" ", "Visitor", Integer.toString(i), "is alive"));
			else
				System.out.println(String.join(" ", "Visitor", Integer.toString(i), "is dead"));
		}
	}
	
	public void feed() {
		for (Animal animal : animals) {
			animal.eat();	
		}
	}
	
	public void devour(int eater, int eaten,boolean animal) {
		if(animal)
			try {
				animals[eater].eat((Eatable) animals[eaten]);
				animals[eaten] = null;
				Broom.sweep();
			} catch (Exception e1) {
				System.out.println("yuck!");
			}
		else
			try {
				animals[eater].eat((Eatable) visitors[eaten]);
				visitors[eaten] = null;
				Broom.sweep();
			} catch (Exception e1) {
				System.out.println("yuck!");
			}
	}
	
	static int test = 0;
	
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		final PrintStream originalOut = System.out;
		
		System.setOut(new PrintStream(outContent));
		
		System.setOut(originalOut);
		
		zoo.display();
		zoo.feed();

		zoo.newVisitor();
		
		for(int i=0; i<10; i++)
			zoo.newVisitor();
		
		zoo.display();
		
		zoo.visitorleaves();
		zoo.visitorleaves();
		
		for (int i = 0; i<zoo.getAmountAnimals();i++)
			for(int j = 0; j<zoo.getAmountAnimals();j++) {
				System.out.println(String.join(" ", zoo.getSpecies(i), "eats", zoo.getSpecies(j)));
				zoo.devour(i, j,true);
			}
		
		for (int i = 0; i<zoo.getAmountAnimals();i++)
			for(int j = 0; j<zoo.getAmountVisitors();j++) {
				System.out.println(String.join(" ", zoo.getSpecies(i), "eats visitor", Integer.toString(j)));
				zoo.devour(i, j, false);
			}
		zoo.display();
	}
}                                        