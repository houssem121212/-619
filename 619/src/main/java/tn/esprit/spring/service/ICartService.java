package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Cart;

public interface ICartService {

	public String addToCart(Long produitId, Long cartId);
	public String DeleteProductFromCart(Long produitId, Long cartId);
	public String removeCart(Long id);
	public String updateQuantiteCart(Long cartID, Long produitId, int quantiteProduct);
	public List<String> getAllProductByCart(Long cartId);
	public Cart getCartById(Long cartId);
	
	
	
}
