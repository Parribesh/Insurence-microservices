package com.crm.service;

import java.util.List;

import com.crm.domain.Inquiry;
import com.crm.domain.Message;

public interface InquiryService {
	
	Inquiry createInquiry(Inquiry inquiry);
	Inquiry getInquiryByClaimId(Long claimId);
	List<Message> getMessagesByInquiryId(Long InquiryId);
	List<Inquiry> getAllInquiry();
}
