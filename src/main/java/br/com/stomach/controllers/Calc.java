package br.com.stomach.controllers;

import br.com.stomach.entities.Electron;
import br.com.stomach.entities.Periodic;
import br.com.stomach.services.FactorService;
import br.com.stomach.services.ValenceService;

public class Calc {

	public Calc() {}
	
	public String getName(FactorService _factor, String initial) {
		String factor = _factor.findAll().stream().filter(index -> initial.equals(index.getInitial())).map(index -> index.getPeriodic()).findFirst().map(index -> index.getName()).get();
		return factor;
	}
	
	public Electron getLasLevel(FactorService _factor, ValenceService _valence, String initial) {
		Periodic periodic = _factor.findByInitial(initial).getPeriodic();
		Electron electron = _valence.findAll().stream().map(index -> index.getElectron()).filter(index -> periodic.number <= index.sum && periodic.number > index.sum - index.maximun).findFirst().get();
		
		//int maximo = _valence.findAll().stream().reduce(0, (subtotal, index) -> subtotal + index.getElectron().getMaximun(), Integer::sum);
		
		/*
		
		Periodic periodic = _factor.  .getName();				
				
				
				
				findAll( .stream().filter(index -> initial.equals(index.getInitial())).map(index -> index.getPeriodic()).findFirst().map(index -> index.getName()).get();
		return factor;
		*/
		return electron;
	}
	
}
