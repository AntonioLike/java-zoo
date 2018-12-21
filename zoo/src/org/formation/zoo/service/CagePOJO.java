package org.formation.zoo.service;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="animal")
public class CagePOJO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int age;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAnimal;
	private String codeAnimal;
	private String name;
	private double weight;
	@ManyToOne
	@JoinColumn(name="idAnimal",referencedColumnName="idAnimal",updatable=false,insertable=false)
	private GazellePOJO gaz;
	
	public CagePOJO() {
		this(0, 0, 0, 0, null, null, 0 ,null);
	}
	
	public CagePOJO(int x, int y, int age, int idAnimal, String codeAnimal,
			String name, double weight, GazellePOJO gaz) {
		super();
		this.x = x;
		this.y = y;
		this.age = age;
		this.idAnimal = idAnimal;
		this.codeAnimal = codeAnimal;
		this.name = name;
		this.weight = weight;
		this.gaz = gaz;
	}
	
	public CagePOJO(int x, int y) {
		this(x, y, 0, 0, null, null, 0, null);
	}

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
