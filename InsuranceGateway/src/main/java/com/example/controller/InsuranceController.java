package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.client.InsuranceClient;
import com.fasterxml.jackson.databind.JsonNode;

@Controller
@CrossOrigin("http://localhost:3000")
public class InsuranceController {
	
	@Autowired InsuranceClient insuranceClient;

	@GetMapping({"/", "index"})
	public String getHome() {
		return "index";
	}
	
	@GetMapping("/blog")
	public String getBlogs() {
		return "blog";
	}
	
	@GetMapping("/blog-details")
	public String getDetails() {
		return "blog-details";
	}
	
	@GetMapping("/contact-us")
	public String getContact() {
		return "contact-us";
	}
	
	@PostMapping("")
	@ResponseBody
	public String getQuote(JsonNode json) {
		return "success";
	}
	
	@PostMapping("/api/insurance/createInsurer")
	@ResponseBody
	public JsonNode createInsurer(@RequestBody JsonNode json) {
		
		return insuranceClient.createrInsurer(json);
	}
	
	@GetMapping("/api/insurance/getPlanByEmail/{email}")
	@ResponseBody
	public JsonNode getPlanByEmail(@PathVariable String email) {
		JsonNode json = insuranceClient.getPlanByEmail(email);
		return json;
	}
	
	@GetMapping("/api/insurance/getInsurerByEmail/{email}")
	@ResponseBody
	public JsonNode getInsurerByEmail(@PathVariable String email) {
		JsonNode json = insuranceClient.getInsurerByEmail(email);
		return json;
	}
	
}
