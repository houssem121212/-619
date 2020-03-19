package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Facture {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "factureId")
	private Long factureId;

	@Column(name = "factureNumero")
	private Long factureNumero;

	@Column(name = "facturePrice")
	private float facturePrice;

	@Temporal(TemporalType.DATE)
	private Date factureDate;

	@Column(name = "factureTVA")
	private float factureTVA;
	
	@OneToOne
	private Command commands;

}
