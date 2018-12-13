package org.formation.zoo.model;

public interface Being {
	public void eat();
	@Deprecated
	public void eat(Gazelle gazelle) throws Exception;
	public void eat(Being being) throws Exception;
	public void run();
	public void jump();
	public void sleep();
	public String display();
	public String sound();
	public default double getWeight() {
		return 60;
	};
}
