package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Command;



@Repository
public interface CommandRepository extends CrudRepository<Command, Long>{

}
