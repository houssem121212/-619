package tn.esprit.spring.entities;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.assertj.core.annotations.Nullable;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Topic  {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_t;
	@NotBlank
    @Size(min = 3, max = 100)
	private String title;
	@NotBlank
	@Column(columnDefinition = "text")
	private String content;
	
	
	
	
	
	
	public Topic(Long id_t, @NotBlank @Size(min = 3, max = 100) String title, @NotBlank String content) {
		super();
		this.id_t = id_t;
		this.title = title;
		this.content = content;
	}
	public Topic(Long id_t, @NotBlank @Size(min = 3, max = 100) String title, @NotBlank String content, User user) {
		super();
		this.id_t = id_t;
		this.title = title;
		this.content = content;
		this.user = user;
	}


	//@Nullable
	private Long views;
	
	//@Temporal(TemporalType.TIMESTAMP)
	 //@LastModifiedDate
	
	private LocalDate creationDate;
	

	//@Temporal(TemporalType.DATE)
	private LocalDate lastUpDate;
	
	
	
	public void setLastUpDate(LocalDate lastUpDate) {
		this.lastUpDate = lastUpDate;
	}
	
	
	//@Nullable
	private boolean closed;
	//@Nullable
	private Long likeCount;
	//@Column (name="commentCount")
	private Long commentCount;
	@Nullable
	private String image_t;
	
	@OneToMany(mappedBy = "topic")
	private List<Picture> pic;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	User user ;
	
	private String username ;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonIgnore
	@ManyToOne
	Section section ;
	
	private String category ; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="topic")
    private List<Comment> comments ;
	
	
	
	
	
	
	
	
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Topic(@NotBlank @Size(min = 3, max = 100) String title, @NotBlank String content) {
		super();
		this.title = title;
		this.content = content;
		
	}
	
	

	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public Long getId_t() {
		return id_t;
	}
	public void setId_t(Long id_t) {
		this.id_t = id_t;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getViews() {
		return views;
	}
	public void setViews(Long views) {
		this.views = views;
	}
	
	public LocalDate getLastUpDate() {
		return lastUpDate;
	}
	
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	public Long getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}
	public Long getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}
	public String getImage_t() {
		return image_t;
	}
	public void setImage_t(String image_t) {
		this.image_t = image_t;
	}
	
	
	public User getUser() {
		
		return user;
	}
	public void setUser(User user) {
		
		this.user = user;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
	public Topic(@NotBlank @Size(min = 3, max = 100) String title, @NotBlank String content, String image_t) {
		super();
		this.title = title;
		this.content = content;
		this.image_t = image_t;
	}
	public Topic(Long id_t, @NotBlank @Size(min = 3, max = 100) String title, @NotBlank String content,
			String image_t) {
		super();
		this.id_t = id_t;
		this.title = title;
		this.content = content;
		this.image_t = image_t;
	}
	
	
	
	public Topic(Long id_t,String username, @NotBlank @Size(min = 3, max = 100) String title, @NotBlank String content,String image_t, 
			LocalDate creationDate, LocalDate lastUpDate, Long commentCount,List<Comment> comments) {
		super();
		this.id_t = id_t;
		this.username = username;
		this.title = title;
		this.content = content;
		this.image_t = image_t;
		this.creationDate = creationDate;
		this.lastUpDate = lastUpDate;
		this.commentCount = commentCount;
		this.comments = comments;
	}

	

	public Topic(Long id_t, @NotBlank @Size(min = 3, max = 100) String title, @NotBlank String content, Long views,
			LocalDate creationDate, LocalDate lastUpDate, boolean closed, Long likeCount, Long commentCount,
			String image_t, List<Picture> pic, User user, String username, Section section, String category,
			List<Comment> comments) {
		super();
		this.id_t = id_t;
		this.title = title;
		this.content = content;
		this.views = views;
		this.creationDate = creationDate;
		this.lastUpDate = lastUpDate;
		this.closed = closed;
		this.likeCount = likeCount;
		this.commentCount = commentCount;
		this.image_t = image_t;
		this.pic = pic;
		this.user = user;
		this.username = username;
		this.section = section;
		this.category = category;
		this.comments = comments;
		
	}
	public Topic() {
		super();
	}
	
	
	public Topic(Long id_t) {
		super();
		this.id_t = id_t;
	}
	@Override
	public String toString() {
		return "Topic [id_t=" + id_t + ", title=" + title + ", content=" + content + ", views=" + views
				+ ", creationDate=" + creationDate + ", lastUpDate=" + lastUpDate + ", closed=" + closed
				+ ", likeCount=" + likeCount + ", commentCount=" + commentCount + ", image_t=" + image_t + ", pic="
				+ pic + ", user=" + user + ", username=" + username + ", section=" + section + ", category=" + category
				+ ", comments=" + comments + "]";
	}

	
	


}
