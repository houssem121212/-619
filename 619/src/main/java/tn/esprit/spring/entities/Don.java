package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
	private float montantdon;
	private String descriptiondon;
	@Column(name = "date")
	private Date date;
	
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

	public float getMontantdon() {
		return montantdon;
	}

	public void setMontantdon(float montantdon) {
		this.montantdon = montantdon;
	}

	public String getDescriptiondon() {
		return descriptiondon;
	}

	public void setDescriptiondon(String descriptiondon) {
		this.descriptiondon = descriptiondon;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	@Override
	public String toString() {
		return "Don [id=" + id + ", montantdon=" + montantdon + ", descriptiondon=" + descriptiondon + ", date=" + date
				+ ", user=" + user + ", cosmmands=" + cosmmands + ", jackpot=" + jackpot + "]";
	}

	public Don(Long id, float montantdon, String descriptiondon, Date date, User user, List<Command> cosmmands,
			Jackpot jackpot) {
		super();
		this.id = id;
		this.montantdon = montantdon;
		this.descriptiondon = descriptiondon;
		this.date = date;
		this.user = user;
		this.cosmmands = cosmmands;
		this.jackpot = jackpot;
	}

	public Don() {
		super();
	}

	
	
	
	
	
	
	
}

