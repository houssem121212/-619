package tn.esprit.spring.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Aisle {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "aisleCategorie")
	private CategorieAisle aisleCategorie;
	
	private int position;
	
	@OneToMany(mappedBy="aislesProduct")
	private List<Product> products;
	
	@OneToOne(mappedBy="aisles")
	private User userAisle;

}
