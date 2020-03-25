package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
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
	
	@OneToOne
	private Category category;
	
	private String name;
	
	private float price;
	
	private String size;
	
	private String dimention;
		
	private float weight ;
	
	private String color;
	
	private float discount;
	
	private String picture;
	
	private String brand;
	
	private int quantiteCart;

	
	
	@ManyToMany
	private List<Command> commands;
	
	@ManyToMany(mappedBy="produits")
	private List<Cart> carts;
	
	@ManyToOne
	private Aisle aisle;
	
	@ManyToMany
	private List<User> users;
	
	@ManyToMany(mappedBy="products")
	private List<Stock> stocks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	
	public int getQuantiteCart() {
		return quantiteCart;
	}

	public void setQuantiteCart(int quantiteCart) {
		this.quantiteCart = quantiteCart;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDimention() {
		return dimention;
	}

	public void setDimention(String dimention) {
		this.dimention = dimention;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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

	

	public Product(Long id, String reference, Category category, String name, float price, String size,
			String dimention, float weight, String color, float discount, String picture, String brand,
			int quantiteCart, List<Command> commands, List<Cart> carts, Aisle aisle, List<User> users,
			List<Stock> stocks) {
		super();
		this.id = id;
		this.reference = reference;
		this.category = category;
		this.name = name;
		this.price = price;
		this.size = size;
		this.dimention = dimention;
		this.weight = weight;
		this.color = color;
		this.discount = discount;
		this.picture = picture;
		this.brand = brand;
		this.quantiteCart = quantiteCart;
		this.commands = commands;
		this.carts = carts;
		this.aisle = aisle;
		this.users = users;
		this.stocks = stocks;
	}

	public Product() {
		super();
	}

	public Product(String reference, Category category, String name, float price, String size, String dimention,
			float weight, String color, float discount, String picture, String brand, int quantiteCart,
			List<Command> commands, List<Cart> carts, Aisle aisle, List<User> users, List<Stock> stocks) {
		super();
		this.reference = reference;
		this.category = category;
		this.name = name;
		this.price = price;
		this.size = size;
		this.dimention = dimention;
		this.weight = weight;
		this.color = color;
		this.discount = discount;
		this.picture = picture;
		this.brand = brand;
		this.quantiteCart = quantiteCart;
		this.commands = commands;
		this.carts = carts;
		this.aisle = aisle;
		this.users = users;
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", reference=" + reference + ", category=" + category + ", name=" + name
				+ ", price=" + price + ", size=" + size + ", dimention=" + dimention + ", weight=" + weight + ", color="
				+ color + ", discount=" + discount + ", picture=" + picture + ", brand=" + brand + ", quantiteCart="
				+ quantiteCart + ", commands=" + commands + ", carts=" + carts + ", aisle=" + aisle + ", users=" + users
				+ ", stocks=" + stocks + "]";
	}
	
	
	
	
	
	
	

}
