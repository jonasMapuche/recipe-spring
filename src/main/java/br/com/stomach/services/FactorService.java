package br.com.stomach.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stomach.repositories.FactorRepository;

@Service
public class FactorService {

	private final FactorRepository repository;
	
	@Autowired
	public FactorService(final FactorRepository repository){
        this.repository = repository;
    }
}
