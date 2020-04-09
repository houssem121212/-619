package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Size;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>  {

	
	////// baddel brand  !!!!!!!!
	
	
	
	 List<Product> findByName(String name);
	 
	 List<Product> findByColor(String color);
	 
	 List<Product> findByReference(String ref);
	 
	 List<Product> findBySize(Size size);
	 
	 @Query(value="select * from Product p join Brand b  join Category ca  where ca.name =:value or  b.name =:value or p.name =:value ", nativeQuery = true)
	 public List<Product> search(@Param("value")String value);
	 
	 @Query(value="select count(*) from Product p join  Command c  join Category ca  join Brand b where ca.id =:category  and p.brand =:brand ", nativeQuery = true)
	 public int countSellByCategoryAndBrand(@Param("category") Long  category,@Param("brand") Long brand);	 
 //---
	 @Query(value="select count(*) from Product p join Command c  where  p.name =:value", nativeQuery = true)
	 public int countSellByName(@Param("value") String value);
	 
	 @Query(value="select count(*) from Product p join Command c where  p.color =:value ", nativeQuery = true)
	 public int countSellByColor(@Param("value") String value);
	 
	 @Query(value="select count(*) from Product p join Command c  where p.size =:value", nativeQuery = true)
	 public int countSellBySize(@Param("value") String value);
	 
	 @Query(value="select count(*) from Product p join Command c   where p.size =:size and p.color =:color", nativeQuery = true)
	 public int countSellBySizeAndColor(@Param("size") String size,@Param("color") String color);
	 
	 @Query(value="select count(*) from Product p join Command c   where  p.reference =:ref and p.color =:value", nativeQuery = true)
	 public int countSellByReferenceAndColor(@Param("ref") String ref,@Param("value") String value);
	 
	 @Query(value="select count(*) from Product p join Command c  where   p.reference =:value", nativeQuery = true)
	 public int countSellByReference(@Param("value") String value);
	 	 
 //---
	 @Query(value="select count(*) from Product p join  Command c  join Category ca   where  ca.id =:category  ", nativeQuery = true)
	 public int countSellByCategory(@Param("category") Long category);
	 
	 @Query(value="select count(*) from Product p join  Command c   join Brand b  where  p.brand =:brand ", nativeQuery = true)
	 public int countSellByBrand(@Param("brand") Long brand);
	 
	 
	 
//	 @Query("select p from Product p where p.discount>0")
//	 public List<Product> productWithDiscount();	 	 
//	 
//	 @Query("select p from Product p where p.discount>:discount")
//	 public List<Product> productWithMoreDiscount();
	 

	 @Query(value="select * from Product p join where category c where p.category =:category  and p.brand =:brand ", nativeQuery = true)
	 public List<Product> getByCategoryAndBrand(@Param("category")String category,@Param("brand")String brand);	 
	 
	 @Query(value="select * from Product p where p.size=?", nativeQuery = true)
	 public List<Product> getBySize(String size);
	 	 
	 
	 @Query("select p from Product p where p.category=:category")
	 public List<Product> getByCategory(@Param("category")String category);
	 
	 @Query(value="select p from Product p where p.brand=:brand", nativeQuery = true)
	 public List<Product> getByBrand(@Param("brand")String brand);
	 
	 @Query("select p from Product p where p.discount>0")
	 public List<Product> productWithDiscount();	 	 
	 
	 @Query("select p from Product p where p.discount>:discount")
	 public List<Product> productWithMoreDiscount();
	 	 
	 @Query(value="select * from Product  where expiration_date < CURRENT_TIMESTAMP - ? ", nativeQuery = true)
	 public List<Product> getRedZonProduct(int nbrday);
	 
	 @Query(value="select * from Product  where expiration_date = CURRENT_TIMESTAMP ", nativeQuery = true)
	 public List<Product> getExpiredProduct();
	 
	 @Query(value="select * from Product  where ? ", nativeQuery = true)
	 public List<Product> filter(String filter);
	 
	// @Query(value="select p.* from Don d join Command co on co.don_id=d.id join command_produits c on c.commands_id = co.id join Product p  on p.id = c.produits_id where  d.id =:idDon", nativeQuery = true)
	 @Query(value="select p.*  from Product p join Command_produits cp on cp.produits_id=p.id join command c on c.id = cp.commands_id join Don d on d.id =c.don_id  where  d.id =:idDon", nativeQuery = true)
	 public List<Product> getDonProduct(@Param("idDon") Long idDon);
	 
//	 @Modifying
//	 @Transactional
//	 @Query("UPDATE `product` SET `brand`=:brand,`color`=:color,`dimention`=:dimention,"
//	 		+ "`discount`=[value-5],`name`=[value-6],`price`=[value-7],`reference`=[value-8],`size`=[value-9],"
//	 		+ "`weight`=[value-10],`aisle_id`=[value-11],`category_id`=[value-12] WHERE")
	  
}

