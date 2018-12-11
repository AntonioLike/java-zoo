package org.formation.zoo.model;

public class Gazelle {
	private static final double EATING_WEIGHT = 0.075;
	private static final double SLEEPING_WEIGHT = -0.05;
	private static final double RUNNING_WEIGHT = -0.01;
	private static final double MIN_WEIGHT = 5.0;
	private static final double MAX_WEIGHT = 100.0;
	private static final int MAX_AGE = 12;
	private static final int MIN_AGE = 0;
	
	private String name;
	private int age;
	private double weight;
	private int hornsLength;

	public Gazelle() {
		this("Gazelle",MIN_AGE,MIN_WEIGHT,0);
	}
	
	public Gazelle(String name, int age, double weight, int hornsLength) {
		super();
		setName(name);
		setAge(age);
		setWeight(weight);
		setHornsLength(hornsLength);
	}
	
	public int getHornsLength() {
		return hornsLength;
	}

	public void setHornsLength(int hornsLength) {
		this.hornsLength = hornsLength;
	}


	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	private void setAge(int age) {
		if (age > MAX_AGE)
			this.age = MAX_AGE;
		else if (age < MIN_AGE)
			this.age = MIN_AGE;
		else
			this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	private void setWeight(double weight) {
		if(weight > MAX_WEIGHT)
			this.weight = MAX_WEIGHT;
		else if (weight < MIN_WEIGHT)
			this.weight = MIN_WEIGHT;
		else 
			this.weight = weight;
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
		return String.join(" ","I'm the gazelle", getName(), "I am", Integer.toString(getAge()), "years old and I weigh", Double.toString(getWeight()));
	}
}
