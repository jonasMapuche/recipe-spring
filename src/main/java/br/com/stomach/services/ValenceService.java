package br.com.stomach.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stomach.entities.Electron;
import br.com.stomach.entities.Valence;
import br.com.stomach.repositories.ValenceRepository;

@Service
public class ValenceService {

	private final ValenceRepository repository;
	
	@Autowired
	public ValenceService(final ValenceRepository repository){
        this.repository = repository;
    }
	
	public void salvar(Electron electron) {
		Valence valence = new Valence();
		valence.setInitial(electron.initial);
		valence.setElectron(electron);
	    repository.save(valence);
	}

	public List<Valence> findAll() {
		return repository.findAll();
	}
	
	public Valence findByInitial(String initial) {
		return repository.findByInitial(initial).stream().findFirst().get();
	}
	
}
