package br.com.stomach.entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

public class Element {

	@Indexed
	@Field("name")
	public String name;
	@Field("type")
	public String type;
	@Field("multiplier")
	public int multiplier;
	@Field("valence")
	public int valence;
	@Field("level")
	public Electron level;
	@Field("charge")
	public int charge;
	@Field("amount")
	public int amount;
	@Field("fullName")
	public String fullName;
	
	public Element() {}
	
	public Element (String initial, int number, String fullName, Electron electron) {
		this.name = initial;
		this.type = "default";
		this.multiplier = 1;
		this.valence = number;
		this.level = electron;
		this.charge = 0;
		this.amount = 1;
		this.fullName = fullName;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}
	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}
	public int getMultiplier() {
		return this.multiplier;
	}
	public void setValence(int valence) {
		this.charge = valence;
	}
	public int getValence() {
		return this.valence;
	}
	public void setLevel(Electron level) {
		this.level = level;
	}
	public Electron getLevel() {
		return this.level;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public int getCharge() {
		return this.charge;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAmount() {
		return this.amount;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullName() {
		return this.fullName;
	}

}
