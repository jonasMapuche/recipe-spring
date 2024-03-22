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
	public List<String> name;
	@Field("type")
	public String type;
	@Field("initial")
	public String initial;
	@Field("element")
	public List<Element> element;

	public void setName(List<String> name) {
		this.name = name;
	}
	public List<String> getName() {
		return this.name;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
	public String getInitial() {
		return this.initial;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}
	public void setElement(List<Element> element) {
		this.element = element;
	}
	public List<Element> getElement() {
		return this.element;
	}
	
}
