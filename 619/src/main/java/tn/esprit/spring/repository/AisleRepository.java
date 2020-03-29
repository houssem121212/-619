package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Aisle;
import tn.esprit.spring.entities.Image;
import tn.esprit.spring.entities.Product;


@Repository
public interface AisleRepository extends JpaRepository<Aisle, Long>{

	@Query("select p from  Product p join Aisle a on p.aisle = a.id  where a.id = :id ")
	 public List<Product> getAisleProductById(@Param("id")Long id);
	
//	@Query("select i from  Image i join Aisle a on i.id = a.images  where i.id = :id ")
//	 public List<Image> getListImageOfProductAisle(@Param("id") long id);
	
	 
}
