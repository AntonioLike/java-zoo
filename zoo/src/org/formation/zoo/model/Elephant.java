package org.formation.zoo.model;

public final class Elephant extends Animal {

	private static double EATING_WEIGHT = 15.9;
	private static double SLEEPING_WEIGHT = -5.3;
	private static double RUNNING_WEIGHT = -3.5;
	private static double MIN_WEIGHT = 25.0;
	private static double MAX_WEIGHT = 15000.0;
	private static int MAX_AGE = 150;
	private static int MIN_AGE = 0;
	
	public Elephant() {
		this("Elephant",0,0);
	}
	
	public Elephant(String name, int age, double weight) {
		super(name, age, weight);
	}

	@Override
	public void eat() {
		setWeight(getWeight() + EATING_WEIGHT);

	}

	@Override
	public void sleep() {
		setWeight(getWeight() + SLEEPING_WEIGHT);

	}
	
	@Override
	public void run() {
		setWeight(getWeight() + RUNNING_WEIGHT);
	}

	@Override
	protected void setAge(int age) {
		if (age > MAX_AGE)
			 super.setAge(MAX_AGE);
		else if (age < MIN_AGE)
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
}