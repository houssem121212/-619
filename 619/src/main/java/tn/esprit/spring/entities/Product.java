package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "commands", "carts", "aisle", "users", "stocks", "brand" ,"picture"})
public class Product implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String reference;

	private String name;

	private Float price;

	@Enumerated(EnumType.STRING)
	private Size size;

	private String dimention;

	private Float weight;

	private String color;

	private Float discount;

	private Integer quantity;

	private Date fabricationDate;

	private Date expirationDate;

	private Float tva;

	@OneToMany(mappedBy = "produit")
	private List<Image> picture;

	@ManyToOne
	private Brand brand;

	@OneToOne
	private Category category;

	@ManyToMany(mappedBy = "produits", fetch = FetchType.LAZY)
	private List<Command> commands;

	@ManyToMany(mappedBy = "produits", fetch = FetchType.LAZY)
	private List<Cart> carts;

	
	@ManyToOne
	private Aisle aisle;

	@ManyToMany(mappedBy = "products")
	private List<Stock> stocks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getDimention() {
		return dimention;
	}

	public void setDimention(String dimention) {
		this.dimention = dimention;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getFabricationDate() {
		return fabricationDate;
	}

	public void setFabricationDate(Date fabricationDate) {
		this.fabricationDate = fabricationDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Float getTva() {
		return tva;
	}

	public void setTva(Float tva) {
		this.tva = tva;
	}

	public List<Image> getPicture() {
		return picture;
	}

	public void setPicture(List<Image> picture) {
		this.picture = picture;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Aisle getAisle() {
		return aisle;
	}

	public void setAisle(Aisle aisle) {
		this.aisle = aisle;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Product(Long id,String color,String dimention,Float discount,Date expirationDate,Date fabricationDate,String name,
			Float price,Integer quantity,String reference,Size size,Float tva,Float weight,Aisle aisle,Brand brand,Category category	){
		super();
		this.id = id;
		this.reference = reference;
		this.name = name;
		this.price = price;
		this.size = size;
		this.dimention = dimention;
		this.weight = weight;
		this.color = color;
		this.discount = discount;
		this.quantity = quantity;
		this.fabricationDate = fabricationDate;
		this.expirationDate = expirationDate;
		this.tva = tva;
		
		this.brand = brand;
		this.category = category;

		this.aisle = aisle;
	}
	
	public Product(Long id, String reference, String name, Float price, Size size, String dimention, Float weight,
			String color, Float discount, Integer quantity, Date fabricationDate, Date expirationDate, Float tva,
			List<Image> picture, Brand brand, Category category, List<Command> commands, List<Cart> carts, Aisle aisle,
			List<Stock> stocks) {
		super();
		this.id = id;
		this.reference = reference;
		this.name = name;
		this.price = price;
		this.size = size;
		this.dimention = dimention;
		this.weight = weight;
		this.color = color;
		this.discount = discount;
		this.quantity = quantity;
		this.fabricationDate = fabricationDate;
		this.expirationDate = expirationDate;
		this.tva = tva;
		this.picture = picture;
		this.brand = brand;
		this.category = category;
		this.commands = commands;
		this.carts = carts;
		this.aisle = aisle;
		this.stocks = stocks;
	}

	public Product(String reference, String name, Float price, Size size, String dimention, Float weight, String color,
			Float discount, Integer quantity, Date fabricationDate, Date expirationDate, Float tva, List<Image> picture,
			Brand brand, Category category, List<Command> commands, List<Cart> carts, Aisle aisle, List<Stock> stocks) {
		super();
		this.reference = reference;
		this.name = name;
		this.price = price;
		this.size = size;
		this.dimention = dimention;
		this.weight = weight;
		this.color = color;
		this.discount = discount;
		this.quantity = quantity;
		this.fabricationDate = fabricationDate;
		this.expirationDate = expirationDate;
		this.tva = tva;
		this.picture = picture;
		this.brand = brand;
		this.category = category;
		this.commands = commands;
		this.carts = carts;
		this.aisle = aisle;
		this.stocks = stocks;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", reference=" + reference + ", name=" + name + ", price=" + price + ", dimention="
				+ dimention + ", weight=" + weight + ", color=" + color + ", discount=" + discount + ", quantity="
				+ quantity + ", fabricationDate=" + fabricationDate + ", expirationDate=" + expirationDate + "]";
	}

	



	
	

	

}
