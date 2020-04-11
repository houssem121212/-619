package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "Event")
//JsonIgnoreProperties({"Event"})
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titre_event")
	private String titre_event;
	private String description ;
	@Column(name = "event_category")
	@Enumerated(EnumType.STRING)
	private eventcategory event_category;
	private String location;
	private float price;
	@Column(name = "img_url")
	private String img_url;
	private boolean status;  // approved or not
	@Column(name = "nbr_vue")
	private int nbr_vue;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_start_event")
	private Date date_start_event;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_end_event")
	private Date date_end_event;
	
	@ManyToMany
	@JsonIgnore
	private List<User> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre_event() {
		return titre_event;
	}

	public void setTitre_event(String titre_event) {
		this.titre_event = titre_event;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public eventcategory getEvent_category() {
		return event_category;
	}

	public void setEvent_category(eventcategory event_category) {
		this.event_category = event_category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getNbr_vue() {
		return nbr_vue;
	}

	public void setNbr_vue(int nbr_vue) {
		this.nbr_vue = nbr_vue;
	}

	public Date getDate_start_event() {
		return date_start_event;
	}

	public void setDate_start_event(Date date_start_event) {
		this.date_start_event = date_start_event;
	}

	public Date getDate_end_event() {
		return date_end_event;
	}

	public void setDate_end_event(Date date_end_event) {
		this.date_end_event = date_end_event;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_end_event == null) ? 0 : date_end_event.hashCode());
		result = prime * result + ((date_start_event == null) ? 0 : date_start_event.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((event_category == null) ? 0 : event_category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((img_url == null) ? 0 : img_url.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + nbr_vue;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((titre_event == null) ? 0 : titre_event.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		if (date_end_event == null) {
			if (other.date_end_event != null)
				return false;
		} else if (!date_end_event.equals(other.date_end_event))
			return false;
		if (date_start_event == null) {
			if (other.date_start_event != null)
				return false;
		} else if (!date_start_event.equals(other.date_start_event))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (event_category != other.event_category)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (img_url == null) {
			if (other.img_url != null)
				return false;
		} else if (!img_url.equals(other.img_url))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (nbr_vue != other.nbr_vue)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (status != other.status)
			return false;
		if (titre_event == null) {
			if (other.titre_event != null)
				return false;
		} else if (!titre_event.equals(other.titre_event))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", titre_event=" + titre_event + ", description=" + description + ", event_category="
				+ event_category + ", location=" + location + ", price=" + price + ", img_url=" + img_url + ", status="
				+ status + ", nbr_vue=" + nbr_vue + ", date_start_event=" + date_start_event + ", date_end_event="
				+ date_end_event + ", users=" + users + "]";
	}

	public Event(Long id, String titre_event, String description, eventcategory event_category, String location,
			float price, String img_url, boolean status, int nbr_vue, Date date_start_event, Date date_end_event,
			List<User> users) {
		super();
		this.id = id;
		this.titre_event = titre_event;
		this.description = description;
		this.event_category = event_category;
		this.location = location;
		this.price = price;
		this.img_url = img_url;
		this.status = status;
		this.nbr_vue = nbr_vue;
		this.date_start_event = date_start_event;
		this.date_end_event = date_end_event;
		this.users = users;
	}

	public Event() {
		super();
	}

	
	
	
	
}