package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.Insurer;
import com.insurance.repository.InsurerRepository;

@Service
public class InsurerService implements IInsurerService {

	@Autowired InsurerRepository insurerRepo;
	
	@Override
	public Insurer createInsurer(Insurer insurer) {
		
		return insurerRepo.save(insurer);
	}

	@Override
	public Insurer getInsurerById(Long insurerId) {
		// TODO Auto-generated method stub
		return insurerRepo.findById(insurerId).orElse(null);
	}

	@Override
	public String deleteInsurer(Long insurerId) {
		// TODO Auto-generated method stub
		
		 insurerRepo.delete(insurerRepo.findById(insurerId).orElse(null));
		 return "success";
	}

	@Override
	public List<Insurer> getAllInsurers() {
		// TODO Auto-generated method stub
		return insurerRepo.findAll();
	}
	
	@Override
	public Insurer getInsurerByEmail(String insurerEmail) {
		// TODO Auto-generated method stub
		System.out.println("hello "+ insurerRepo.findByInsurerEmail(insurerEmail));
		return insurerRepo.findByInsurerEmail(insurerEmail);
	}

}
