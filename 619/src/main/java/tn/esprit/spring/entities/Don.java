package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Don implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float montantDon;
	private String descriptionDon ;
	
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="don")
	private List<Command> cosmmands;
	
	@ManyToOne
	private Jackpot jackpot;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getMontantDon() {
		return montantDon;
	}

	public void setMontantDon(float montantDon) {
		this.montantDon = montantDon;
	}

	public String getDescriptionDon() {
		return descriptionDon;
	}

	public void setDescriptionDon(String descriptionDon) {
		this.descriptionDon = descriptionDon;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Command> getCosmmands() {
		return cosmmands;
	}

	public void setCosmmands(List<Command> cosmmands) {
		this.cosmmands = cosmmands;
	}

	public Jackpot getJackpot() {
		return jackpot;
	}

	public void setJackpot(Jackpot jackpot) {
		this.jackpot = jackpot;
	}

	public Don(Long id, float montantDon, String descriptionDon, User user, List<Command> cosmmands, Jackpot jackpot) {
		super();
		this.id = id;
		this.montantDon = montantDon;
		this.descriptionDon = descriptionDon;
		this.user = user;
		this.cosmmands = cosmmands;
		this.jackpot = jackpot;
	}

	public Don(float montantDon, String descriptionDon, User user, List<Command> cosmmands, Jackpot jackpot) {
		super();
		this.montantDon = montantDon;
		this.descriptionDon = descriptionDon;
		this.user = user;
		this.cosmmands = cosmmands;
		this.jackpot = jackpot;
	}

	public Don() {
		super();
	}

	@Override
	public String toString() {
		return "Don [id=" + id + ", montantDon=" + montantDon + ", descriptionDon=" + descriptionDon + ", user=" + user
				+ ", cosmmands=" + cosmmands + ", jackpot=" + jackpot + "]";
	}
	
	
	
	
	
	
	
	
}

