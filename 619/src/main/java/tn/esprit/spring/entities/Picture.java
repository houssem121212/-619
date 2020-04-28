package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Picture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	private Topic topic;
	
	private String image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Picture(Long id, Topic topic, String image) {
		super();
		this.id = id;
		this.topic = topic;
		this.image = image;
	}

	public Picture(Topic topic, String image) {
		super();
		this.topic = topic;
		this.image = image;
	}

	public Picture() {
		super();
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", topic=" + topic + ", image=" + image + "]";
	}
	
	
	
	

}
