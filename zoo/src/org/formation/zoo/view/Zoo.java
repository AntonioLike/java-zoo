package org.formation.zoo.view;

import org.formation.zoo.model.Animal;
import org.formation.zoo.model.Elephant;
import org.formation.zoo.model.Gazelle;
import org.formation.zoo.model.Lion;
import org.formation.zoo.model.Monkey;

public class Zoo {
	private Animal animals[];
	
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
		init();
	}
		
	public void display() {
		for (Animal animal : animals) {
			if (animal != null)
				System.out.println(animal);
			else 
				System.out.println("The cage is empty!");
		}
	}
	
	public void feed() {
		for (Animal animal : animals) {
			animal.eat();	
		}
	}
	
	public void devour(int eater, int eaten) {
		if(animals[eaten] instanceof Gazelle) {
			animals[eater].eat((Gazelle) animals[eaten]);
			if(animals[eater] instanceof Lion)
				animals[eaten] = null;
		}
		//FIXME add exception
			
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
		zoo.devour(4,0);
		zoo.display();
	}
}                                        