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

    
    @OneToMany(mappedBy="userCommand")
	private List<Command> Commands;
    
    @OneToMany(mappedBy="userDelivery")
	private List<Delivery> deliverys;
    
    @OneToOne
	private Aisle aisles;

    @ManyToOne
	private Stock stocks;
    
    @OneToOne(mappedBy="user")
	private Ads adds;
    
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

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", active=" + active
				+ ", roles=" + roles + "]";
	}
    
    
    //first commit karim
	
	//test
}
