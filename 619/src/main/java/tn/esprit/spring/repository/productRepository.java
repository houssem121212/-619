package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Cart;
import tn.esprit.spring.entities.Product;

@Repository
public interface productRepository extends CrudRepository<Product, Long> {

	@Query("Select p.name , p.discount,p.price from Product p join p.carts dps where dps.id=:cartId")
	public List<String> getAllProductByCart(@Param("cartId") Long cartId);

}
