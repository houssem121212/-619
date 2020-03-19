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
	private Long id;

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

	
	@NotNull
	@ManyToMany(mappedBy="produitCommands")
	private List<Command> commands;
	
	@ManyToMany(mappedBy="produitCart")
	private List<Cart> carts;
	
	@ManyToOne
	private Aisle aislesProduct;

}
