package br.com.stomach.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.stomach.services.FactorService;
import br.com.stomach.services.ValenceService;

public class Controller {

	@Autowired
    private FactorService _factor;
	@Autowired
	private ValenceService _valence;
	
	@GetMapping("")
	public ResponseEntity<String> get() {
		return ResponseEntity.ok("Hello World for Project Extrapolator Chemical!");
	}
}
