package com.example.client;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ClaimClient {
	
	
	public JsonNode createrClaim(JsonNode json) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);		
		HttpEntity<String> request = new HttpEntity<String>(json.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8182/claim/createClaim", request, Object.class);
		Object object = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode output = mapper.convertValue(object, JsonNode.class);
		
		return output;
	}
	
	public JsonNode getClaimByEmail(String email) {
		
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8182/claim/getClaimByEmail/"+email, Object.class);
		Object object = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode output = mapper.convertValue(object, JsonNode.class);
		
		return output;
	
	}
	
	public JsonNode getClaimByPlanId(Long planId) {
		
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8182/claim/getClaimByPlanId/"+planId, Object.class);
		Object object = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode output = mapper.convertValue(object, JsonNode.class);
		
		return output;
	
	}

	public String changeClaimDocStatus(String status, Long claimId) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);		
		HttpEntity<String> request = new HttpEntity<String>(status, headers);
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8182/claim/updateClaimStatus/"+claimId,request, String.class);
		String object = responseEntity.getBody();
		
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode output = mapper.convertValue(object, JsonNode.class);
		
		return object;
		
	}
}
