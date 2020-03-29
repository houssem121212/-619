package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Don;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.repository.DonRepository;


@Service
public class DonService  {

	@Autowired
	DonRepository donRepository;
	
	
	
	
	
	
	public String ajouterDon (Don don){
		donRepository.save(don);
		return "don sucess";
	}
	

	
	
public void deletedonById (Long donId){
		
		Don DonId = donRepository.findById(donId).get();
		
		donRepository.delete(DonId);
	
	}
	
	
	
}
