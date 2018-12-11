package org.formation.zoo.view;

import org.formation.zoo.model.Gazelle;
import org.formation.zoo.model.Lion;
import org.formation.zoo.model.Monkey;

public class Zoo {
	private Gazelle gazelle;
	private Lion lion;
	private Monkey monkey;	
	
	public Zoo() {
		this.gazelle = new Gazelle("Gazelle", 5, 70.0,10);
		this.lion = new Lion("Lion", 3, 150.0);
		this.monkey = new Monkey("Monkey", 7, 15);
	}
	
	public void display() {
		System.out.println(lion.display());
		System.out.println(gazelle.display());
		System.out.println(monkey.display());
	}
	
	public void feed() {
		lion.eat();
		gazelle.eat();
		monkey.eat();
	}
	
	public static void main(String[] args) {
		Zoo zoo = new Zoo();

		zoo.display();
		zoo.feed();
		zoo.display();
	}
}
