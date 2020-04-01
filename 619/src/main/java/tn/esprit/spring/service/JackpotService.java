package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repository.JackpotRepository;
@Service
public class JackpotService implements IJackpotService{

	@Autowired
	JackpotRepository jackpotrepository;
	
	
	public String addJackpot(Jackpot jackpot) {
		jackpotrepository.save(jackpot);
		return "jackpot sucess";
	}

	
	
	
	
	
}
