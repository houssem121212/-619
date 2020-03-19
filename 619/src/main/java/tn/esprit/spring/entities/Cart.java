package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Cart")
	private Long id;
	
	
	@ManyToMany
	private List<Product> produits;
	
	@OneToOne(mappedBy="cart")
	private User user;

	@Override
	public String toString() {
		return "Cart [id=" + id + ", produits=" + produits + ", user=" + user + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Product> getProduits() {
		return produits;
	}

	public void setProduits(List<Product> produits) {
		this.produits = produits;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cart(Long id, List<Product> produits, User user) {
		super();
		this.id = id;
		this.produits = produits;
		this.user = user;
	}

	public Cart(List<Product> produits, User user) {
		super();
		this.produits = produits;
		this.user = user;
	}

	public Cart() {
		super();
	}
	
	
	

}