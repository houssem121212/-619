package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Command {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "commandType")
	private TypeCommand commandType;
	
	@Temporal(TemporalType.DATE)
	private Date commandDate;
	
	@Column(name = "command_Adresse")
	private String command_Adresse;

	
	@Column(name = "commandEtat")
	private Boolean commandEtat;
	
	
	
	
}
