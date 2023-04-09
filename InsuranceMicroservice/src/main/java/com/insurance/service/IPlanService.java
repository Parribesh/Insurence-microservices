package com.insurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.domain.Insurer;
import com.insurance.domain.Plan;
import com.insurance.modal.DocumentStatusUpdate;
import com.insurance.modal.PlanStatusUpdate;

@Service
public interface IPlanService {
	public Plan createPlan(Plan plan);
	public Plan getPlanById(Long planId);
	public String deletePlan(Long planId);
	public List<Plan> getAllPlans();
	Plan getPlanByInsurer(String email);
	List<Plan> getPendingPlans();
	Plan updateStatus(DocumentStatusUpdate planStatus);
	Plan updatePlanStatus(PlanStatusUpdate planStatus);
}
