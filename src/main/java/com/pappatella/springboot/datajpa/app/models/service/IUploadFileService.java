package com.pappatella.springboot.datajpa.app.models.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public String copy(MultipartFile file) throws IOException;
	
	public boolean delete(String filename);
	
}
