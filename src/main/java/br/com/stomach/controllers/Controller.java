package br.com.stomach.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.stomach.entities.Electron;
import br.com.stomach.entities.Element;
import br.com.stomach.entities.Equation;
import br.com.stomach.entities.Factor;
import br.com.stomach.entities.Periodic;
import br.com.stomach.entities.Valence;
import br.com.stomach.services.EquationService;
import br.com.stomach.services.FactorService;
import br.com.stomach.services.ValenceService;

@RestController
@RequestMapping("/recipe")
public class Controller {

	@Autowired
    private FactorService _factor;
	@Autowired
	private ValenceService _valence;
	@Autowired
	private EquationService _equation;
	
	@GetMapping("")
	public ResponseEntity<String> get() {
		return ResponseEntity.ok("Hello World for Project Extrapolator Chemical!");
	}
	
	@GetMapping("/factor")
	public List<Factor> getAll() {
		return _factor.findAll();
	}
	
	@PostMapping("/factor")
	public Periodic post(@RequestBody Periodic periodic) {
	    _factor.salvar(periodic);
	    return periodic;
	}

	@GetMapping("/factor/{initial}")
	public Factor getFactor(@PathVariable String initial) {
		return _factor.findByInitial(initial);
	}
	
	@GetMapping("/valence")
	public List<Valence> getAllValence() {
		return _valence.findAll();
	}
	
	@PostMapping("/valence")
	Electron post(@RequestBody Electron electron) {
	    _valence.salvar(electron);
	    return electron;
	}

	@GetMapping("/valence/{initial}")
	public Valence getValence(@PathVariable String initial) {
		return _valence.findByInitial(initial);
	}
	
	@GetMapping("/equation")
	public List<Equation> getAllEquation() {
		return _equation.findAll();
	}
	
	@PostMapping("/equation")
	Equation post(@RequestBody Equation equation) {
	    _equation.salvar(equation);
	    return equation;
	}
	
	@GetMapping("/equation/{initial}")
	public Equation getEquation(@PathVariable String initial) {
		return _equation.findByInitial(initial);
	}

	/*
	@GetMapping("/level/{initial}")
	public Electron getValenceFactor(@PathVariable String initial) {
		Calc calc = new Calc();
		Electron electron = calc.getLasLevel(_factor, _valence, initial);
		return electron;
	}
	*/
	/*
	@GetMapping("/element/{initial}")
	public List<Equation> getElement(@PathVariable String initial) {
		Calc calc = new Calc();
		List<Equation> equation = calc.getElement(_factor, _valence, initial);
		return equation;
	}
	*/
	/*
	@GetMapping("/equation/{initial}")
	public List<Equation> getEquation(@PathVariable String initial) {
		Calc calc = new Calc();
		List<Equation> equation = calc.getEquation(_factor, _valence, initial);
		return equation;
	}
	*/
	/*
	@GetMapping("/multiplier/{initial}")
	public List<Equation> getMultiplier(@PathVariable String initial) {
		Calc calc = new Calc();
		List<Equation> equation = calc.getMultiplier(_factor, _valence, initial);
		return equation;
	}
	*/
}
