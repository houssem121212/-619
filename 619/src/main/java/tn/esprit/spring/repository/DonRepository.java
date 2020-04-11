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
	 
	 
	// nombre de participants dans un jackpot 
	 @Query(value = "SELECT count(user_id) from Don   Group By jackpot_id ", nativeQuery = true)
	 	 
	    int countParticipantByJackpot(@Param("idDon") Long idDon);
	 
	 
	 
	 
	 @Query(value = "SELECT count(montantdon`) from Don Order By  user_id ", nativeQuery = true)
 	 
	    int countByUserID();	
	 @Query(value = "SELECT SUM(montantdon) from Don where jackpot_id=3  ", nativeQuery = true)
	 
	 float countDonByjackpot(@Param("idDon") Long idDon,@Param("jackpotId") Long jackpotId );
	 
//	 @Query(value = "select  do.category_name from category ca "
//				+ " inner join product p on p.category_id = ca.id  "
//				+ " inner join  product_commands on p.id = product_commands.produits_id "
//				+ "inner join command c on c.id = product_commands.commands_id"
//				+ " inner join   users u on u.id = c.user_id where datediff(  CURDATE(),u.datenaissance)/365  BETWEEN :age-2 AND :age+2  AND c.command_date BETWEEN :d AND :d1 ", nativeQuery = true)
//		public List<String> countySize(@Param("age") int age ,@Param("d") Date d,@Param("d1") Date d1 );
	 
	 
	//@Query("SELECT count(*) FROM Employe")
    //public int countemp();
	 
	 
	 
	 // hna 7ajetna njibou les produit X mta3 don y elli type mta3ha produit 
	 // les donner 3anna id mta3 don 
	 
	// @Query(value="select p.* from Don d join Command co on co.don_id=d.id join command_produits c on c.commands_id = co.id join Product p  on p.id = c.produits_id where  d.id =:idDon", nativeQuery = true)
	 
	 @Query(value="select p.*  from Don  d join Command co on co.don_id=d.id join command_produits c on c.commands_id = co.id join Product p  on p.id = c.produits_id where  d.id =:idDon", nativeQuery = true)
	 public List<Product> getDonProduct(@Param("idDon") Long idDon);
	 
	 @Query(value="select p.* from Don d join Command co on co.don_id=d.id join command_produits c on c.commands_id = co.id join Product p  on p.id = c.produits_id where  d.id =1", nativeQuery = true)
	 public List<String> getProduct();
	 
	 
}
