package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Don;

public interface DonRepository extends CrudRepository <Don,Integer> {

	
	//@Query("SELECT count(*) FROM Employe")
    //public int countemp();
}
