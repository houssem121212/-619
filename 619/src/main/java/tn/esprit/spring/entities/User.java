package tn.esprit.spring.entities;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;


@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    
    private int salary;
    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {

    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    
    @OneToMany(mappedBy="user")
  	private List<Command> Commands;
      
      @OneToMany(mappedBy="user")
  	private List<Delivery> deliverys;
      
      @OneToMany(mappedBy="user")
  	private List<Don> dons;
      
      @OneToOne(mappedBy="user")
  	private Aisle aisle;
      
      @ManyToMany(mappedBy="users")
  	private List<Event> events;

      @ManyToOne
  	private Stock stocks;
      
      @OneToOne
  	private Cart cart;
      
      @OneToOne(mappedBy="user")
  	private Ads ads;
      
      @ManyToMany(mappedBy="users")
  	private List<Product> products;

	public User(Long id, @NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, Set<Role> roles,
			List<Command> commands, List<Delivery> deliverys, List<Don> dons, Aisle aisle, List<Event> events,
			Stock stocks, Cart cart, Ads ads, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		Commands = commands;
		this.deliverys = deliverys;
		this.dons = dons;
		this.aisle = aisle;
		this.events = events;
		this.stocks = stocks;
		this.cart = cart;
		this.ads = ads;
		this.products = products;
	}

	

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public User(Long id, int salary, @NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, Set<Role> roles,
			List<Command> commands, List<Delivery> deliverys, List<Don> dons, Aisle aisle, List<Event> events,
			Stock stocks, Cart cart, Ads ads, List<Product> products) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		Commands = commands;
		this.deliverys = deliverys;
		this.dons = dons;
		this.aisle = aisle;
		this.events = events;
		this.stocks = stocks;
		this.cart = cart;
		this.ads = ads;
		this.products = products;
	}

	public List<Command> getCommands() {
		return Commands;
	}

	public void setCommands(List<Command> commands) {
		Commands = commands;
	}

	public List<Delivery> getDeliverys() {
		return deliverys;
	}

	public void setDeliverys(List<Delivery> deliverys) {
		this.deliverys = deliverys;
	}

	public List<Don> getDons() {
		return dons;
	}

	public void setDons(List<Don> dons) {
		this.dons = dons;
	}

	public Aisle getAisle() {
		return aisle;
	}

	public void setAisle(Aisle aisle) {
		this.aisle = aisle;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Stock getStocks() {
		return stocks;
	}

	public void setStocks(Stock stocks) {
		this.stocks = stocks;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Ads getAds() {
		return ads;
	}

	public void setAds(Ads ads) {
		this.ads = ads;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	    
    

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@OneToMany( mappedBy="user")
    private List<Comment> comments ;

    @OneToMany( mappedBy="user")
    private List<Topic> topics ;

    @OneToMany( mappedBy="user")
    private List<Reply> replies ;
    
    

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	
	public User(Long id, int salary, @NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, Set<Role> roles,
			List<Command> commands, List<Delivery> deliverys, List<Don> dons, Aisle aisle, List<Event> events,
			Stock stocks, Cart cart, Ads ads, List<Product> products, List<Comment> comments, List<Topic> topics,
			List<Reply> replies) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		Commands = commands;
		this.deliverys = deliverys;
		this.dons = dons;
		this.aisle = aisle;
		this.events = events;
		this.stocks = stocks;
		this.cart = cart;
		this.ads = ads;
		this.products = products;
		this.comments = comments;
		this.topics = topics;
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", salary=" + salary + ", name=" + name + ", username=" + username + ", email="
				+ email + ", password=" + password + ", roles=" + roles + ", Commands=" + Commands + ", deliverys="
				+ deliverys + ", dons=" + dons + ", aisle=" + aisle + ", events=" + events + ", stocks=" + stocks
				+ ", cart=" + cart + ", ads=" + ads + ", products=" + products + ", comments=" + comments + ", topics="
				+ topics + ", replies=" + replies + "]";
	}

	


      
    

   
     
    
      
    
}