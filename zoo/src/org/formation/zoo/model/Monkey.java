package org.formation.zoo.model;


public class Monkey extends Animal{
	
	private final double EATING_WEIGHT = 0.3;
	private final double SLEEPING_WEIGHT = -0.1;
	private final double RUNNING_WEIGHT = -0.15;
	private final double MIN_WEIGHT = 1.5;
	private final double MAX_WEIGHT = 40.0;
	private final int MAX_AGE = 40;
	private final int MIN_AGE = 0;
	private final String SOUND = "OHOH";
	
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
	
	public void run() {
		setWeight(getWeight()+RUNNING_WEIGHT);
	}
	
	public String sound() {
		return SOUND;
	}
}

