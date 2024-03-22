package br.com.stomach.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stomach.entities.Equation;
import br.com.stomach.repositories.EquationRepository;

@Service
public class EquationService {

	private final EquationRepository repository;
	
	@Autowired
	public EquationService(final EquationRepository repository){
        this.repository = repository;
    }
	
	public void salvar(Equation equation) {
	    repository.save(equation);
	}

	public List<Equation> findAll() {
		return repository.findAll();
	}
	
	public Equation findByInitial(String initial) {
		return repository.findByInitial(initial).stream().findFirst().get();
	}
	
}
