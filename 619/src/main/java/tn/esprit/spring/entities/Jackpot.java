package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Jackpot implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private float Value;
	private float MaxValue;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(MaxValue);
		result = prime * result + Float.floatToIntBits(Value);
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jackpot other = (Jackpot) obj;
		if (Float.floatToIntBits(MaxValue) != Float.floatToIntBits(other.MaxValue))
			return false;
		if (Float.floatToIntBits(Value) != Float.floatToIntBits(other.Value))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Jackpot [id=" + id + ", Value=" + Value + ", MaxValue=" + MaxValue + "]";
	}
	public Jackpot(long id, float value, float maxValue) {
		super();
		this.id = id;
		Value = value;
		MaxValue = maxValue;
	}
	public Jackpot() {
		super();
	}
	
}
