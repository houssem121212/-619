package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Don;

public interface DonRepository extends JpaRepository <Don,Long> {

	 @Query
	 (value = "SELECT sum(montantdon) from Don", nativeQuery = true)
	    int countAllDonatedSacks();
	 
	 
	 @Query(value = "SELECT count(distinct `user_id`) from Don", nativeQuery = true)
	    int countAllBeneficiaries();
	 
	//@Query("SELECT count(*) FROM Employe")
    //public int countemp();
}
