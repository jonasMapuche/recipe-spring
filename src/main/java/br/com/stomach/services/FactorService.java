package br.com.stomach.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stomach.entities.Factor;
import br.com.stomach.entities.Periodic;
import br.com.stomach.repositories.FactorRepository;

@Service
public class FactorService {

	private final FactorRepository repository;
	
	@Autowired
	public FactorService(final FactorRepository repository){
        this.repository = repository;
    }
	
	public void salvar(Periodic register) {
		Factor factor = new Factor();
	    factor.setInitial(register.initial);
	    factor.setPeriodic(register);
	    repository.save(factor);
	}

	public List<Factor> findAll() {
		return repository.findAll();
	}
	
	public Factor findByInitial(String initial) {
		return repository.findByInitial(initial).stream().findFirst().get();
	}
	
}
