package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.Don;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.CommandRepository;
import tn.esprit.spring.repository.DonRepository;
import tn.esprit.spring.repository.UserRepository;


@Service
public class DonService  {

	@Autowired
	DonRepository donRepository;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CommandRepository commandRepository;
	
	
	
	public String ajouterDon (Don don){
		donRepository.save(don);
		return "don sucess";
	}
	

	
	
	public void affecterUserAdon( Long donId, Long IdCommand) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
				Don donManagedEntity = donRepository.findById(donId).get();
				
				
				Command CommandManagedEntity = commandRepository.findById(IdCommand).get();
				
				donManagedEntity.setUser(CommandManagedEntity.getUser());
				
				donRepository.save(donManagedEntity);
		
	}
	
	
	
	public List<Product> getProductByDon(Long donId)
	{
		Don donManagedEntity = donRepository.findById(donId).get();
		
		List<Command> commands=donManagedEntity.getCosmmands();
		
		List<Product> prods = new 	ArrayList<>();
		int taille = commands.size();
		for (int index = 0; index < taille; index++) {
			prods.add((Product) commands.get(index).getProduits());
			
		}
		return prods;
		
		
		
	}
	
	
	
public void deletedonById (Long donId){
		
		Don DonId = donRepository.findById(donId).get();
		
		donRepository.delete(DonId);
	
	}
	


	
	
}
