package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "GeoIP")
public class GeoIP {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	Long id_Ip;
	
    private String 	ipAddress;
	
    private String city;
    
    private String latitude;
    
    private String longitude;
    
    @JsonIgnore
    @OneToOne
    private User user;

    
    public GeoIP() {

    }
    

	public GeoIP(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public GeoIP(String ipAddress, String city, String latitude, String longitude, User currentUser) {
        this.ipAddress = ipAddress;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    
    
	public Long getId_Ip() {
		return id_Ip;
	}


	public void setId_Ip(Long id_Ip) {
		this.id_Ip = id_Ip;
	}


	public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
   
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

    

	public GeoIP(Long id_Ip, String ipAddress, String city, String latitude, String longitude) {///ya9ra ken fi hetha ya9rahom lkol just sa3at how may7ebch :p hhhhh
		super();
		this.id_Ip = id_Ip;
		this.ipAddress = ipAddress;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public GeoIP(String ipAddress, String city, String latitude, String longitude) {
		super();
		this.ipAddress = ipAddress;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		
	}

	public GeoIP(Long id_Ip, String ipAddress, String city, String latitude, String longitude, User user) {
		super();
		this.id_Ip = id_Ip;
		this.ipAddress = ipAddress;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		//this.uid = uid;
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "GeoIP [ipAddress=" + ipAddress + ", city=" + city + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}


}