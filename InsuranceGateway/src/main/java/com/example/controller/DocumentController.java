package com.example.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.client.ClaimClient;
import com.example.service.DocumentService;
import com.fasterxml.jackson.databind.JsonNode;


@RestController
@CrossOrigin("http://localhost:3000")
public class DocumentController {
	
	@Autowired DocumentService docService;
	@Autowired ClaimClient claimClient;
	

	@PostMapping("api/docs/upload/{planId}")
	public String getDocs(@PathVariable Long planId, @RequestBody MultipartFile file) throws IOException {
		
		return docService.savePlanDocs(file.getBytes(), planId);
	}
	
	
}

