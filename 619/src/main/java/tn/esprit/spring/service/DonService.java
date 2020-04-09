package tn.esprit.spring.service;


import java.util.ArrayList;
import java.util.Date;
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
import tn.esprit.spring.repository.ProductRepository;
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
	
@Autowired
ProductRepository productRepository;
	
	public String addDon (Don don,Long idUser,Long jackpotId){
		
	
		Date g = new Date();
		g.getTime();
		
	
		
		
		
		Jackpot jackpot = jackpotRepository.findById(jackpotId).get();
		
		if (g.compareTo(jackpot.getDatefin())<0 )
			
		{
		don.setJackpot(jackpot);
		
	//	if (g.compareTo(anotherDate))
		
		
		
		donRepository.save(don);		
		affecterUserAdon(don.getId(),idUser);
		return "don sucess";}
		
		else
		return "no don yet";
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

	
	public int getSumDonbyUser(){
		return donRepository.countByUserID();
	}
	
	
	
	public int countParticipantByJackpot(Long id){
		return donRepository.countParticipantByJackpot(id);
	}
	
	
	
	
	
	
	
	public void affecterUserAdon( Long donId,Long userId) {

				Don don = donRepository.findById(donId).get();
				User user = userRepository.findById(userId).get();
				
				if(don.getUser()==null){
					don.setUser(user);
					donRepository.save(don);
				}
				
		
		
	}
	
	public void affecterdonAJAckpot( Don don,Long jackpotId) {
	//	Don d = new Don ();
		
		
			//	Don don = donRepository.findById(donId).get();
				Jackpot jackpot = jackpotRepository.findById(jackpotId).get();
				
				
					don.setJackpot(jackpot);
					donRepository.save(don);
				
				
		
		
	}
	
	public List <Product> getListDonProduct(Long id){
		List <Product> l= productRepository.getDonProduct(id);
		System.out.println(l);
		return l;
	}
	
	public List<String> getProduct(){
		List<String> l= donRepository.getProduct();
		System.out.println(l);
		return l;
	}
	
	
	
	public float     pourcentageDonByJackpot (Long donId,Long jackpotId ){
		
		Don don = donRepository.findById(donId).get();
		
		don.getMontantdon();
		System.out.println(don);
		Jackpot jackpot = jackpotRepository.findById(jackpotId).get();
		jackpot.getMaxValue();
		System.out.println(jackpot.getMaxValue());
		 float percentage = (float) ((don.getMontantdon() * 100) / jackpot.getMaxValue());
		 
		 if( jackpot.getMaxValue()==0) throw new RuntimeException("maxValue introuvable");
		 return percentage ;
		 
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
	
	
	
	


	}

	


	
	

