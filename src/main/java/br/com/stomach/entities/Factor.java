package br.com.stomach.entities;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "periodic")
public class Factor {

	@Id
	private BigInteger _id;
	
	@Indexed
	@Field("initial")
	public String initial;
		
	@Field("periodic")
	public Periodic periodic;
	
	public void setInitial(String initial) {
		this.initial = initial;
	}
	
	public String getInitial() {
		return this.initial;
	}
	
	public void setPeriodic(Periodic periodic) {
		this.periodic = periodic;
	}
	
	public Periodic getPeriodic() {
		return this.periodic;
	}
}
