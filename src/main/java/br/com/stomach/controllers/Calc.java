package br.com.stomach.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
		Periodic periodic1 = _factor.findByInitial(initial).getPeriodic();
		Electron electron1 = _valence.findAll().stream().map(index -> index.getElectron()).filter(index -> periodic1.number <= index.sum && periodic1.number > index.sum - index.maximun).findFirst().get();
		List<Equation> listEquantion = new ArrayList<Equation>();
		_factor.findAll().forEach(lista -> {
			Electron electron2 = _valence.findAll().stream().map(index -> index.getElectron()).filter(index -> lista.periodic.getNumber() <= index.sum && lista.periodic.getNumber() > index.sum - index.maximun).findFirst().get();
			List<Element> listElement = new ArrayList<Element>();
			Element element = new Element();
			element.saveDefault(periodic1.getInitial(), periodic1.getNumber(), periodic1.getName(), electron1);
			listElement.add(element);
			element.saveDefault(lista.periodic.getInitial(), lista.periodic.getNumber(), lista.periodic.getName(), electron2);
			listElement.add(element);
			Equation equation = new Equation(listElement);
			listEquantion.add(equation);
		} );
		return listEquantion;
	}
	
	
	public List<Equation> getEquation(FactorService _factor, ValenceService _valence, String initial) {
		List<Equation> equation = getElement(_factor, _valence, initial);
		int need = equation.get(0).element.get(0).level.sum - equation.get(0).element.get(0).valence;
		List<Equation> listEquantion, listFilter = new ArrayList<Equation>();
		listEquantion = loadEquation(_factor, _valence, initial);
		
		/*
		//complete = listEquantion.st stream().filter(index -> index.element.stream().filter(index -> index.valence <= nee
		//List<Element> complete1 = listEquantion.stream().map(index -> index.element).findFirst().get();
		
		List<Element> element = listEquantion.stream().map(index -> index.element).findFirst().get();
		Equation equacao = listEquantion.stream().filter(index -> index.amount == 1).findFirst().get();
		
		List<Equation> complete = new ArrayList<Equation>();
		Predicate<Equation> myAmount = index -> index.amount < 0;
		complete = listEquantion.stream().filter(myAmount).collect(Collectors.toList());		
		listFilter = listEquantion.stream().filter(index -> {
				boolean novo = index.element.stream().filter(myValence).count() > 0;
				return novo;
		}).collect(Collectors.toList());
		//listFilter = listEquantion.stream().filter(index -> index.element.stream().filter(i -> i.valence < 2).count() > 0).collect(Collectors.toList()); 
		*/
		
		Predicate<Element> myValence = index -> index.level.sum - index.valence < need && index.level.sum - index.valence > 0;
		listFilter = listEquantion.stream().filter(index -> index.element.stream().filter(myValence).count() > 0).collect(Collectors.toList()); 
		
		return listFilter;
	}
	
}
