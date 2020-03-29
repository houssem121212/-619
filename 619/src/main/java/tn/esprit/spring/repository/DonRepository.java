package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Don;

public interface DonRepository extends JpaRepository <Don,Long> {

	
	//@Query("SELECT count(*) FROM Employe")
    //public int countemp();
}
