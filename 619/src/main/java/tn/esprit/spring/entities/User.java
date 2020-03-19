package tn.esprit.spring.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;

    
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
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

	public User(int id, String userName, String password, boolean active, String roles, List<Command> commands,
			List<Delivery> deliverys, List<Don> dons, Aisle aisle, List<Event> events, Stock stocks, Cart cart, Ads ads,
			List<Product> products) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.active = active;
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

	public User(String userName, String password, boolean active, String roles, List<Command> commands,
			List<Delivery> deliverys, List<Don> dons, Aisle aisle, List<Event> events, Stock stocks, Cart cart, Ads ads,
			List<Product> products) {
		super();
		this.userName = userName;
		this.password = password;
		this.active = active;
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

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", active=" + active + ", roles=" + roles + ", Commands="
				+ Commands + ", deliverys=" + deliverys + ", dons=" + dons + ", aisle=" + aisle + ", events=" + events
				+ ", stocks=" + stocks + ", cart=" + cart + ", ads=" + ads + ", products=" + products + "]";
	}

    
	
    
   
}
