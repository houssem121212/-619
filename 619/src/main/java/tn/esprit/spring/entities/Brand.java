package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"produits"})
public class Brand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private String name ;
	private String logo ;
	
	@OneToMany(mappedBy="brand"	)
	private List<Product> produits;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public List<Product> getProduits() {
		return produits;
	}
	public void setProduits(List<Product> produits) {
		this.produits = produits;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", logo=" + logo + ", produits=" + produits + "]";
	}
	
	public Brand(Long id, String name, String logo, List<Product> produits) {
		super();
		this.id = id;
		this.name = name;
		this.logo = logo;
		this.produits = produits;
	}
	public Brand(String name, String logo, List<Product> produits) {
		super();
		this.name = name;
		this.logo = logo;
		this.produits = produits;
	}
	public Brand() {
		super();
	}
	
}
