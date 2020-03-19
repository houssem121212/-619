package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Don implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_don;
	private long montant_don;
	private String description ;
	public long getId_don() {
		return id_don;
	}
	public void setId_don(long id_don) {
		this.id_don = id_don;
	}
	public long getMontant_don() {
		return montant_don;
	}
	public void setMontant_don(long montant_don) {
		this.montant_don = montant_don;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id_don ^ (id_don >>> 32));
		result = prime * result + (int) (montant_don ^ (montant_don >>> 32));
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
		Don other = (Don) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id_don != other.id_don)
			return false;
		if (montant_don != other.montant_don)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Don [id_don=" + id_don + ", montant_don=" + montant_don + ", description=" + description + "]";
	}
	public Don(long id_don, long montant_don, String description) {
		super();
		this.id_don = id_don;
		this.montant_don = montant_don;
		this.description = description;
	}
	public Don() {
		super();
	}
}