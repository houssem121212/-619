package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.service.CommandService;

@RestController
@RequestMapping("/Command")
public class CommandController {

	@Autowired
	CommandService commandService;
	
	//Add Command
	// http://localhost:8081/SpringMVC/servlet/Command/addcommand/1/1/1/karim
    @PutMapping("/addcommand/{idCart}/{Adresse}/{Numero}/{commandType}")
    @PreAuthorize("hasRole('USER')")
    public String addtoCart(@PathVariable("idCart")Long idCart,@PathVariable("Adresse") String Adresse,@PathVariable("Numero") int Numero,@PathVariable("commandType")String commandType) {
		return commandService.createCommand(idCart,Adresse,Numero, commandType);
    }
    
  //Add Command
  	// http://localhost:8081/SpringMVC/servlet/Command/deleteCommand/1
      @DeleteMapping("/deleteCommand/{idCommand}")
      @PreAuthorize("hasRole('USER')")
      public String addtoCart(@PathVariable("idCommand")Long idCommand) {
  		return commandService.deleteCommand(idCommand);
      }
      
    //Add Command
    	// http://localhost:8081/SpringMVC/servlet/Command/addtoCart/updateType/1/Jackpot
        @PostMapping("/updateType/{idCommand}/{type}")
        @PreAuthorize("hasRole('USER')")
        public String updatetYPE(@PathVariable("idCommand")Long idCommand,@PathVariable("type")String type) {
    		return commandService.UpdateCommandTypeCommande(idCommand, type);
        }
        
        
        
        //Add all the product in the card to the                                                                                                                                                             Command
        	// http://localhost:8081/SpringMVC/servlet/Command/getProductByIDCommand/1
            @GetMapping("/getProductByIDCommand/{idCommand}")
            @PreAuthorize("hasRole('USER')")
            public List<Product> getProductByIDCommand(@PathVariable("idCommand")Long idCommand) {
        		return commandService.searchCommandByNumero(idCommand);
            }
            
            
          //get all the command with the type = x                                                                                                                                                            Command
        	// http://localhost:8081/SpringMVC/servlet/Command/getCommandByType/karim
            @GetMapping("/getCommandByType/{type}")
            @PreAuthorize("hasRole('USER')")
            public List<Command> getCommandByType(@PathVariable("type")String type) {
        		return commandService.SearchCommandByType(type);
            }
      
    
}
