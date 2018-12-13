package org.formation.zoo.model;

public class Visitor implements Being, Eatable{

	public Visitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getFood() {
		return 3;
	}
	
	@Override
	public void eat(Eatable being) throws Exception {
		// TODO Auto-generated method stub
	}
	
	@Override
	@Deprecated
	public void eat(Gazelle gazelle) throws Exception {
		// TODO Auto-generated method stub

	}

	@Deprecated
	@Override
	public void eat(Being being) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub

	}

	@Override
	public String display() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sound() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Oof!");
		super.finalize();
	}
}
