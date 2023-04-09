package com.claim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claim.domain.Claim;

@Service
public interface ClaimService {
	
	Claim createClaim(Claim claim);
	Claim getClaimById(Long claimId);
	List<Claim> getAllClaim();
	String deleteClaim(Long claimId);
	String updateClaim(Long claimId, String status);
	Claim getClaimByEmail(String email);
	Claim getClaimByPlanId(Long planId);
	
}
