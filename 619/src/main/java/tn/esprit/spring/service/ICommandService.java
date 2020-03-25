package tn.esprit.spring.service;

import tn.esprit.spring.entities.ChargeRequest;
import tn.esprit.spring.entities.email;

public interface ICommandService {
	public String createStripeCustomer(email email);
	public String createCard(email customerId);
	public Long charge(ChargeRequest chargeRequest);
}
