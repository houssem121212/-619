package tn.esprit.spring.entities;

import java.io.Serializable;
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
	private float duree;
	private float maxValue;
	
	
	@Enumerated(EnumType.STRING)
	private Typejackpot typeJackpot;
	
	
	@OneToMany(mappedBy="jackpot")
	private List<Don> dons;


	


	public Jackpot(String titre, float duree, float maxValue, Typejackpot typeJackpot, List<Don> dons) {
		super();
		this.titre = titre;
		this.duree = duree;
		this.maxValue = maxValue;
		this.typeJackpot = typeJackpot;
		this.dons = dons;
	}





	public Jackpot(Long id, String titre, float duree, float maxValue, Typejackpot typeJackpot, List<Don> dons) {
		super();
		this.id = id;
		this.titre = titre;
		this.duree = duree;
		this.maxValue = maxValue;
		this.typeJackpot = typeJackpot;
		this.dons = dons;
	}





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





	public float getDuree() {
		return duree;
	}





	public void setDuree(float duree) {
		this.duree = duree;
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





	public Jackpot() {
		super();
	}



	
}
