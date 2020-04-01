package tn.esprit.spring.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;

import tn.esprit.spring.entities.Don;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.playod.UserSummary;
import tn.esprit.spring.security.CurrentUser;
import tn.esprit.spring.security.UserPrincipal;
import tn.esprit.spring.service.DonService;
import tn.esprit.spring.service.IDonService;
import tn.esprit.spring.service.UserService;

@RestController
@RequestMapping("/api/aymen")
public class DonController {
	
@Autowired
	private DonService donService;

@Autowired
private UserService userService;


//ajouter un don par user
//http://localhost:8081/SpringMVC/servlet/api/aymen/ajoutdon
@PostMapping("/ajoutdon")
@ResponseBody
public String addDon(@RequestBody Don Don,@CurrentUser UserPrincipal currentUser) {
	//System.out.println(Don.getMontantdon());
	//System.err.println(currentUser.getId());
	donService.addDon(Don,currentUser.getId());
return "Don sucess"+currentUser.getId();
}

//affecter le don a Jackpot 
//http://localhost:8081/SpringMVC/servlet/api/aymen/affecterDonToJackpot
@PostMapping("/affecterDonToJackpot")
@ResponseBody
public String affecterDonToJackpot(@RequestParam("idDon") Long idDon,@RequestParam("jackpotId") long jackpotId) {	
	donService.affecterdonAJAckpot(idDon, jackpotId);
return "Don sucess affected to jackpot ";
}

//http://localhost:8081/SpringMVC/servlet/api/aymen/updateDon
@PutMapping("/updateDon")
@ResponseBody
public Don updateDon(@RequestBody Don Don) {
	System.out.println(Don.getMontantdon());
	donService.updateDon(Don);
	return Don;
}

//URL : http://localhost:8081/SpringMVC/servlet/api/aymen/deletedonById/2
@DeleteMapping("/deletedonById/{idDon}") 
@ResponseBody
public void deletedonById(@PathVariable("idDon")Long DonId) {
	donService.deletedonById(DonId);
	
}

//http://localhost:8081/SpringMVC/servlet/api/aymen/donnor
@GetMapping("/donnor")
@ResponseBody
private Iterable<Don> View() {
return donService.getAllDon();

}


//montant collecter
//http://localhost:8081/SpringMVC/servlet/api/aymen/GetUserMontantDonate
@GetMapping("/GetUserMontantDonate")
public int GetUserMontantDonate(Long id) {
	return donService.getSumDon();	 
	 

}










// http://localhost:8081/SpringMVC/servlet/affecterUserAdon/1/1
@PutMapping(value = "/affecterUserAdon/{userId}/{donid}") 
public void affecterUserAdon(@PathVariable("userId")Long userId, @PathVariable("donid")Long donId) {
	donService.affecterUserAdon(donId, userId);
}



public String ListDon (List<Don> Dons){
	return null;
	
	
}
}
