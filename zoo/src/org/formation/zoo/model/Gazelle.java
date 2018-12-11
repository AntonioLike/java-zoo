package org.formation.zoo.model;

public class Gazelle extends Animal{
	
	private final double EATING_WEIGHT = 0.075;
	private final double SLEEPING_WEIGHT = -0.05;
	private final double RUNNING_WEIGHT = -0.01;
	private final double MIN_WEIGHT = 5.0;
	private final double MAX_WEIGHT = 100.0;
	private final int MAX_AGE = 12;
	private final int MIN_AGE = 0;

	
	private int hornsLength;
	
	public Gazelle(String name, int age, double weight, int hornsLength) {
		super(name, age, weight);
		setHornsLength(hornsLength);
	}
	
	public int getHornsLength() {
		return hornsLength;
	}

	protected void setAge(int age) {
		if (age > MAX_AGE)
			 super.setAge(MAX_AGE);
		else if (age < MIN_AGE)
			super.setAge(MIN_AGE);
		else
			super.setAge(age);
	}

	protected void setWeight(double weight) {
		if(weight>MAX_WEIGHT)
			super.setWeight(MAX_WEIGHT);
		else if (weight < MIN_WEIGHT)
			super.setWeight(MIN_WEIGHT);
		else
			super.setWeight(weight);
	}
	
	protected void setHornsLength(int hornsLength) {
		this.hornsLength = hornsLength;
	}
	
	public void eat() {
		setWeight(getWeight()+EATING_WEIGHT);
	}
	
	public void sleep() {
		setWeight(getWeight()+SLEEPING_WEIGHT);
	}
	
	public void run() {
		setWeight(getWeight()+RUNNING_WEIGHT);
	}
	
	public String display() {
		return String.join(" ",super.display(),"and my horns are",Integer.toString(getHornsLength()),"cm long");
	}
}
