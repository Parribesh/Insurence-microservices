package com.insurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.domain.Insurer;

@Service
public interface IInsurerService {
	
	public Insurer createInsurer(Insurer insurer);
	public Insurer getInsurerById(Long insurerId);
	public String deleteInsurer(Long insurerId);
	public List<Insurer> getAllInsurers();
	Insurer getInsurerByEmail(String insurerEmail);
	
}
