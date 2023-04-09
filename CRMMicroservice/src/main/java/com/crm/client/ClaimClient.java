package com.crm.client;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ClaimClient {
	

	
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

}
