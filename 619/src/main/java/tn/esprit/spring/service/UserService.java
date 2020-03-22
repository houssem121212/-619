package tn.esprit.spring.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.UserRepository;


@Service
public class UserService {

	
	
	
	@Autowired
	UserRepository UserRepository;
	
	
public	int somme (Long id){
	
	int s=0 ;

	
	
	{
		
		for(int i=0; i<UserRepository.findByRoles_Id(id).size(); i++)
	 s=s+     UserRepository.findByRoles_Id(id).get(i).getSalary()	;
	        	
		
		
	}
	
	
	return s ;
}
	
}
