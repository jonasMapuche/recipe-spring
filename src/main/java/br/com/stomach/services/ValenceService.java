package br.com.stomach.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stomach.repositories.ValenceRepository;

@Service
public class ValenceService {

	private final ValenceRepository repository;
	
	@Autowired
	public ValenceService(final ValenceRepository repository){
        this.repository = repository;
    }
}
