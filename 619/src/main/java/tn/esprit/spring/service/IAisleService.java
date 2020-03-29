package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Aisle;
import tn.esprit.spring.entities.Image;
import tn.esprit.spring.entities.Product;

public interface IAisleService {

	public long addAisle(Aisle aisle);

	public long deleteAisle(Long aisleId);

	public long updateAisle(Aisle aisle);

	public long addCategoryToAisle(long aisleId,  Long categoryId);

	public long deleteCategoryFromAisle(long aisleId, Long categoryId);

	public List<Product> getAisleProduct(long id);

	public List<Product> getAisleX(String x, String value);

	public void affecterCheafAisleToAisle(long aisleId, long productId);

	public void desaffecterCheafAisleToAisle(long aisleId, long userId);

	public List<Aisle> getAllAisle();

	public Aisle getAislebyId(long id);
	
	public Aisle addImageToAisle(long aisleId, long productId);
	
	public Aisle deleteImageOfAisle(long aisleId, long productId);
	
	public List<Image> getListImageOfProductAisle(long aisleId);
	
	public float profitabilityOfAisle(long aisleId);
	
	

}
