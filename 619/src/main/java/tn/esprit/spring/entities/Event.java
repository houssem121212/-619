package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String TitreEvent;
	private String Description ;
	private int NbrVue;
	private Date DateStartEvent;
	private Date DateEndEvent;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitreEvent() {
		return TitreEvent;
	}
	public void setTitreEvent(String titreEvent) {
		TitreEvent = titreEvent;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getNbrVue() {
		return NbrVue;
	}
	public void setNbrVue(int nbrVue) {
		NbrVue = nbrVue;
	}
	public Date getDateStartEvent() {
		return DateStartEvent;
	}
	public void setDateStartEvent(Date dateStartEvent) {
		DateStartEvent = dateStartEvent;
	}
	public Date getDateEndEvent() {
		return DateEndEvent;
	}
	public void setDateEndEvent(Date dateEndEvent) {
		DateEndEvent = dateEndEvent;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DateEndEvent == null) ? 0 : DateEndEvent.hashCode());
		result = prime * result + ((DateStartEvent == null) ? 0 : DateStartEvent.hashCode());
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + NbrVue;
		result = prime * result + ((TitreEvent == null) ? 0 : TitreEvent.hashCode());
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
		Event other = (Event) obj;
		if (DateEndEvent == null) {
			if (other.DateEndEvent != null)
				return false;
		} else if (!DateEndEvent.equals(other.DateEndEvent))
			return false;
		if (DateStartEvent == null) {
			if (other.DateStartEvent != null)
				return false;
		} else if (!DateStartEvent.equals(other.DateStartEvent))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (NbrVue != other.NbrVue)
			return false;
		if (TitreEvent == null) {
			if (other.TitreEvent != null)
				return false;
		} else if (!TitreEvent.equals(other.TitreEvent))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", TitreEvent=" + TitreEvent + ", Description=" + Description + ", NbrVue=" + NbrVue
				+ ", DateStartEvent=" + DateStartEvent + ", DateEndEvent=" + DateEndEvent + "]";
	}
	public Event(long id, String titreEvent, String description, int nbrVue, Date dateStartEvent, Date dateEndEvent) {
		super();
		this.id = id;
		TitreEvent = titreEvent;
		Description = description;
		NbrVue = nbrVue;
		DateStartEvent = dateStartEvent;
		DateEndEvent = dateEndEvent;
	}
	public Event() {
		super();
	}
	
}
