package tn.esprit.spring.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Delivery")
public class Delivery {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Delivery_Id")
	private Long id;
	
	@NotNull
    @Column(name = "delivery_price")
    private Double price;


    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date; 
    
    @NotNull
    @Column(name = "status")
    private String status;
	
    @NotNull
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy="DelveyCommand")
	private List<Command> Commands;

    @ManyToOne
	private User userDelivery;
    
    
}
