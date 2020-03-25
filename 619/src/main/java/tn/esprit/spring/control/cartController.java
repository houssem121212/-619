package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Cart;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.service.CartService;

@RestController
@RequestMapping("/cart")
public class cartController {

	@Autowired
	CartService cartService;
	
	
	//Add to cart
	// http://localhost:8081/SpringMVC/servlet/cart/addtoCart/1/1
    @PutMapping("/addtoCart/{produitId}/{cartId}")
    @PreAuthorize("hasRole('USER')")
    public String addtoCart(@PathVariable("produitId") Long produitId,@PathVariable("cartId")Long cartId) {
		return cartService.addToCart(produitId, cartId);
  
    }
    

    // delete Cart
    // http://localhost:8081/SpringMVC/servlet/1/1/1
    @PutMapping("/DeleteCart/{produitId}/{cartId}")
    @PreAuthorize("hasRole('USER')")
    public String DeleteCart(@PathVariable("cartId") Long cartId) {
		return cartService.removeCart( cartId);
    }
    
    
    
    
//na9sa mazelt    
    @PutMapping("/updateQuantite/{cartId}/{productId}/{quantiteProduct}")
    @PreAuthorize("hasRole('USER')")
    public String DeleteCart(@PathVariable("cartId") Long cartId,@PathVariable("productId") Long productId,@PathVariable("quantiteProduct") int quantite) {
		return cartService.updateQuantiteCart(cartId, productId, quantite);
  
    }
	
 
 // get all product in the cart
 //http://localhost:8081/SpringMVC/servlet/cart/getAllProductByCart/{idCart}
    @GetMapping(value = "getAllProductByCart/{idCart}")
    @ResponseBody
	public List<String> getAllProductByCart(@PathVariable("idCart") Long idCart) {
    	
		return cartService.getAllProductByCart(idCart);
	}
    
    
 // delete from cart   
 // http://localhost:8081/SpringMVC/servlet/cart/deleteEmployeById/1/1
    @DeleteMapping("/deleteEmployeById/{cartId}/{productId}") 
	@ResponseBody 
	@PreAuthorize("hasRole('USER')")
	public String DeleteProductFromCart(@PathVariable("cartId") Long cartId,@PathVariable("productId") Long productId) {
		return cartService.DeleteProductFromCart(productId, cartId);
		
	}
    
}
