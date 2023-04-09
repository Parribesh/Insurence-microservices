package com.insurance.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Plan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long planId;
	@Enumerated
	private PlanType planType;

	@OneToOne()
	@JoinColumn(name="insurerId")
	private Insurer insurerId;
	
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private double monthlyPremium;
	
	private StatusType status;
	
	private DocumentStatusType docStatus;
	
	
	
}
