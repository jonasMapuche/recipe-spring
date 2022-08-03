package br.com.stomach.entities;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "valence")
public class Valence {

	@Id
	private BigInteger _id;
	
	@Indexed
	@Field("initial")
	public String initial;
		
	@Field("electron")
	public Electron electron;
	
	public void setInitial(String initial) {
		this.initial = initial;
	}
	
	public String getInitial() {
		return this.initial;
	}
	
	public void setElectron(Electron electron) {
		this.electron = electron;
	}
	
	public Electron getElectron() {
		return this.electron;
	}
	
}
