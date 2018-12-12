package org.formation.zoo.model;


public class Monkey extends Animal{
	
	private static double EATING_WEIGHT = 0.3;
	private static double SLEEPING_WEIGHT = -0.1;
	private static double RUNNING_WEIGHT = -0.15;
	private static double MIN_WEIGHT = 1.5;
	private static double MAX_WEIGHT = 40.0;
	private static int MAX_AGE = 40;
	private static int MIN_AGE = 0;
	private static String SOUND = "OHOH";
	
	public Monkey() {
		this("Monkey",0,0);
	}
	
	public Monkey(String name, int age, double weight) {
		super(name,age,weight);
	}
	
	@Override
	protected void setAge(int age) {
		if(age > MAX_AGE)
			super.setAge(MAX_AGE);
		else if ( age < MIN_AGE)
			super.setAge(MIN_AGE);
		else
			super.setAge(age);
		
	}

	@Override
	protected void setWeight(double weight) {
		if(weight>MAX_WEIGHT)
			super.setWeight(MAX_WEIGHT);
		else if (weight < MIN_WEIGHT)
			super.setWeight(MIN_WEIGHT);
		else
			super.setWeight(weight);
	}
	
	@Override
	public void eat() {
		setWeight(getWeight()+EATING_WEIGHT);
	}
	
	@Override
	public void sleep() {
		setWeight(getWeight()+SLEEPING_WEIGHT);
	}
	
	@Override
	public void run() {
		setWeight(getWeight()+RUNNING_WEIGHT);
	}
	
	@Override
	public String sound() {
		return SOUND;
	}
}

