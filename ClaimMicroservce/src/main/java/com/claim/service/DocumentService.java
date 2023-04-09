package com.claim.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface DocumentService {
	
	String saveToDb(MultipartFile file);
}
