package org.formation.zoo.view;

import org.formation.zoo.model.Elephant;
import org.formation.zoo.model.Gazelle;
import org.formation.zoo.model.Lion;
import org.formation.zoo.model.Monkey;

public class Zoo {
	private Gazelle gazelle;
	private Lion lions[];
	private Monkey monkey;
	private Elephant elephant;
	
	private void init()
	{
		lions[0] = new Lion("Lion",3,150.0);
		lions[1] = new Lion();
		lions[2] = new Lion("Leo",2,15);
	}
	
	public Zoo() {
		this.gazelle = new Gazelle("Gazelle", 5, 70.0,10);
		lions = new Lion[3];
		//("Lion", 3, 150.0);
		this.monkey = new Monkey("Monkey", 7, 15);
		this.elephant = new Elephant("Elephant", 5, 7500);
		init();
	}
		
	public void display() {
		for (Lion lion : lions) {
			System.out.println(lion);	
		}
		if(gazelle != null)
			System.out.println(gazelle);
		System.out.println(monkey);
		System.out.println(elephant);
	}
	
	public void feed() {
		for (Lion lion : lions) {
			lion.eat();	
		}
		gazelle.eat();
		monkey.eat();
		elephant.eat();
	}
	
	public void devour() {
		monkey.eat(gazelle);
		elephant.eat(gazelle);
		gazelle.eat(gazelle);
		lions[0].eat(gazelle);
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