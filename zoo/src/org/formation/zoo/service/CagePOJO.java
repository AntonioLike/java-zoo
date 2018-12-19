package org.formation.zoo.service;

import java.io.Serializable;

public class CagePOJO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x,y,age,idAnimal;
	private String codeAnimal;
	private String name;
	private double weight;
	private GazellePOJO gaz;
	public GazellePOJO getGaz() {
		return gaz;
	}
	public void setGaz(GazellePOJO gaz) {
		this.gaz = gaz;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public String getCodeAnimal() {
		return codeAnimal;
	}
	public void setCodeAnimal(String codeAnimal) {
		this.codeAnimal = codeAnimal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
