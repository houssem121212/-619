package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Don;
import tn.esprit.spring.entities.Product;

public interface DonRepository extends JpaRepository <Don,Long> {

	 @Query
	 (value = "SELECT sum(montantdon) from Don", nativeQuery = true)
	    int countAllDonatedSacks();
	 
	 
	 @Query(value = "SELECT count(distinct `user_id`) from Don", nativeQuery = true)
	 	 
	    int countAllBeneficiaries();
	 
	 @Query(value = "SELECT count(montantdon`) from Don Order By  user_Id ", nativeQuery = true)
 	 
	    int countByUserID();	
	 
//	 @Query(value = "select  do.category_name from category ca "
//				+ " inner join product p on p.category_id = ca.id  "
//				+ " inner join  product_commands on p.id = product_commands.produits_id "
//				+ "inner join command c on c.id = product_commands.commands_id"
//				+ " inner join   users u on u.id = c.user_id where datediff(  CURDATE(),u.datenaissance)/365  BETWEEN :age-2 AND :age+2  AND c.command_date BETWEEN :d AND :d1 ", nativeQuery = true)
//		public List<String> countySize(@Param("age") int age ,@Param("d") Date d,@Param("d1") Date d1 );
	 
	 
	//@Query("SELECT count(*) FROM Employe")
    //public int countemp();
}
