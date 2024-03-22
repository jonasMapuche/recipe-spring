package br.com.stomach.entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

public class Element {

	@Indexed
	@Field("name")
	public String name;
	@Field("multiplier")
	public int multiplier;
	@Field("amount")
	public int amount;
	@Field("valence")
	public int valence;	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}
	public int getMultiplier() {
		return this.multiplier;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAmount() {
		return this.amount;
	}
	public void setValence(int valence) {
		this.valence = valence;
	}
	public int getValence() {
		return this.valence;
	}
}
