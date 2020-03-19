package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	
}
