package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Image implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	private Product produit;
	
	private String image;

	@Override
	public String toString() {
		return "Image [id=" + id + ", produit=" + produit + ", image=" + image + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduit() {
		return produit;
	}

	public void setProduit(Product produit) {
		this.produit = produit;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Image(Long id, Product produit, String image) {
		super();
		this.id = id;
		this.produit = produit;
		this.image = image;
	}

	public Image(Product produit, String image) {
		super();
		this.produit = produit;
		this.image = image;
	}

	public Image() {
		super();
	}
	
}
