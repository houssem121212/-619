package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "status")
    private String status;
    
    @Column(name = "created_date")
    private LocalDate created_date;

    @NotNull
    @Column(name = "description")
    private String description;
    
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	 User user;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate time) {
		this.created_date = time;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Ticket() {
		super();
	}


	
	
	
	public Ticket(@NotNull String title, @NotNull String status, @NotNull String description) {
		super();
		this.title = title;
		this.status = status;
		this.description = description;
	}

	public Ticket(Long id, @NotNull String title, @NotNull String status, @NotNull String description) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.description = description;
	}

	public Ticket(Long id, @NotNull String title, @NotNull String status, LocalDate created_date,
			@NotNull String description) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.created_date = created_date;
		this.description = description;
	}

	public Ticket(Long id, @NotNull String title, @NotNull String status, LocalDate created_date,
			@NotNull String description, User user) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.created_date = created_date;
		this.description = description;
		this.user = user;
	}

	@Override
    public String toString() {

         StringBuilder builder = new StringBuilder();
        builder.append("Ticket{id=").append(id).append(", title=")
                .append(title).append(", status=")
                .append(status).append(", description=")
                .append(description).append("}");

        return builder.toString();
    }
	
}
