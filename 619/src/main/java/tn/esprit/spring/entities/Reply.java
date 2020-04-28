package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reply implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_r;
	private String content;
	private String imageS ;

	
	//@Temporal(TemporalType.DATE)
	private LocalDate replyTime;

	private String username ; 	
	
	@JsonIgnore
	@ManyToOne
	Comment comment ;
	
	@JsonIgnore
	@ManyToOne
	User user ;

	public Long getId_r() {
		return id_r;
	}


	public void setId_r(Long id_r) {
		this.id_r = id_r;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImageS() {
		return imageS;
	}


	public void setImageS(String imageS) {
		this.imageS = imageS;
	}


	public LocalDate getReplyTime() {
		return replyTime;
	}


	public void setReplyTime(LocalDate replyTime) {
		this.replyTime = replyTime;
	}
	
	



	public Comment getComment() {
		return comment;
	}


	public void setComment(Comment comment) {
		this.comment = comment;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	
	
	public Reply(Long id_r, String content, String imageS, LocalDate replyTime, String username, Comment comment,
			User user) {
		super();
		this.id_r = id_r;
		this.content = content;
		this.imageS = imageS;
		this.replyTime = replyTime;
		this.username = username;
		this.comment = comment;
		this.user = user;
	}


	public Reply() {
		super();
	}


	@Override
	public String toString() {
		return "Reply [id_r=" + id_r + ", content=" + content + ", imageS=" + imageS + ", replyTime=" + replyTime
				+ ", username=" + username + ", comment=" + comment + ", user=" + user + "]";
	}



	

}
