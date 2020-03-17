package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.text.StyleConstants.ColorConstants;

@Entity
public class Product {

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	private String reference;
	
	@Column(name = "Category")
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

}
