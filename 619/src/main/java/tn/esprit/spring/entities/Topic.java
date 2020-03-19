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
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_t;
	
	private String title;
	
	private String content;
	
	private long views;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@Temporal(TemporalType.DATE)
	private Date lastUpDate;
	
	private boolean closed;

	private long likeCount;
	
	private long commentCount;
	// private String image_t

	// assiciation : ManyToOne user:user
	// association : ManyToOne section : section

}
