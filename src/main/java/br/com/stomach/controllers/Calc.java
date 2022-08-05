package br.com.stomach.controllers;

import java.util.ArrayList;
import java.util.List;

import br.com.stomach.entities.Electron;
import br.com.stomach.entities.Element;
import br.com.stomach.entities.Equation;
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
		
		/*
		 * int maximo = _valence.findAll().stream().reduce(0, (subtotal, index) -> subtotal + index.getElectron().getMaximun(), Integer::sum);
		 * Periodic periodic = _factor.  .getName();				
		 * findAll( .stream().filter(index -> initial.equals(index.getInitial())).map(index -> index.getPeriodic()).findFirst().map(index -> index.getName()).get();
		 * return factor;
		*/
		
		return electron;
	}

	public List<Equation> getElement(FactorService _factor, ValenceService _valence, String initial) {
		Periodic periodic = _factor.findByInitial(initial).getPeriodic();
		Electron electron = _valence.findAll().stream().map(index -> index.getElectron()).filter(index -> periodic.number <= index.sum && periodic.number > index.sum - index.maximun).findFirst().get();
		Element element = new Element();
		element.name = periodic.name;
		element.type = "default";
		element.multiplier = 1;
		element.valence = periodic.number;
		element.level = electron;
		element.charge = 0;
		element.amount = 1;
		element.fullName = periodic.name;
		List<Element> listElement = new ArrayList<Element>();
		listElement.add(element);
		Equation equation = new Equation();
		equation.name = "equation";
		equation.type = "element";
		equation.multiplier = 1;
		equation.charge = 0;
		equation.amount = 1;
		equation.element = listElement;
		List<Equation> listEquantion = new ArrayList<Equation>();
		listEquantion.add(equation);
		return listEquantion;
	}
	
	public List<Equation> loadEquation(FactorService _factor, ValenceService _valence, String initial) {
		List<Equation> listEquantion = new ArrayList<Equation>();
		_factor.findAll().forEach(lista -> {
			Electron electron = _valence.findAll().stream().map(index -> index.getElectron()).filter(index -> lista.periodic.getNumber() <= index.sum && lista.periodic.getNumber() > index.sum - index.maximun).findFirst().get();
			Element element = new Element(lista.periodic.getInitial(), lista.periodic.getNumber(), lista.periodic.getName(), electron);
			List<Element> listElement = new ArrayList<Element>();
			listElement.add(element);
			Equation equation = new Equation(listElement);
			listEquantion.add(equation);
		} );
		return listEquantion;
	}
	
	
	public List<Equation> getEquation(FactorService _factor, ValenceService _valence, String initial) {
		List<Equation> equation = getElement(_factor, _valence, initial);
		int need = equation.get(0).element.get(0).level.sum - equation.get(0).element.get(0).valence;
		List<Equation> listEquantion = loadEquation(_factor, _valence, initial);
		List<Equation> complete = new ArrayList<Equation>();
		//complete = listEquantion.st stream().filter(index -> index.element.stream().filter(index -> index.valence <= need));
		return listEquantion;
	}
	
}
