package org.formation.zoo.service;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gazelle")
public class GazellePOJO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int idAnimal;
	private int hornsLength;

	public GazellePOJO() {
		// TODO Auto-generated constructor stub
	}	

	public GazellePOJO(int id, int idAnimal, int hornsLength) {
		super();
		setId(id);
		setIdAnimal(idAnimal);
		setHornsLength(hornsLength);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public int getHornsLength() {
		return hornsLength;
	}

	public void setHornsLength(int hornsLength) {
		this.hornsLength = hornsLength;
	}
}
