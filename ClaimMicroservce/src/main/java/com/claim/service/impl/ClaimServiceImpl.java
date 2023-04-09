package com.claim.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.domain.Claim;
import com.claim.repository.ClaimRepository;
import com.claim.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired ClaimRepository claimRepo;

	@Override
	public Claim createClaim(Claim claim) {
		return claimRepo.save(claim) ;
	
	}

	@Override
	public Claim getClaimById(Long claimId) {
		
		return claimRepo.findById(claimId).orElse(null);
	}

	@Override
	public List<Claim> getAllClaim() {
		return claimRepo.findAll();
	}

	@Override
	public String deleteClaim(Long claimId) {
		Claim c = claimRepo.findById(claimId).orElse(null);
		if(c != null) {
			claimRepo.delete(c);
			return "success" ;
		}
		return "failure";
	}

	@Override
	public String updateClaim(Long claimId, String status) {
		Claim c = claimRepo.findById(claimId).orElse(null);
		c.setStatus(status);
		claimRepo.save(c);
		return "success";
	}

	@Override
	public Claim getClaimByEmail(String email) {
		return claimRepo.findByInsurerEmail(email);
	}

	@Override
	public Claim getClaimByPlanId(Long planId) {
		return claimRepo.findByPlanId(planId);
	}

}
