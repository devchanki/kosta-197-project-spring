package org.aptogether.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/tenant/upload/*")
public class UploadController {
	/*public void uploadAjax(){
		log.info("upload ajax");
	}*/
	@RequestMapping("/uploadForm")
	public String uploadForm(){
		log.info("upload form");
		return "uploadForm";
	}
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile,Model model){
		String uploadFolder="C://upload";
		for(MultipartFile multipartFile:uploadFile){
			log.info("upload file name:"+multipartFile.getOriginalFilename());
			log.info("upload File Size:"+multipartFile.getSize());
			
			File saveFile=new File(uploadFolder,multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				// TODO: handle exception
				log.error(e.getMessage());
			}
		}
	}
	
}
