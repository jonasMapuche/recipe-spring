package br.com.stomach.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.stomach.entities.Factor;

public interface FactorRepository extends MongoRepository<Factor, Long> {

}
