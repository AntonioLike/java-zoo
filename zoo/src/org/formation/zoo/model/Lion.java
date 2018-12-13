package org.formation.zoo.model;

public final class Lion extends Animal{
	
	private static double EATING_WEIGHT = 1.9;
	private static double SLEEPING_WEIGHT = -0.8;
	private static double RUNNING_WEIGHT = -0.5;
	private static double MIN_WEIGHT = 3.0;
	private static double MAX_WEIGHT = 300.0;
	private static int MAX_AGE = 30;
	private static int MIN_AGE = 0;
	private static String SOUND = "RAWR";
	
	public Lion() {
		this("Lion",0,0);
	}
	
	public Lion(String name, int age, double weight) {
		super(name,age,weight);
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

	@Override
	public void eat() {
		setWeight(getWeight()+EATING_WEIGHT);
	}
	
	@Override
	@Deprecated
	public void eat(Gazelle gazelle) {
		setWeight(getWeight()+gazelle.getWeight()/3);
	}
		
	@Override
	public void eat(Being being) throws Exception {
		setWeight(getWeight()+being.getWeight()/3);
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