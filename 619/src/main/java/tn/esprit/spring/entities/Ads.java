package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ads implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne
	private Category categorie;
	
	
	private String description;
	
	private String typeFile;
	 
	
	
	private String file;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategorie() {
		return categorie;
	}

	public void setCategorie(Category categorie) {
		this.categorie = categorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeFile() {
		return typeFile;
	}

	public void setTypeFile(String typeFile) {
		this.typeFile = typeFile;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
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

	@Override
	public String toString() {
		return "Ads [id=" + id + ", categorie=" + categorie + ", description=" + description + ", typeFile=" + typeFile
				+ ", file=" + file + ", date=" + date + ", user=" + user + "]";
	}

	public Ads(Long id, Category categorie, String description, String typeFile, String file, Date date, User user) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.description = description;
		this.typeFile = typeFile;
		this.file = file;
		this.date = date;
		this.user = user;
	}

	public Ads(Category categorie, String description, String typeFile, String file, Date date, User user) {
		super();
		this.categorie = categorie;
		this.description = description;
		this.typeFile = typeFile;
		this.file = file;
		this.date = date;
		this.user = user;
	}

	public Ads() {
		super();
	}
	
	
}
