package com.insurance.modal;

import com.insurance.domain.DocumentStatusType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentStatusUpdate {
	
	private Long planId;
	private DocumentStatusType status;
}
