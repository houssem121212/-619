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
public class Comment implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_c;

	private String content_c;
	private boolean useful ;
	private long replyCount ;
	
	@Temporal(TemporalType.DATE) 
	private Date creationDate;

	//Association 
	 //ManyToOne user: user
	// ManyToOne topic : topic 

	
	
}