package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.PlanClient;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@CrossOrigin("http://localhost:3000")
public class PlanController {
	@Autowired PlanClient planClient; 
	
	@PostMapping("/api/plan/createPlan")
	public JsonNode createPlan(@RequestBody JsonNode json) {
		return planClient.createPlan(json);
	}
	
	@PostMapping("/api/plan/updateStatus")
	public JsonNode updateStatus(@RequestBody JsonNode json) {
		return planClient.updatePlan(json);
	}
	
	@GetMapping("/api/plan/getPendingPlans")
	public JsonNode getPending() {
		return planClient.getPendingPlans();
	}
	
	@GetMapping("/api/plan/getAllPlans")
	public JsonNode getAllPlans() {
		return planClient.getAllPlans();
	}

	@PostMapping("/api/plan/updateDocStatus")
	public JsonNode updateDocStatus(@RequestBody JsonNode json) {
		JsonNode node = planClient.updateDocStatus(json);
		System.out.println("node: "+ node);
		return node;
	}
	
	

}
