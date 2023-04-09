package com.example.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.client.ClaimClient;
import com.example.service.DocumentService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@CrossOrigin("*")
public class ClaimController {
	
	@Autowired ClaimClient claimClient;
	@Autowired DocumentService docService;
	
	@PostMapping(value="api/claim/createClaim")
	public JsonNode createClaim(@RequestBody JsonNode claim) {
		System.out.println(claim);
//		byte[] file = claim.get("file").asText().getBytes();
//		System.out.println("file: "+ file.length);
//		docService.saveClaimDocs(file, claim.get("planId").asLong());
		return claimClient.createrClaim(claim);
	}
	
	@GetMapping("api/claim/getClaimByEmail/{email}")
	public JsonNode getClaimByEmail(@PathVariable String email) {
		return claimClient.getClaimByEmail(email);
	}
	
	@PostMapping(value="api/claim/upload/{planId}")
	public String upload(@RequestBody MultipartFile file, @PathVariable Long planId) throws IOException {
		System.out.println(file);
		
		if (docService.saveClaimDocs(file.getBytes(), planId).equals("success")) {
			JsonNode claim = claimClient.getClaimByPlanId(planId);
			Long claimId = Long.valueOf(0);
			if(claim != null) {
				claimId = claim.get("claimId").asLong();
			}
			return claimClient.changeClaimDocStatus("RECEIVED", claimId);
		}
		
		return "failure";
	}
	
	@PostMapping(value="api/claim/changeDocStatus/{claimId}")
	public String changeDocStatus(@RequestParam String status, @PathVariable Long claimId) throws IOException {
		
		return claimClient.changeClaimDocStatus(status, claimId );
	}
}
