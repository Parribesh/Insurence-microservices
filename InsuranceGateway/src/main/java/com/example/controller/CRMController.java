package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.CRMClient;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@CrossOrigin("*")
public class CRMController {
	
	@Autowired CRMClient crmClient;
	
	@PostMapping("/api/crm/createInquiry/{claimId}")
	public JsonNode createInquiry(@PathVariable Long claimId, @RequestBody JsonNode node) {
		return crmClient.createMessage(claimId, node);
	}
	
	@GetMapping("/api/crm/getInquiryByClaimId/{claimId}")
	public JsonNode getInquiryByClaimId(@PathVariable Long claimId) {
		return crmClient.getClaimByClaimId(claimId);
	}
	
	@GetMapping("api/crm/getAllInquiry")
	public JsonNode getAllInquirty() {
		return crmClient.getAllInquiry();
	}
}
