package br.com.stomach.entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

public class Periodic {

	@Indexed
	@Field("initial")
	public String initial;
	@Field("number")
	public int number;
	@Field("state")
	public String state;
	@Field("family")
	public String family;
	@Field("nome")
	public String name;
	@Field("mass")
	public float mass; 
	
	public Periodic() {}
	
	public String getInitial() {
		return initial;
	}
	
	public int getNumber() {
		return number;
	}

	public String getState() {
		return state;
	}
	
	public String getFamily() {
		return family;
	}
	
	public String getName() {
		return name;
	}

	public float getMass() {
		return mass;
	}
	
	public void setInitial(String initial) {
		this.initial = initial;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void setFamily(String family) {
		this.family = family;
	}
	
	public void setName(String name) {
		this.name=  name;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}
}
