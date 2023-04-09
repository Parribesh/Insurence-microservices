package com.claim.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Claim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long claimId;
	
	private String insurerEmail;
	
	private Long planId;
	
	private String insurerName;
	
	private LocalDate incidentDate;
	
	private String status;
	
	private String phone;
	
	private byte[] file;
	
}
