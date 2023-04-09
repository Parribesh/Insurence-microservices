package com.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.domain.Message;
import com.crm.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired MessageRepository messageRepo;
	
	@Override
	public Message createMessage(Message m) {
		return messageRepo.save(m);
	}

}
