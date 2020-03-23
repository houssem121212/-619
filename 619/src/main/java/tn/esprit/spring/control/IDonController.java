package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import tn.esprit.spring.entities.Don;

import tn.esprit.spring.service.IDonService;

@Controller
public class IDonController {
	
@Autowired
	private IDonService iDonService;

public String ListDon (List<Don> Dons){
	return null;
	
	
}
}
