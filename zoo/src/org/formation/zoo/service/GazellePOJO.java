package org.formation.zoo.service;

public class GazellePOJO {
	
	private int id, idAnimal, hornsLength;

	public GazellePOJO() {
		// TODO Auto-generated constructor stub
	}	

	public GazellePOJO(int id, int idAnimal, int hornsLength) {
		super();
		setId(idAnimal);
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
