package tn.esprit.spring.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Add {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "addCategorie")
	private CategorieAisle addCategorie;
	
	@Column(name = "addDescription")
	private CategorieAisle addDescription;
	
	@Column(name = "addFile")
	private CategorieAisle addFile;
	
	@Temporal(TemporalType.DATE)
	private Date addDate;
	
	@OneToOne
	private User usersAdd;
	
}
