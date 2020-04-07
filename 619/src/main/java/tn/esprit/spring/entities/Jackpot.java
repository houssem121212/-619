package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Jackpot implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	
	private Date  datefin;
	private float maxValue;
	
	
	@Enumerated(EnumType.STRING)
	private Typejackpot typeJackpot;
	
	
	@OneToMany(mappedBy="jackpot")
	private List<Don> dons;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public Date getDatefin() {
		return datefin;
	}


	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}


	public float getMaxValue() {
		return maxValue;
	}


	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}


	public Typejackpot getTypeJackpot() {
		return typeJackpot;
	}


	public void setTypeJackpot(Typejackpot typeJackpot) {
		this.typeJackpot = typeJackpot;
	}


	public List<Don> getDons() {
		return dons;
	}


	public void setDons(List<Don> dons) {
		this.dons = dons;
	}


	@Override
	public String toString() {
		return "Jackpot [id=" + id + ", titre=" + titre + ", datefin=" + datefin + ", maxValue=" + maxValue
				+ ", typeJackpot=" + typeJackpot + ", dons=" + dons + "]";
	}


	public Jackpot(Long id, String titre, Date datefin, float maxValue, Typejackpot typeJackpot, List<Don> dons) {
		super();
		this.id = id;
		this.titre = titre;
		this.datefin = datefin;
		this.maxValue = maxValue;
		this.typeJackpot = typeJackpot;
		this.dons = dons;
	}


	public Jackpot(String titre, Date datefin, float maxValue, Typejackpot typeJackpot, List<Don> dons) {
		super();
		this.titre = titre;
		this.datefin = datefin;
		this.maxValue = maxValue;
		this.typeJackpot = typeJackpot;
		this.dons = dons;
	}


	public Jackpot() {
		super();
	}



	
}
