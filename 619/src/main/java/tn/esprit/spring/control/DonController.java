package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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



//http://localhost:8081/SpringMVC/servlet/api/aymen/ajoutdon
@PostMapping("/ajoutdon")
@ResponseBody
public Don addDon(@RequestBody Don Don) {
	System.out.println(Don.getMontantdon());
	donService.addDon(Don);
	return Don;
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
