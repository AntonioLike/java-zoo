package org.formation.zoo.view;

import org.formation.zoo.model.Elephant;
import org.formation.zoo.model.Gazelle;
import org.formation.zoo.model.Lion;
import org.formation.zoo.model.Monkey;

public class Zoo {
	private Gazelle gazelle;
	private Lion lion;
	private Monkey monkey;
	private Elephant elephant;
	
	public Zoo() {
		this.gazelle = new Gazelle("Gazelle", 5, 70.0,10);
		this.lion = new Lion("Lion", 3, 150.0);
		this.monkey = new Monkey("Monkey", 7, 15);
		this.elephant = new Elephant("Elephant", 5, 7500);
	}
	
	public void display() {
		System.out.println(lion);
		if(gazelle != null)
			System.out.println(gazelle);
		System.out.println(monkey);
		System.out.println(elephant);
	}
	
	public void feed() {
		lion.eat();
		gazelle.eat();
		monkey.eat();
		elephant.eat();
		lion.eat(gazelle);
	}
	
	public void devour() {
		lion.eat(gazelle);
		gazelle = null;
		System.gc();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Zoo zoo = new Zoo();

		zoo.display();
		zoo.feed();
		zoo.devour();
		zoo.display();
	}
}