package org.formation.zoo.model;

public abstract class Animal {
	private String name;
	private int age;
	private double weight;
//
//	protected double EATING_WEIGHT;
//	protected double SLEEPING_WEIGHT;
//	protected double RUNNING_WEIGHT;
//	protected double MIN_WEIGHT;
//	protected double MAX_WEIGHT;
//	protected int MAX_AGE;
//	protected int MIN_AGE;
//	protected String SOUND;
		
	public Animal(String name, int age, double weight) {
		super();
		setName(name);
		setAge(age);
		setWeight(weight);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getWeight() {
		return weight;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setAge(int age) {
		this.age=age;
	}

	protected void setWeight(double weight) {
		this.weight = weight ;
	}
	
	/**
	 * @return a string representing the animal(it's name, age, weight...)
	 */
	public String display() {
		return String.join(" ","I'm the", getName(), "I am", Integer.toString(getAge()), "years old and I weigh", Double.toString(getWeight()), "Kg");
	}
	
	/**
	 * Be careful : Overriding possible with the display method.
	 * method polymorphism!!
	 */
	@Override
	public String toString() {
		return display();
	}
}
