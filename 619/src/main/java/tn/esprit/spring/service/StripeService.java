package tn.esprit.spring.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;

import tn.esprit.spring.entities.ChargeRequest;
import tn.esprit.spring.entities.email;

@Service
public class StripeService  {

	 @Value("${STRIPE_SECRET_KEY}")
	    private String secretKey;
	     
	    @PostConstruct
	    public void init() {
	        Stripe.apiKey = secretKey;
	    }
	    
	    
	    
	    
	    //creation d'un stripe account
	    
	    /**
	     * @param accountUuid Linked account id.
	     * @throws APIException 
	     * @throws CardException 
	     * @throws APIConnectionException 
	     * @throws InvalidRequestException 
	     * @throws AuthenticationException 
	     * @link https://stripe.com/docs/api#create_customer
	     */
	    public String createStripeCustomer(email email) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
	    	//stripe key
	    	Stripe.apiKey= "sk_test_GoY3Wdg4CoRCK2snuRLF52MD00D9SCttXw";
	    	
	    	
	    	Map<String, Object> params = new HashMap<>();
	    	params.put("description","My First Test Customer (created for API docs)");
	        params.put("email", email.getEmail());
	        
	  
			
	        
	    	//affichage id  du customer
	    	try {
	        	Customer customer = Customer.create(params);
	           
	            System.out.println("create customer id: {}");
	           return customer.getId();
	        } catch (StripeException e) {
	           
	            throw new RuntimeException(e);
	        }
	    	
	    }
	    
	    
	    //creation d'un carte bancaire
	    
	    public String createCard(email customerId) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException{
	    	//stripe key
	    	Stripe.apiKey= "sk_test_GoY3Wdg4CoRCK2snuRLF52MD00D9SCttXw";

	    	Customer customer =
	    	  Customer.retrieve(customerId.getEmail());

	    	
	    	Map < String, Object> cardParam = new HashMap< String, Object> ();
	        cardParam.put("number", "5555555555554444");
	        cardParam.put("exp_month", "11");
	        cardParam.put("exp_year", "2026");
	        cardParam.put("cvc", "123");
	        
	        
	        Map < String, Object> tokenParam = new HashMap< String, Object> ();
	        tokenParam.put("card", cardParam); 
	        
	        Token token =Token.create(tokenParam);
	        
	        Map < String, Object> source = new HashMap< String, Object> ();
	        source.put("source", token.getId()); 
	        
	    
	       
	        customer.getSources().create(source);
	    	return token.getId();
	    }
	    
	    
	    
	    //faire un payment
	    
	    public Long charge(ChargeRequest chargeRequest) 
	    	      throws AuthenticationException, InvalidRequestException,
	    	        APIConnectionException, CardException, APIException {
	    	//stripe key
	    	Stripe.apiKey= "sk_test_GoY3Wdg4CoRCK2snuRLF52MD00D9SCttXw";

	    	// `source` is obtained with Stripe.js; see https://stripe.com/docs/payments/accept-a-payment-charges#web-create-token
	    	Map<String, Object> params = new HashMap<>();
	    	params.put("amount", "500");
	    	params.put("currency", chargeRequest.getCurrency());
	    	params.put("description", chargeRequest.getDescription());
	    	params.put("customer", "cus_GxNBzUYslR89pq");
	    	
	    	
	    	Charge charge = Charge.create(params);    
	    	return charge.getAmount();
	    	    }
}

