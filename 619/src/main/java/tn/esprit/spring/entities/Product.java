package tn.esprit.spring.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.swing.text.StyleConstants.ColorConstants;

import com.sun.istack.NotNull;

@Entity
public class Product {

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	private String reference;
	
	
	private Category category;
	
	private String productName;
	
	private float price;
	
	private Size size;
	
	private String dimention;
		
	private float weight ;
	
	private ColorConstants color;
	
	private float discountAvailable;
	
	private String picture;
	
	private Brand brand;

	
	//@NotNull
	@ManyToMany(mappedBy="produitCommands")
	private List<Command> commands;
	
	@ManyToMany(mappedBy="produitCart")
	private List<Cart> carts;
	
	@ManyToOne
	private Aisle aislesProduct;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
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

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public ColorConstants getColor() {
		return color;
	}

	public void setColor(ColorConstants color) {
		this.color = color;
	}

	public float getDiscountAvailable() {
		return discountAvailable;
	}

	public void setDiscountAvailable(float discountAvailable) {
		this.discountAvailable = discountAvailable;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
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

	public Aisle getAislesProduct() {
		return aislesProduct;
	}

	public void setAislesProduct(Aisle aislesProduct) {
		this.aislesProduct = aislesProduct;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Product(long id, String reference, Category category, String productName, float price, Size size,
			String dimention, float weight, ColorConstants color, float discountAvailable, String picture, Brand brand,
			List<Command> commands, List<Cart> carts, Aisle aislesProduct) {
		super();
		this.id = id;
		this.reference = reference;
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.size = size;
		this.dimention = dimention;
		this.weight = weight;
		this.color = color;
		this.discountAvailable = discountAvailable;
		this.picture = picture;
		this.brand = brand;
		this.commands = commands;
		this.carts = carts;
		this.aislesProduct = aislesProduct;
	}

	public Product(String reference, Category category, String productName, float price, Size size, String dimention,
			float weight, ColorConstants color, float discountAvailable, String picture, Brand brand,
			List<Command> commands, List<Cart> carts, Aisle aislesProduct) {
		super();
		this.reference = reference;
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.size = size;
		this.dimention = dimention;
		this.weight = weight;
		this.color = color;
		this.discountAvailable = discountAvailable;
		this.picture = picture;
		this.brand = brand;
		this.commands = commands;
		this.carts = carts;
		this.aislesProduct = aislesProduct;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", reference=" + reference + ", category=" + category + ", productName="
				+ productName + ", price=" + price + ", size=" + size + ", dimention=" + dimention + ", weight="
				+ weight + ", color=" + color + ", discountAvailable=" + discountAvailable + ", picture=" + picture
				+ ", brand=" + brand + ", commands=" + commands + ", carts=" + carts + ", aislesProduct="
				+ aislesProduct + "]";
	}
	

}
