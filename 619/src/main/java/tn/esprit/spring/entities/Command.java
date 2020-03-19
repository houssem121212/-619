package tn.esprit.spring.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
public class Command {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "commandType")
	private TypeCommand commandType;
	
	@Temporal(TemporalType.DATE)
	private Date commandDate;
	
	@Column(name = "commandAdresse")
	private String commandAdresse;

	
	@Column(name = "commandEtat")
	private Boolean commandEtat;
	
	@NotNull
	@ManyToMany
	private List<Product> produitCommands;
	
	@OneToOne(mappedBy="commands")
	private Facture facture;
	
	@ManyToOne
	private User userCommand;

	@ManyToOne
	private Delivery DelveyCommand;
	
	
}
