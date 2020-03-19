package tn.esprit.spring.entities;

import java.io.Serializable;
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
public class Facture implements Serializable {
	
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
	
	@OneToOne(mappedBy="facture")
	private Command command;

	public Long getFactureId() {
		return factureId;
	}

	public void setFactureId(Long factureId) {
		this.factureId = factureId;
	}

	public Long getFactureNumero() {
		return factureNumero;
	}

	public void setFactureNumero(Long factureNumero) {
		this.factureNumero = factureNumero;
	}

	public float getFacturePrice() {
		return facturePrice;
	}

	public void setFacturePrice(float facturePrice) {
		this.facturePrice = facturePrice;
	}

	public Date getFactureDate() {
		return factureDate;
	}

	public void setFactureDate(Date factureDate) {
		this.factureDate = factureDate;
	}

	public float getFactureTVA() {
		return factureTVA;
	}

	public void setFactureTVA(float factureTVA) {
		this.factureTVA = factureTVA;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Facture(Long factureId, Long factureNumero, float facturePrice, Date factureDate, float factureTVA,
			Command command) {
		super();
		this.factureId = factureId;
		this.factureNumero = factureNumero;
		this.facturePrice = facturePrice;
		this.factureDate = factureDate;
		this.factureTVA = factureTVA;
		this.command = command;
	}

	public Facture(Long factureNumero, float facturePrice, Date factureDate, float factureTVA, Command command) {
		super();
		this.factureNumero = factureNumero;
		this.facturePrice = facturePrice;
		this.factureDate = factureDate;
		this.factureTVA = factureTVA;
		this.command = command;
	}

	public Facture() {
		super();
	}

	@Override
	public String toString() {
		return "Facture [factureId=" + factureId + ", factureNumero=" + factureNumero + ", facturePrice=" + facturePrice
				+ ", factureDate=" + factureDate + ", factureTVA=" + factureTVA + ", command=" + command + "]";
	}
	
	

}
