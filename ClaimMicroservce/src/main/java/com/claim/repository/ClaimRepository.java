package com.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claim.domain.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

	Claim findByInsurerEmail(String email);

	Claim findByPlanId(Long planId);

}
