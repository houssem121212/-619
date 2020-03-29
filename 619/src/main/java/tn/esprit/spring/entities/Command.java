package tn.esprit.spring.entities;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Command implements Serializable {

	@JsonIgnoreProperties({"produits","don","aisle","user","facture","delvey"})
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
	

	@ManyToMany
	private List<Product> produits;
	
	@OneToOne
	private Facture facture;
	
	@ManyToOne
	private User user;

	@ManyToOne
	private Delivery delvey;
	
	@ManyToOne
	private Don don;

	public Don getDon() {
		return don;
	}

	public void setDon(Don don) {
		this.don = don;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeCommand getCommandType() {
		return commandType;
	}

	public void setCommandType(TypeCommand commandType) {
		this.commandType = commandType;
	}

	public Date getCommandDate() {
		return commandDate;
	}

	public void setCommandDate(Date commandDate) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Command(Long id, TypeCommand commandType, Date commandDate, String commandAdresse, Boolean commandEtat,
			List<Product> produits, Facture facture, User user, Delivery delvey) {
		super();
		this.id = id;
		this.commandType = commandType;
		this.commandDate = commandDate;
		this.commandAdresse = commandAdresse;
		this.commandEtat = commandEtat;
		this.produits = produits;
		this.facture = facture;
		this.user = user;
		this.delvey = delvey;
	}

	public Command(TypeCommand commandType, Date commandDate, String commandAdresse, Boolean commandEtat,
			List<Product> produits, Facture facture, User user, Delivery delvey) {
		super();
		this.commandType = commandType;
		this.commandDate = commandDate;
		this.commandAdresse = commandAdresse;
		this.commandEtat = commandEtat;
		this.produits = produits;
		this.facture = facture;
		this.user = user;
		this.delvey = delvey;
	}

	public Command() {
		super();
	}

	@Override
	public String toString() {
		return "Command [id=" + id + ", commandType=" + commandType + ", commandDate=" + commandDate
				+ ", commandAdresse=" + commandAdresse + ", commandEtat=" + commandEtat + ", produits=" + produits
				+ ", facture=" + facture + ", user=" + user + ", delvey=" + delvey + "]";
	}
	
	
	
	
}
