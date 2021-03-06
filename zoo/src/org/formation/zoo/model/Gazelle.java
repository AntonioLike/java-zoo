package org.formation.zoo.model;

public final class Gazelle extends Animal implements Eatable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static double EATING_WEIGHT = 0.075;
	private static double SLEEPING_WEIGHT = -0.05;
	private static double RUNNING_WEIGHT = -0.01;
	private static double MIN_WEIGHT = 5.0;
	private static double MAX_WEIGHT = 100.0;
	private static int MAX_AGE = 12;
	private static int MIN_AGE = 0;

	private int hornsLength;

	public Gazelle() {
		this("Gazelle", 0, 0, 0);
	}

	public Gazelle(String name, int age, double weight) {
		this(name,age,weight,0);
	}
	
	public Gazelle(String name, int age, double weight, int hornsLength) {
		super(name, age, weight);
		setHornsLength(hornsLength);
	}

	public int getHornsLength() {
		return hornsLength;
	}

	@Override
	public double getFood() {
		return getWeight(); 
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
		if (weight > MAX_WEIGHT)
			super.setWeight(MAX_WEIGHT);
		else if (weight < MIN_WEIGHT)
			super.setWeight(MIN_WEIGHT);
		else
			super.setWeight(weight);
	}

	protected void setHornsLength(int hornsLength) {
		this.hornsLength = hornsLength;
	}

	@Override
	public void eat() {
		setWeight(getWeight() + EATING_WEIGHT);
	}

	@Override
	public void sleep() {
		setWeight(getWeight() + SLEEPING_WEIGHT);
	}

	public void run() {
		setWeight(getWeight() + RUNNING_WEIGHT);
	}

	@Override
	public String display() {
		return String.join(" ", super.display(), "and my horns are", Integer.toString(getHornsLength()), "cm long");
	}
}
