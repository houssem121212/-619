package tn.esprit.spring.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Cart;
import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repository.CartRepository;
import tn.esprit.spring.repository.CommandRepository;
import tn.esprit.spring.repository.productRepository;

@Service
public class CommandService implements ICommandService {
	@Autowired
	CartRepository cartRepeository;

	@Autowired
	productRepository productRepository;
	
	@Autowired
	CommandRepository commandRepository;
	
	@Autowired
	CartService cartservice;


	
	//create Commande
	
	@Override
	public String createCommand(Long idCart, String Adresse, int Numero,String commandType) {
		// get cart
				Cart cartManagedEntity = cartRepeository.findById(idCart).get();
				Command commandManagedEntity = new	Command();	
				
				LocalDate today = LocalDate.now();
				List<Product> prodcts = new ArrayList<>();
				
				int employeNb = cartManagedEntity.getProduits().size();
				for (int index = 0; index < employeNb; index++) {
					prodcts.add(cartManagedEntity.getProduits().get(index));
				}
				
				commandManagedEntity.setPrix(cartManagedEntity.getTotal());
				commandManagedEntity.setNumeroCommand(Numero);
				commandManagedEntity.setProduits(prodcts);
				commandManagedEntity.setCommandEtat(false);
				commandManagedEntity.setCommandAdresse(Adresse);
				commandManagedEntity.setCommandDate(today);
				commandManagedEntity.setCommandType(commandType);
				commandRepository.save(commandManagedEntity);
				
				return "command is creatd";
		
	}

	@Override
	public String deleteCommand(Long idCommand) {
		// TODO Auto-generated method stub
		commandRepository.delete(commandRepository.findById(idCommand).get());
		
		return "delete command";
	}

	
	@Override
	public Command searchCommandByNumero(Long numeroCommand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Command> SearchCommandByType(String typeCommand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String UpdateCommandTypeCommande(Long Command, String type) {
		// TODO Auto-generated method stub
		Command cd = commandRepository.findById(Command).get();
		cd.setCommandType(type);

		commandRepository.save(cd);
		return "update quantite";
		
		
	}


	
	
}
