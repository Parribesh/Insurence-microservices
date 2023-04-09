package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.domain.Insurer;
import com.insurance.domain.Plan;
import com.insurance.modal.DocumentStatusUpdate;
import com.insurance.modal.PlanStatusUpdate;
import com.insurance.service.PlanService;

@RestController
public class PlanController {
	
	@Autowired PlanService planService;
	
	@PostMapping("/plan/createPlan")
	public Plan createInsurer(@RequestBody Plan plan) {
		System.out.println(plan);
		return planService.createPlan(plan);
	}
	
	@GetMapping("/plan/getplan/{planId}")
	public Plan getInsurer(@PathVariable Long planId) {
		return planService.getPlanById(planId);
	}
	
	@GetMapping("/plan/getplanByInsurerEmail/{email}")
	public Plan getPlanByInsurer(@PathVariable String email) {
		return planService.getPlanByInsurer(email);
	}
	
	@PostMapping("/plan/deltePlan/{planId}")
	public String deleteInsurer(@PathVariable Long planId) {
		return planService.deletePlan(planId);
	}
	
	@PostMapping("/plan/updatePlan")
	public Plan updatePlan(@RequestBody PlanStatusUpdate planStatus) {
		return planService.updatePlanStatus(planStatus);
	}
	
	@PostMapping("plan/updateDocStatus")
	public Plan updatePlanStatus(@RequestBody DocumentStatusUpdate planStatus) {
		return planService.updateStatus(planStatus);
	}
	
	@GetMapping("/plan/getAllPlans")
	public List<Plan> getAllPlans() {
		return planService.getAllPlans();
	}
	
	@GetMapping("/plan/getPendingPlans")
	public List<Plan> getPendingPlans() {
		return planService.getPendingPlans();
	}
	
}
