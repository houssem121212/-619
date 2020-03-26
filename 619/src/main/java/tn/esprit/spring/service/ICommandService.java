package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.ChargeRequest;
import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.email;

public interface ICommandService {

	String createCommand(Long idCart, String Adresse, int Numero, String commandType);

	String deleteCommand(Long idCommand);

	

	Command searchCommandByNumero(Long numeroCommand);

	List<Command> SearchCommandByType(String typeCommand);

	String UpdateCommandTypeCommande(Long Command,String type);
	
}
