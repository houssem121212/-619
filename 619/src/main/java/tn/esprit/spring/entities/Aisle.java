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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"products","user"})
public class Aisle implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne
	private Category category;
	
	private Integer position;
	
	private String type;
	
	@OneToMany
	private List<Image> images;
	
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

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
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

	public Aisle(Long id, Category category, Integer position, String type, List<Image> images, List<Product> products,
			User user) {
		super();
		this.id = id;
		this.category = category;
		this.position = position;
		this.type = type;
		this.images = images;
		this.products = products;
		this.user = user;
	}

	public Aisle(Category category, Integer position, String type, List<Image> images, List<Product> products,
			User user) {
		super();
		this.category = category;
		this.position = position;
		this.type = type;
		this.images = images;
		this.products = products;
		this.user = user;
	}

	public Aisle() {
		super();
	}

	@Override
	public String toString() {
		return "Aisle [id=" + id + ", category=" + category + ", position=" + position + ", type=" + type + ", images="
				+ images + ", products=" + products + ", user=" + user + "]";
	}

	
	
	

}
