package br.com.stomach.entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

public class Electron {

	@Indexed
	@Field("initial")
	public String initial;
	@Field("maximun")
	public int maximun;
	@Field("order")
	public int order;
	@Field("level")
	public String level;
	@Field("sum")
	public int sum;
	
	
	public void setInitial(String initial) {
		this.initial = initial;
	}
	
	public String getInitial() {
		return this.initial;
	}
	
	public void setMaximun(int maximun) {
		this.maximun = maximun;
	}
	
	public int getMaximun() {
		return this.maximun;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public int getOrder() {
		return this.order;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getLevel() {
		return this.level;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public int getSum() {
		return this.sum;
	}
}
