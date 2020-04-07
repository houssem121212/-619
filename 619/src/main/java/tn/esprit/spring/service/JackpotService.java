package tn.esprit.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Don;
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

	
	public long updateJackpot(Jackpot jackpot) {
		if (jackpotrepository.findById(jackpot.getId()).get() != null) {
			jackpotrepository.save(jackpot);
			return jackpot.getId();
		}
		return 0;
	}
	
public void deletejackpotById (Long jackpotId){
		
		Jackpot JackpotId = jackpotrepository.findById(jackpotId).get();
		
		jackpotrepository.delete(JackpotId);
	
	}
	
public List<Jackpot> getAllJackpot() {

	return jackpotrepository.findAll();
}






public long daysBetween( Long jackpotId) {
	Jackpot jackpot = jackpotrepository.findById(jackpotId).get();
	Date g = new Date();
	
	
	long  days =( jackpot.getDatefin().getTime() - g.getTime())/(1000*60*60*24);
	return days;
	
}










}
