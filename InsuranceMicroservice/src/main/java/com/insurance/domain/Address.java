package com.insurance.domain;



import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address {
	

	private String addressLine1;
	

	private String addressLine2;
	

	private String city;
	

	private String state;

	private String country;
	
	private String zipCode;
	

}