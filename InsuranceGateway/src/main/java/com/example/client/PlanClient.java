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
public class PlanClient {
	
	public JsonNode createPlan(JsonNode json) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);		
		HttpEntity<String> request = new HttpEntity<String>(json.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("from gateway client" + json);
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8181/plan/createPlan", request, Object.class);
		Object object = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode output = mapper.convertValue(object, JsonNode.class);
		
		return output;
	}

	public JsonNode updatePlan(JsonNode json) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);		
		HttpEntity<String> request = new HttpEntity<String>(json.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
	
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8181/plan/updatePlan", request, Object.class);
		Object object = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode output = mapper.convertValue(object, JsonNode.class);
		
		return output;

	}
	
	public JsonNode updateDocStatus(JsonNode json) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);		
		HttpEntity<String> request = new HttpEntity<String>(json.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("from gateway client" + json);
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8181/plan/updateDocStatus", request, Object.class);
		Object object = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode output = mapper.convertValue(object, JsonNode.class);
		
		return output;

	}
	
	public JsonNode getPendingPlans() {
		
		
		RestTemplate restTemplate = new RestTemplate();
	
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8181/plan/getPendingPlans", Object.class);
		Object object = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode output = mapper.convertValue(object, JsonNode.class);
		
		return output;

	}
	
public JsonNode getAllPlans() {
		
		
		RestTemplate restTemplate = new RestTemplate();
	
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8181/plan/getAllPlans", Object.class);
		Object object = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode output = mapper.convertValue(object, JsonNode.class);
		
		return output;

	}

}
