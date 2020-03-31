package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Cart;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repository.CartRepository;
import tn.esprit.spring.repository.ProductRepository;

@Service
public class CartService implements ICartService {

	@Autowired
	CartRepository cartRepeository;

	@Autowired
	ProductRepository productRepository;

	@Transactional
	public String addToCart(Long produitId, Long cartId) {

		// TODO Auto-generated method stub
		Cart cartManagedEntity = cartRepeository.findById(cartId).get();
		Product produitManagedEntity = productRepository.findById(produitId).get();

		// prix de la carte

		float prixtotal = cartManagedEntity.getTotal() + produitManagedEntity.getPrice();
		cartManagedEntity.setTotal(prixtotal);

		if (cartManagedEntity.getProduits() == null) {
			List<Product> prodcts = new ArrayList<>();
			prodcts.add(produitManagedEntity);
			cartManagedEntity.setProduits(prodcts);
		} else {

			cartManagedEntity.getProduits().add(produitManagedEntity);

		}
		// recherche produit dans la carte s'il existe

		cartRepeository.save(cartManagedEntity);
		return "product is added ";

	}

	// Delete product from Cart

	@Transactional
	public String DeleteProductFromCart(Long produitId, Long cartId) {

		String x;

		// TODO Auto-generated method stub
		Cart cartManagedEntity = cartRepeository.findById(cartId).get();
		Product produitManagedEntity = productRepository.findById(produitId).get();

		// recherche product dans le cart
		
		int employeNb = cartManagedEntity.getProduits().size();
		for (int index = 0; index < employeNb; index++) {
			if (cartManagedEntity.getProduits().get(index).getId() == produitId) {
				cartManagedEntity.getProduits().remove(produitManagedEntity);
				break;
			}
		}
		cartRepeository.save(cartManagedEntity);
		return "succes";

	}

	// suprimer le panier

	public String removeCart(Long id) {
		cartRepeository.deleteById(id);

		return "cart : deleted avec succes ";
	}

	// update quantite cart

	public String updateQuantiteCart(Long cartID, Long produitId, int quantiteProduct) {
		Cart dep = cartRepeository.findById(cartID).get();

		int employeNb = dep.getProduits().size();
		for (int index = 0; index < employeNb; index++) {
			if (dep.getProduits().get(index).getId() == produitId) {
				break;
			}
		}

		cartRepeository.save(dep);
		return "update quantite";
	}

	// affichage les produit dans un cart

	public List<Product> getAllProductByCart(Long cartId) {
		Cart dep = cartRepeository.findById(cartId).get();
		
		return dep.getProduits();
	}

	public Cart getCartById(Long cartId) {
		return cartRepeository.findById(cartId).get();
	}

}
