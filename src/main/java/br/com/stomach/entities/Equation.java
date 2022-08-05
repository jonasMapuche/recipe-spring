package br.com.stomach.entities;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "equation")
public class Equation {

	@Id
	private BigInteger _id;
	
	@Indexed
	@Field("name")
	public String name;
	@Field("type")
	public String type;
	@Field("multiplier")
	public int multiplier;
	@Field("charge")
	public int charge;
	@Field("amount")
	public int amount;
	@Field("role")
	public List<Element> element;
	
	public Equation() {}
	
	public Equation(List<Element> element) {
		this.name = "equation";
		this.type = "element";
		this.multiplier = 1;
		this.charge = 0;
		this.amount = 1;
		this.element = element;
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
	public void setElement(List<Element> element) {
		this.element = element;
	}
	public List<Element> getElement() {
		return this.element;
	}
	
}
