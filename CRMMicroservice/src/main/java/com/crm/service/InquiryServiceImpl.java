package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.domain.Inquiry;
import com.crm.domain.Message;
import com.crm.repository.InquiryRepository;

@Service
public class InquiryServiceImpl implements InquiryService {
	
	@Autowired InquiryRepository inquiryRepo;

	@Override
	public Inquiry createInquiry(Inquiry inquiry) {
		return inquiryRepo.save(inquiry);
	}

	@Override
	public Inquiry getInquiryByClaimId(Long claimId) {
		return inquiryRepo.findById(claimId).orElse(null);
	}

	@Override
	public List<Inquiry> getAllInquiry() {
		return inquiryRepo.findAll();
	}

	@Override
	public List<Message> getMessagesByInquiryId(Long InquiryId) {
		Inquiry inq = inquiryRepo.findById(InquiryId).orElse(null);
		if(inq != null) {
			return inq.getMessages();
		}
		return null;
	}

}
