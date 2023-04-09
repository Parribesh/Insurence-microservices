package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.Insurer;
import com.insurance.domain.Plan;
import com.insurance.domain.StatusType;
import com.insurance.modal.DocumentStatusUpdate;
import com.insurance.modal.PlanStatusUpdate;
import com.insurance.repository.InsurerRepository;
import com.insurance.repository.PlanRepository;

@Service
public class PlanService implements IPlanService {
	
	@Autowired PlanRepository planRepo;
	@Autowired InsurerRepository insurerRepo;

	@Override
	public Plan createPlan(Plan plan) {
		return planRepo.save(plan);
	}

	@Override
	public Plan getPlanById(Long planId) {
		return planRepo.findById(planId).orElse(null);
	}

	@Override
	public String deletePlan(Long planId) {
		return "success";
	}

	@Override
	public List<Plan> getAllPlans() {
		return planRepo.findAll();
	}
	
	
	@Override
	public Plan getPlanByInsurer(String email) {
		return planRepo.findByInsurerId_InsurerEmail(email);
	}
	
	
	@Override
	public List<Plan> getPendingPlans() {
		// TODO Auto-generated method stub
		List<Plan> allPlans = planRepo.findAll();
		List<Plan> pending = allPlans.stream().filter(e -> e.getStatus().equals(StatusType.PENDING)).toList();
		return pending;
	}
	
	@Override
	public Plan updateStatus(DocumentStatusUpdate planStatus) {
		Plan p = planRepo.findById(planStatus.getPlanId()).orElse(null);
		if(p != null) {
			p.setDocStatus(planStatus.getStatus());
		}
		return planRepo.save(p);
	}

	@Override
	public Plan updatePlanStatus(PlanStatusUpdate planStatus) {
		Plan p = planRepo.findById(planStatus.getPlanId()).orElse(null);
		if(p != null) {
			p.setStatus(planStatus.getStatus());
		}
		return planRepo.save(p);
	}

}
