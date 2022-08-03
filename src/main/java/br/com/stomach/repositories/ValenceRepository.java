package br.com.stomach.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.stomach.entities.Valence;

public interface ValenceRepository extends MongoRepository<Valence, Long> {

}
