package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Don;

import tn.esprit.spring.repository.DonRepository;


@Service
public class DonService implements IDonService {

	@Autowired
	DonRepository donRepository;
	
	public float ajouterDon(Don don) {
		donRepository.save(don);
		return don.getMontantDon();
	}
}
