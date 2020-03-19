package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String TitreEvent;
	private String Description ;
	private int NbrVue;
	@Temporal(TemporalType.DATE)
	private Date DateStartEvent;
	@Temporal(TemporalType.DATE)
	private Date DateEndEvent;
	
	@ManyToMany
	private List<User> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Event(Long id, String titreEvent, String description, int nbrVue, Date dateStartEvent, Date dateEndEvent,
			List<User> users) {
		super();
		this.id = id;
		TitreEvent = titreEvent;
		Description = description;
		NbrVue = nbrVue;
		DateStartEvent = dateStartEvent;
		DateEndEvent = dateEndEvent;
		this.users = users;
	}

	public Event(String titreEvent, String description, int nbrVue, Date dateStartEvent, Date dateEndEvent,
			List<User> users) {
		super();
		TitreEvent = titreEvent;
		Description = description;
		NbrVue = nbrVue;
		DateStartEvent = dateStartEvent;
		DateEndEvent = dateEndEvent;
		this.users = users;
	}

	public Event() {
		super();
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", TitreEvent=" + TitreEvent + ", Description=" + Description + ", NbrVue=" + NbrVue
				+ ", DateStartEvent=" + DateStartEvent + ", DateEndEvent=" + DateEndEvent + ", users=" + users + "]";
	}
	
	
	
}
