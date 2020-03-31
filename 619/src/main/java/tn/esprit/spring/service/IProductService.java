package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Product;

public interface IProductService {

 public	long addProduct(Product p);
 public long updateProduct(Product p);
 public long deleteProduct(long id);
 public List<Product> getAllProduct();
 public List<Product> getProductbyX(String x,String value);
 public Product getProductById(long id);
 public List<Product> getProductByRef(String ref);
 public List<Product> searchProduct(String search);
 
 public int countSellByX(String x,String value);
 
 public void affecterProductToAisle(long aisleId, long productId);
 public void desaffecterProductToAisle(long aisleId, long productId);
 public void affecterProductToStock(long stockId, long productId);
 public void desaffecterProductToStock(long stockId, long productId);
 public void checkDateValiditer();
 
 //public List<Product> filterSearch(List<String> attribute,List<String> value );
 public List<Product> filterSearch(Product product);
 public long populateAisle(Long idAisle, List<Long> idProducts);
 
}
