package tn.esprit.spring.service;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;

import tn.esprit.spring.entities.ChargeRequest;
import tn.esprit.spring.entities.email;

public interface IStripeService {

	public String createStripeCustomer(email email) throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException;

	public String createCard(email customerId) throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException;

	public Long charge(ChargeRequest chargeRequest) throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException;
}
