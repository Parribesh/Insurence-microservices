package com.insurance.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Insurer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long insurerId;
	

	private String insurerFirstName;
	

	private String insurerLastName;

	private String insurerGender;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate insurerDOB;
	
	private String insurerMobileNumber;
	
	private String insurerEmail;
	
	@Embedded
	private Address insurerAddress;
	
	private  String insurerLiscence;
	
	private  String insurerPlanType;
	
	
}
