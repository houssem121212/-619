package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Don;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.service.DonService;
import tn.esprit.spring.service.IDonService;

@RestController
@RequestMapping("/api/aymen")
public class DonController {
	
@Autowired
	private DonService donService;



@PostMapping("/ajoutdon")
//@PreAuthorize("hasRole('USER')")
@ResponseBody
public String ajouterDon(@RequestBody Don don)
{
	
	return donService.ajouterDon(don);
}





//URL : http://localhost:8081/SpringMVC/servlet/api/aymen/deletedonById/2
@DeleteMapping("/deletedonById/{idDon}") 
@ResponseBody
public void deletedonById(@PathVariable("idDon")Long DonId) {
	donService.deletedonById(DonId);
	
}



// http://localhost:8081/SpringMVC/servlet/affecterUserAdon/1/1
@PutMapping(value = "/affecterUserAdon/{prods}/{donid}") 
public void affecterUserAdon(@PathVariable("prods")Long commandId, @PathVariable("donid")Long donId) {
	donService.affecterUserAdon(donId, commandId);
}



public String ListDon (List<Don> Dons){
	return null;
	
	
}
}
