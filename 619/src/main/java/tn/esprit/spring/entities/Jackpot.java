package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Jackpot implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float Value;
	private float MaxValue;
	
	
	
	@OneToMany(mappedBy="jackpot")
	private List<Don> dons;



	public Jackpot(Long id, float value, float maxValue, List<Don> dons) {
		super();
		this.id = id;
		Value = value;
		MaxValue = maxValue;
		this.dons = dons;
	}



	public Jackpot(float value, float maxValue, List<Don> dons) {
		super();
		Value = value;
		MaxValue = maxValue;
		this.dons = dons;
	}



	public Jackpot() {
		super();
	}



	@Override
	public String toString() {
		return "Jackpot [id=" + id + ", Value=" + Value + ", MaxValue=" + MaxValue + ", dons=" + dons + "]";
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public float getValue() {
		return Value;
	}



	public void setValue(float value) {
		Value = value;
	}



	public float getMaxValue() {
		return MaxValue;
	}



	public void setMaxValue(float maxValue) {
		MaxValue = maxValue;
	}



	public List<Don> getDons() {
		return dons;
	}



	public void setDons(List<Don> dons) {
		this.dons = dons;
	}
	
	
	
}
