package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;


@Entity
@JsonIgnoreProperties({"produits","don","aisle","user","facture","delvey"})
public class Command implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "numeroCommand")
	private int numeroCommand;

	@Column
	private String commandType;
	
	@Column
	private String typeDelivery;

	@Column
	private float prix;
	
	@Column
	private LocalDate commandDate;

	@Column(name = "commandAdresse")
	private String commandAdresse;

	@Column(name = "commandEtat")
	private Boolean commandEtat;


	@ManyToMany
	private List<Product> produits;

	
	@OneToOne
	private Facture facture;

	
	@JsonIgnore
	@ManyToOne
	private User user;

	
	@ManyToOne
	private Delivery delvey;
	
	
	@ManyToOne
	private Don don;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNumeroCommand() {
		return numeroCommand;
	}


	public void setNumeroCommand(int numeroCommand) {
		this.numeroCommand = numeroCommand;
	}


	public String getCommandType() {
		return commandType;
	}


	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}

	

	public String getTypeDelivery() {
		return typeDelivery;
	}


	public void setTypeDelivery(String typeDelivery) {
		this.typeDelivery = typeDelivery;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public LocalDate getCommandDate() {
		return commandDate;
	}


	public void setCommandDate(LocalDate commandDate) {
		this.commandDate = commandDate;
	}


	public String getCommandAdresse() {
		return commandAdresse;
	}


	public void setCommandAdresse(String commandAdresse) {
		this.commandAdresse = commandAdresse;
	}


	public Boolean getCommandEtat() {
		return commandEtat;
	}


	public void setCommandEtat(Boolean commandEtat) {
		this.commandEtat = commandEtat;
	}


	public List<Product> getProduits() {
		return produits;
	}


	public void setProduits(List<Product> produits) {
		this.produits = produits;
	}


	public Facture getFacture() {
		return facture;
	}


	public void setFacture(Facture facture) {
		this.facture = facture;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Delivery getDelvey() {
		return delvey;
	}


	public void setDelvey(Delivery delvey) {
		this.delvey = delvey;
	}


	public Don getDon() {
		return don;
	}


	public void setDon(Don don) {
		this.don = don;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Command(int numeroCommand, String commandType, float prix, LocalDate commandDate, String commandAdresse,
			Boolean commandEtat, List<Product> produits, Facture facture, User user, Delivery delvey, Don don) {
		super();
		this.numeroCommand = numeroCommand;
		this.commandType = commandType;
		this.prix = prix;
		this.commandDate = commandDate;
		this.commandAdresse = commandAdresse;
		this.commandEtat = commandEtat;
		this.produits = produits;
		this.facture = facture;
		this.user = user;
		this.delvey = delvey;
		this.don = don;
	}


	public Command(Long id, int numeroCommand, String commandType, float prix, LocalDate commandDate,
			String commandAdresse, Boolean commandEtat, List<Product> produits, Facture facture, User user,
			Delivery delvey, Don don) {
		super();
		this.id = id;
		this.numeroCommand = numeroCommand;
		this.commandType = commandType;
		this.prix = prix;
		this.commandDate = commandDate;
		this.commandAdresse = commandAdresse;
		this.commandEtat = commandEtat;
		this.produits = produits;
		this.facture = facture;
		this.user = user;
		this.delvey = delvey;
		this.don = don;
	}


	public Command(Long id, int numeroCommand, String commandType, String typeDelivery, float prix,
			LocalDate commandDate, String commandAdresse, Boolean commandEtat, List<Product> produits, Facture facture,
			User user, Delivery delvey, Don don) {
		super();
		this.id = id;
		this.numeroCommand = numeroCommand;
		this.commandType = commandType;
		this.typeDelivery = typeDelivery;
		this.prix = prix;
		this.commandDate = commandDate;
		this.commandAdresse = commandAdresse;
		this.commandEtat = commandEtat;
		this.produits = produits;
		this.facture = facture;
		this.user = user;
		this.delvey = delvey;
		this.don = don;
	}


	public Command() {
		super();
	}


	@Override
	public String toString() {
		return "Command [id=" + id + ", numeroCommand=" + numeroCommand + ", commandType=" + commandType
				+ ", typeDelivery=" + typeDelivery + ", prix=" + prix + ", commandDate=" + commandDate
				+ ", commandAdresse=" + commandAdresse + ", commandEtat=" + commandEtat + "]";
	}
	



	
	
}

