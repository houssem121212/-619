package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private float total;

	private int quantite;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Product> produits;

	
	@OneToOne(mappedBy = "cart")
	private User user;

	public Long getId() {
		return id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
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

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Cart(Long id, float total, int quantite, List<Product> produits, User user) {
		super();
		this.id = id;
		this.total = total;
		this.quantite = quantite;
		this.produits = produits;
		this.user = user;
	}

	public Cart(float total, int quantite, List<Product> produits, User user) {
		super();
		this.total = total;
		this.quantite = quantite;
		this.produits = produits;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", total=" + total + ", quantite=" + quantite + ", produits=" + produits + ", user="
				+ user + "]";
	}

	public Cart() {
		super();
	}

}