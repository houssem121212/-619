package tn.esprit.spring.control;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.service.IProductService;
import tn.esprit.spring.service.JackpotService;


@RestController
@RequestMapping("/api/aymen/jackpot")
public class JackpotController {

	
	
	@Autowired
	JackpotService jackpotService;
	
	

	
	//http://localhost:8081/SpringMVC/servlet/api/aymen/addJackpot
	@PostMapping("/addJackpot")
	@ResponseBody
	public String addJackpot(@RequestBody Jackpot jackpot) {
	
		System.out.println("ddddddddddddddd"+jackpot.toString());
		return jackpotService.addJackpot(jackpot);
	
	}
	
	
	
	
}
