package org.formation.zoo.view;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.formation.zoo.controller.Manager;
import org.formation.zoo.model.Animal;
import org.formation.zoo.model.Gazelle;

public class Zoo {
	
	public Zoo() {
	}
	
	public void display() {
		Arrays.asList(Manager.getInstance().getAnimals()).forEach(System.out::println);
	}
	
	public void feed() {
		Manager.getInstance().feed();
	}
	
	public String newVisitor() {
		return Manager.getInstance().newVisitor();
	}
	
	public String visitorLeaves() {
		return Manager.getInstance().visitorleaves();
	}
	
	public int getAmountAnimals() {
		return Manager.getInstance().getAmountAnimals();
	}
	
	public String devour(int eater, int eaten, TypesOfEatable type) {
		return Manager.getInstance().devour(eater, eaten, type);
	}
	
	public String getSpecies(int i) {
		return Manager.getInstance().getSpecies(i);
	}
	
	public void addAnimal(Animal animal, int id) {
		Manager.getInstance().addAnimal(animal, id);
	}
	
	public int getAmountVisitors() {
		return Manager.getInstance().getAmountVisitors();
	}
	
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		final PrintStream originalOut = System.out;
		
		System.setOut(new PrintStream(outContent));
		
		System.setOut(originalOut);
		
		zoo.display();
		
		zoo.feed();
		
		Gazelle gazelle = new Gazelle("Bambi", 2, 15, 5);
		
		zoo.addAnimal(gazelle, 1);
		
		zoo.newVisitor();
		
		for(int i=0; i<10; i++)
			zoo.newVisitor();
		
		zoo.display();
		
		zoo.visitorLeaves();
		zoo.visitorLeaves();
		
		for (int i = 0; i<zoo.getAmountAnimals();i++)
			for(int j = 0; j<zoo.getAmountAnimals();j++) {
				if(i!=j) {
					System.out.println(String.join(" ", zoo.getSpecies(i), "eats", zoo.getSpecies(j)));
					System.out.println(zoo.devour(i, j,TypesOfEatable.ANIMAL));
				}
			}
		
		for (int i = 0; i<zoo.getAmountAnimals();i++)
			for(int j = 0; j<zoo.getAmountVisitors();j++) {
				System.out.println(String.join(" ", zoo.getSpecies(i), "eats visitor", Integer.toString(j)));
				System.out.println(zoo.devour(i, j,TypesOfEatable.VISITOR));
			}
		zoo.display();
	}
}                                        