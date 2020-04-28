package tn.esprit.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.exception.InvalidInputException;



@Entity
public class RatingTopic {
	@Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    private User user;

    @OneToOne
    private Topic topic;

    private Integer stars;

    private RatingTopic() {
    } 

    public RatingTopic(final User user, final Topic movie, Integer stars) {
        this.user = user;
        this.topic = topic;
        if (stars < 1 || stars > 5) {
            throw new InvalidInputException();
        }
        this.stars = stars;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

public void setUser(User user) {
		this.user = user;
	}

	public Topic getTopic() {
		return topic;
	}

	
	public Integer getStars() {
		return stars;
	}

	
	
    
    
    
}
