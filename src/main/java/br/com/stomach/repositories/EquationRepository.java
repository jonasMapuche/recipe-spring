package br.com.stomach.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.stomach.entities.Equation;

public interface EquationRepository extends MongoRepository<Equation, Long> {

	List<Equation> findByInitial(String initial);
}
