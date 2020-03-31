package tn.esprit.spring.control;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductControllerImpl implements IProductController {

	@Autowired
	IProductService productService;

	@PostMapping("/addProduct")
	@ResponseBody
	public Product addProduct(@RequestBody Product product) {
		System.out.println(product.getCategory());
		productService.addProduct(product);
		return product;
	}
	
	@PutMapping("/updateProduct")
	@ResponseBody
	public Product updateProduct(@RequestBody Product product) {
		System.out.println(product.getCategory());
		productService.updateProduct(product);
		return product;
	}


	@GetMapping("/getProductBy/{X}/{value}")
	public List<Product> getProductByX(@PathVariable("X") String x,@PathVariable("value") String value) {
		return productService.getProductbyX(x, value);
	}
	
	@GetMapping("/countSellByX/{X}/{value}")
	public int countSellByX(@PathVariable("X") String x,@PathVariable("value") String value) {
		return productService.countSellByX(x, value);
	}
	
	

	@GetMapping("/search/{search}")
	public List<Product> search(@PathVariable("search") String search) {
		return productService.searchProduct(search);
	}
	
	
	@GetMapping("/search/filter")
	@ResponseBody
	public List<Product> searchB(@RequestBody Product p){
		return productService.filterSearch(p);
	}
//	public List<Product> searchByFilter(@RequestBody Map<String,String> searchMap) {
//		List<String> attribute= new ArrayList<String>() ;
//		List<String> value = new ArrayList<String>() ;
//		searchMap.forEach((k,v)->{attribute.add(k);value.add(v);});
//		System.out.println("ffffff");
//		System.out.println(attribute.toString());
//		System.out.println(value.toString());
//		return productService.filterSearch(attribute, value);
//	}

	@DeleteMapping("/deleteProduct/{id}")
	public String search(@PathVariable("id") long id) {
		productService.deleteProduct(id);
		return "product deleted successfuly";
	}

}
