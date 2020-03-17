package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Facture {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Facture")
	private long id_Facture;

	@Column(name = "numero_Facture")
	private Long numero_Facture;

	@Column(name = "price_Facture")
	private float price_Facture;

	@Temporal(TemporalType.DATE)
	private Date date_Facture;

	@Column(name = "TVA_Facture")
	private float TVA_Facture;
	

}
