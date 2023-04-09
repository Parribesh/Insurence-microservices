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
public class CRMClient {
	
	public JsonNode createMessage(Long claimId, JsonNode json) {
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);		
			HttpEntity<String> request = new HttpEntity<String>(json.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			System.out.println("from gateway json: "+ json.toPrettyString());
			ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8183/crm/createMessage/"+claimId, request, Object.class);
			Object object = responseEntity.getBody();
			
			ObjectMapper mapper = new ObjectMapper();
			JsonNode output = mapper.convertValue(object, JsonNode.class);
			
			return output;
		}
	
	public JsonNode getAllInquiry() {
		
		RestTemplate restTemplate = new RestTemplate();
	
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8183/crm/getAllInquiry", Object.class);
		Object object = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode output = mapper.convertValue(object, JsonNode.class);
		
		return output;
	
	}
	
	public JsonNode getClaimByClaimId(Long claimId) {
		
		RestTemplate restTemplate = new RestTemplate();
	
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8183/crm/getInquiry/"+claimId, Object.class);
		Object object = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode output = mapper.convertValue(object, JsonNode.class);
		
		return output;
		
	}
}
