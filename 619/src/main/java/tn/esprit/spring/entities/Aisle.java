package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Aisle implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne
	private Category category;
	
	private int position;
	
	@OneToMany(mappedBy="aisle")
	private List<Product> products;
	
	@OneToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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

	public Aisle(Long id, Category category, int position, List<Product> products, User user) {
		super();
		this.id = id;
		this.category = category;
		this.position = position;
		this.products = products;
		this.user = user;
	}

	public Aisle(Category category, int position, List<Product> products, User user) {
		super();
		this.category = category;
		this.position = position;
		this.products = products;
		this.user = user;
	}

	public Aisle() {
		super();
	}

	@Override
	public String toString() {
		return "Aisle [id=" + id + ", category=" + category + ", position=" + position + ", products=" + products
				+ ", user=" + user + "]";
	}
	
	

}
