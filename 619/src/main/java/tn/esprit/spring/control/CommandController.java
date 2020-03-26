package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.service.CommandService;

@RestController
@RequestMapping("/Command")
public class CommandController {

	@Autowired
	CommandService commandService;
	
	//Add Command
	// http://localhost:8081/SpringMVC/servlet/cart/addtoCart/1/1
    @PutMapping("/addcommand/{idCart}/{Adresse}/{Numero}/{commandType}")
    @PreAuthorize("hasRole('USER')")
    public String addtoCart(@PathVariable("idCart")Long idCart,@PathVariable("Adresse") String Adresse,@PathVariable("Numero") int Numero,@PathVariable("commandType")String commandType) {
		return commandService.createCommand(idCart,Adresse,Numero, commandType);
    }
    
  //Add Command
  	// http://localhost:8081/SpringMVC/servlet/cart/addtoCart/1/1
      @DeleteMapping("/deleteCommand/{idCommand}")
      @PreAuthorize("hasRole('USER')")
      public String addtoCart(@PathVariable("idCommand")Long idCommand) {
  		return commandService.deleteCommand(idCommand);
      }
      
    //Add Command
    	// http://localhost:8081/SpringMVC/servlet/cart/addtoCart/1/1
        @PostMapping("/updateType/{idCommand}/{type}")
        @PreAuthorize("hasRole('USER')")
        public String updatetYPE(@PathVariable("idCommand")Long idCommand,@PathVariable("type")String type) {
    		return commandService.UpdateCommandTypeCommande(idCommand, type);
        }
        
      
    
}
