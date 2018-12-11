package org.formation.zoo.model;

public class Lion {
	private final double EATING_WEIGHT = 1.9;
	private final double SLEEPING_WEIGHT = -0.8;
	private final double RUNNING_WEIGHT = -0.5;
	private final double MIN_WEIGHT = 3.0;
	private final double MAX_WEIGHT = 300.0;
	private final int MAX_AGE = 30;
	private final int MIN_AGE = 0;
	private final String SOUND = "RAWR";	
	
	private String name;
	private int age;
	private double weight;
	
	public Lion() {
		setName("Lion");
		setAge(0);
		setWeight(3.0);
	}
	
	public Lion(String name, int age, double weight) {
		super();
		setName(name);
		setAge(age);
		setWeight(weight);
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
		if(age > MAX_AGE)
			this.age = MAX_AGE;
		else if ( age < MIN_AGE)
			this.age = MIN_AGE;
		else
			this.age = age;
		
	}

	public double getWeight() {
		return weight;
	}

	private void setWeight(double weight) {
		if(weight>MAX_WEIGHT)
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
		return String.join(" ","I'm the lion", getName(), ", I am", Integer.toString(getAge()), "years old and I weigh", Double.toString(getWeight()),"Kg");
	}
	
	public String sound() {
		return SOUND;
	}
}
