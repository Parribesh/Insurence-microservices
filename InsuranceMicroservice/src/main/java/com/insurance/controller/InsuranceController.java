package com.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.domain.Insurer;
import com.insurance.service.InsurerService;

@RestController
public class InsuranceController {
	
	@Autowired InsurerService insurerService;
	
	@PostMapping("/insurance/createInsurer")
	public Insurer createInsurer(@RequestBody Insurer insurer) {
		System.out.println("Got from gateway: "+ insurer);
		return insurerService.createInsurer(insurer);
	}
	
	@GetMapping("/insurance/getInsurer/{insurerId}")
	public Insurer getInsurer(@PathVariable Long insurerId) {
		return insurerService.getInsurerById(insurerId);
	}
	
	@GetMapping("/insurance/getInsurerByEmail/{insurerEmail}")
	public Insurer getInsurerByEmail(@PathVariable String insurerEmail) {
		return insurerService.getInsurerByEmail(insurerEmail);
	}
	
	@PostMapping("/insurance/delterInsurer/{insurerId}")
	public String deleteInsurer(@PathVariable Long insurerId) {
		return insurerService.deleteInsurer(insurerId);
	}
	

}
