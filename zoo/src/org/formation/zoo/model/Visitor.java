package org.formation.zoo.model;

import java.io.Serializable;

import org.formation.zoo.technical.YuckException;

public class Visitor implements Being, Eatable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int amount = 0;
	public static int MAX = 10;
	
	public Visitor() {
		amount ++;
	}

	public static int getAmount() {
		return amount;
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
	public void eat(Eatable being) throws YuckException{
		throw new YuckException();
	}
	
	@Override
	@Deprecated
	public void eat(Gazelle gazelle) throws Exception {
		// TODO Auto-generated method stub

	}

	@Deprecated
	@Override
	public void eat(Being being)  throws YuckException{
		throw new YuckException();
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
		amount --;
		super.finalize();
	}
}
