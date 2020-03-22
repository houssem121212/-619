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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private Long capacite;
	
	private String categorie;
	
	@OneToOne
	private Adresse adress;

	

	@OneToMany(mappedBy="stocks",cascade = CascadeType.ALL)
	private List<User> users;

	@ManyToMany
	private List<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCapacite() {
		return capacite;
	}

	public void setCapacite(Long capacite) {
		this.capacite = capacite;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Adresse getAdress() {
		return adress;
	}

	public void setAdress(Adresse adress) {
		this.adress = adress;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", capacite=" + capacite + ", categorie=" + categorie + ", adress=" + adress
				+ ", users=" + users + ", products=" + products + "]";
	}

	public Stock() {
		super();
	}

	public Stock(Long capacite, String categorie, Adresse adress, List<User> users, List<Product> products) {
		super();
		this.capacite = capacite;
		this.categorie = categorie;
		this.adress = adress;
		this.users = users;
		this.products = products;
	}

	public Stock(Long id, Long capacite, String categorie, Adresse adress, List<User> users, List<Product> products) {
		super();
		this.id = id;
		this.capacite = capacite;
		this.categorie = categorie;
		this.adress = adress;
		this.users = users;
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
