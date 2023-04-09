package com.example.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service 
public class DocumentServiceImpl implements DocumentService {


	@Autowired private HttpServletRequest request;
	
	@Override
	public String savePlanDocs(byte[] file, Long planId) {
//		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		String contextPath = (request.getServletContext().getRealPath("/uploads/"));
		String filePath = contextPath + "/"+ planId+"/";
				
		File uploadPath = new File(filePath);
		
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		
		
		try {
			
//			String extension = FilenameUtils.getExtension(file.getOriginalFilename());
					
			byte[] bytes = file;
			Path path = Paths.get(filePath + "file."+"png");
//			Path path = Paths.get("uploads/" + file.getOriginalFilename() );
			Files.write(path, bytes);

		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}

	@Override
	public String saveClaimDocs(byte[] file, Long planId) {
		String contextPath = (request.getServletContext().getRealPath("/uploads/"));
		String filePath = contextPath + "/"+ planId+"/";
				
		File uploadPath = new File(filePath);
		
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		
		
		try {
			
			byte[] bytes = file;
			Path path = Paths.get(filePath + "claim_file."+"png");
//			Path path = Paths.get("uploads/" + file.getOriginalFilename() );
			Files.write(path, bytes);

		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}

}
