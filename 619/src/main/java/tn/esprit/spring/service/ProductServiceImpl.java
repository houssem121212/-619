package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Aisle;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repository.AisleRepository;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.StockRepository;

@Service
@EnableScheduling
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	AisleRepository aisleRepository;
	@Autowired
	StockRepository stockRepository;

	@Override
	public long addProduct(Product p) {
		productRepository.save(p);
		return p.getId();
	}

	@Override
	public long updateProduct(Product p) {
		if (productRepository.findById(p.getId()).get() != null) {
			productRepository.save(p);
			return p.getId();
		}
		return 0;
	}

	@Override
	public long deleteProduct(long id) {
		Product p = productRepository.findById(id).get();
		productRepository.delete(p);
		return id;
	}

	@Override
	public List<Product> getAllProduct() {

		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductbyX(String x, String value) {
		return x.equals("color") ? productRepository.findByColor(value)
				: x.equals("brand") ? productRepository.getByBrand(value)
						: x.equals("category") ? productRepository.getByCategory(value)
								: x.equals("categoryAndBrand")
										? productRepository
												.getByCategoryAndBrand(value.substring(0, value.indexOf(";")),
														value.substring(value.indexOf(";") + 1, value.length()))
										: x.equals("size") ? productRepository.getBySize(value)
												: x.equals("reference") ? productRepository.findByReference(value)
														: x.equals("name") ? productRepository.findByName(value) : null;
	}
	
	@Override
	public int countSellByX(String x, String value) {
		
		return x.equals("color") ? productRepository.countSellByColor(value)
				: x.equals("brand") ? productRepository.countSellByBrand(Long.parseLong(value))
						: x.equals("category") ? productRepository.countSellByCategory(Long.parseLong(value))
								: x.equals("categoryAndBrand")
										? productRepository
												.countSellByCategoryAndBrand(Long.parseLong( value.substring(0, value.indexOf(";"))),
														Long.parseLong(value.substring(value.indexOf(";") + 1, value.length())))
												: x.equals("sizeAndColor")
												? productRepository
														.countSellBySizeAndColor( value.substring(0, value.indexOf("%")),
																value.substring(value.indexOf(";") + 1, value.length()))
														: x.equals("referenceAndColor")
														? productRepository
																.countSellByReferenceAndColor( value.substring(0, value.indexOf(";")),
																		value.substring(value.indexOf(";") + 1, value.length()))
										: x.equals("size") ? productRepository.countSellBySize(value)
												: x.equals("reference") ? productRepository.countSellByReference(value)
														: x.equals("name") ? productRepository.countSellByName(value) : 0;
	}

	@Override
	public Product getProductById(long id) {
		

		return productRepository.findById(id).get();
	}
	
	

	@Override
	public List<Product> searchProduct(String search) {

		return productRepository.search(search);
	}

	@Override
	public List<Product> getProductByRef(String ref) {

		return productRepository.findByReference(ref);
	}

	@Transactional
	public void affecterProductToAisle(long aisleId, long productId) {
		Aisle aisle = aisleRepository.findById(aisleId).get();
		Product product = productRepository.findById(productId).get();

		if (aisle.getProducts() == null) {

			List<Product> products = new ArrayList<>();
			products.add(product);
			aisle.setProducts(products);
			aisleRepository.save(aisle);
		} else {

			aisle.getProducts().add(product);
			aisleRepository.save(aisle);

		}

	}

	@Transactional
	public void desaffecterProductToAisle(long aisleId, long productId) {
		Aisle aisle = aisleRepository.findById(aisleId).get();
		for (int i = 0; i < aisle.getProducts().size(); i++) {
			if (aisle.getProducts().get(i).getId() == productId) {
				aisle.getProducts().remove(i);
				aisleRepository.save(aisle);
				break;
			}
		}
	}

	@Transactional
	public void affecterProductToStock(long stockId, long productId) {
		Stock stock = stockRepository.findById(stockId).get();
		Product product = productRepository.findById(productId).get();

		if (stock.getProducts() == null) {

			List<Product> products = new ArrayList<>();
			products.add(product);
			stock.setProducts(products);
			stockRepository.save(stock);
		} else {

			stock.getProducts().add(product);
			stockRepository.save(stock);

		}

	}

	@Transactional
	public void desaffecterProductToStock(long stockId, long productId) {
		Stock stock = stockRepository.findById(stockId).get();
		for (int i = 0; i < stock.getProducts().size(); i++) {
			if (stock.getProducts().get(i).getId() == productId) {
				stock.getProducts().remove(i);
				stockRepository.save(stock);
				break;
			}
		}
	}

	// @Scheduled( cron = "0 0 * * * *")
	@Scheduled(fixedDelay = 1000000)
	public void checkDateValiditer() {
		List<Product> products = productRepository.getExpiredProduct();
		for (int i = 0; i < products.size(); i++) {
			deleteProduct(products.get(i).getId());
		}
	}

	@Override
	public long populateAisle(Long idAisle, List<Long> idProducts) {
		for (int i = 0; i < idProducts.size(); i++) {
			affecterProductToAisle(idAisle, idProducts.get(i));
		}
		return 0;
	}

	@Override
	// public List<Product> filterSearch(List<String> attribute,List<String>
	// value) {
	//
	//
	// String ch=" `"+attribute.get(0)+"` = " +"\""+ value.get(0)+"\""+" ";
	// for(int i=1;i<attribute.size();i++){
	//
	// ch=""+attribute.get(i)!=null ? ch+ " And `"+attribute.get(i)+"` = "
	// +"\""+value.get(i)+"\"" +" ": ch ;
	// }
	// System.out.println(ch);
	// // List<Product> p= productRepository.findAll(Example.of());
	//
	//// System.out.println(p.size());
	//// System.out.println(p);
	// return null;
	// }

	public List<Product> filterSearch(Product product) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
		return (List<Product>) productRepository.findAll(Example.of(product, matcher));

	}

	
}
