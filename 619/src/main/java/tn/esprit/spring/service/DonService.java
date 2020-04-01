package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.Don;
import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.CommandRepository;
import tn.esprit.spring.repository.DonRepository;
import tn.esprit.spring.repository.JackpotRepository;
import tn.esprit.spring.repository.UserRepository;


@Service
public class DonService  {

	@Autowired
	DonRepository donRepository;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CommandRepository commandRepository;
	
	@Autowired
	UserService UserService;
	@Autowired
	JackpotRepository jackpotRepository;
	

	
	public Long addDon (Don don,Long idUser){
		donRepository.save(don);		
		affecterUserAdon(don.getId(),idUser);
		return don.getId();
	}
	

		
	

	public long updateDon(Don Don) {
		if (donRepository.findById(Don.getId()).get() != null) {
			donRepository.save(Don);
			return Don.getId();
		}
		return 0;
	}
	
	
public void deletedonById (Long donId){
		
		Don DonId = donRepository.findById(donId).get();
		
		donRepository.delete(DonId);
	
	}
	

	
	public List<Don> getAllDon() {

		return donRepository.findAll();
	}

	
	
	public int getSumDon(){
		return donRepository.countAllDonatedSacks();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	public void affecterUserAdon( Long donId,Long userId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
				Don don = donRepository.findById(donId).get();
				User user = userRepository.findById(userId).get();
				
				if(don.getUser()==null){
					don.setUser(user);
					donRepository.save(don);
				}
				
		
		
	}
	
	public void affecterdonAJAckpot( Long donId,Long jackpotId) {
		
				Don don = donRepository.findById(donId).get();
				Jackpot jackpot = jackpotRepository.findById(jackpotId).get();
				
				if(don.getJackpot()==null){
					don.setJackpot(jackpot);
					donRepository.save(don);
				}
				
		
		
	}
	
	
	
//	public List<Product> getProductByDon(Long donId)
//	{
//		Don donManagedEntity = donRepository.findById(donId).get();
//		
//		List<Command> commands=donManagedEntity.getCosmmands();
//		
//		List<Product> prods = new 	ArrayList<>();
//		int taille = commands.size();
//		for (int index = 0; index < taille; index++) {
//			prods.add((Product) commands.get(index).getProduits());
//			
//		}
//		return prods;
//					
//	}
//	
	
	
	
	

	


	
	
}
