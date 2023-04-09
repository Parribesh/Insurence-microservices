package com.insurance.modal;

import com.insurance.domain.StatusType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanStatusUpdate {
	
	private Long planId;
	private StatusType status;
}
