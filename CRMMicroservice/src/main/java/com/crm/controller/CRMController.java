package com.crm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.domain.Inquiry;
import com.crm.domain.Message;
import com.crm.service.InquiryService;
import com.crm.service.MessageService;

@RestController
public class CRMController {
	
	@Autowired InquiryService inquiryService;
	@Autowired MessageService messageService;
	
	@GetMapping("/crm/getInquiry/{claimId}")
	public Inquiry getInquiry(@PathVariable Long claimId) { 
		return inquiryService.getInquiryByClaimId(claimId);
	}
	
	@PostMapping("/crm/createMessage/{claimId}")
	public Inquiry createMessage(@PathVariable Long claimId, @RequestBody Message message) {
		
		if(claimId != null) {
			System.out.println("claimId: "+ claimId);
			Inquiry inq = inquiryService.getInquiryByClaimId(claimId);
			System.out.println("inq: "+ inq);
			if(inq != null) {
				inq.setClaimId(claimId);
				inq.getMessages().add(message);
				messageService.createMessage(message);
			}else {
				List<Message> messages = new ArrayList<>();
				messageService.createMessage(message);
				messages.add(message);
				inq = new Inquiry(null, claimId, messages);
			}
			return inquiryService.createInquiry(inq);
		}else {
			return null;
		}
		
	}
	
	@GetMapping("crm/getAllInquiry")
	public List<Inquiry> getAllInquiry(){
		return inquiryService.getAllInquiry();
	}
}
