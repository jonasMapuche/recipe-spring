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
	@Field("charge")
	public int charge;
	@Field("amount")
	public int amount;
	@Field("fullName")
	public String fullName;

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
	public void setValece(int valence) {
		this.valence = valence;
	}
	public int getValence() {
		return this.valence;
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
