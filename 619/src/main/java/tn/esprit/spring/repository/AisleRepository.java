package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Aisle;


@Repository
public interface AisleRepository extends JpaRepository<Aisle, Long>{

	
}
