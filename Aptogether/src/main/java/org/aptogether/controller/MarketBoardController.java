package org.aptogether.controller;

import java.io.File;

import org.aptogether.domain.Criteria;
import org.aptogether.domain.MarketBoardVO;
import org.aptogether.domain.PageDTO;
import org.aptogether.service.MarketBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/tenant/*")
@Log4j
@AllArgsConstructor
public class MarketBoardController {
	
	private MarketBoardService service;

	 @PostMapping("/uploadAjaxAction")
	 public void uploadAjaxPost(MultipartFile file) {
		 System.out.println("uploadFile"+ file);
	
	 String uploadFolder = "C://upload";
	
	
//	 for (MultipartFile multipartFile : uploadFile) {
//	
//	 log.info("-------------------------------------");
//	 log.info("Upload File Name: " + multipartFile.getOriginalFilename());
//	 log.info("Upload File Size: " + multipartFile.getSize());
//	
//	 String uploadFileName = multipartFile.getOriginalFilename();
//	
//	 uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") +
//	 1);
//	 log.info("only file name: " + uploadFileName);
//	
//	 File saveFile = new File(uploadFolder, uploadFileName);
//	
//	 try {
//	 multipartFile.transferTo(saveFile);
//	 } catch (Exception e) {
//	 log.error(e.getMessage());
//	 } // end catch
//	
//	 } // end for
//	
	 }
	
	@RequestMapping("/market/insertform")
	public String insert(){
		log.info("insertform실행");
		return "marketinsertform";
	}
	
//	@RequestMapping("/list")
//	public String list(Model model){
//		log.info("list실행");
//		model.addAttribute("list",service.getlist());
//		return "marketlist";
//	}
	
	@RequestMapping("/market/list")
	public String list(Criteria cri,Model model) {
		log.info("list실행" + cri);
		model.addAttribute("list",service.getlist(cri));
		int total=service.getTotal(cri);
		log.info("controller의 토탈"+total);
		model.addAttribute("pageMarker", new PageDTO(cri,total));
		return "marketlist";
	}
	
	@PostMapping("/market/register")
	public String register(MarketBoardVO market,RedirectAttributes rttr) {
		log.info("register실행");
		service.register(market);
		rttr.addFlashAttribute("result",market.getSeq());
		return "redirect:/tenant/market/list";
	}
	
	@RequestMapping("/market/get")
	public String get(@RequestParam("seq") int seq,Model model) {
		log.info("get실행");
		model.addAttribute("product",service.get(seq));
		return "marketdetail";
	}
	
	@RequestMapping(value="/market/modify",method={RequestMethod.POST})
	public String modify(MarketBoardVO market,RedirectAttributes rttr) {
		log.info("modify실행");
		if(service.modify(market)){
			rttr.addFlashAttribute("result","success");	
		}
		return "redirect:/tenant/market/list";
	}
	
	@RequestMapping(value="/market/modify",method={RequestMethod.GET})
	public String modify(@RequestParam("seq") int seq,Model model) {
		model.addAttribute("product",service.get(seq));
		return "marketupdate";
	}
	
	@RequestMapping("/market/remove")
	public String remove(@RequestParam("seq") int seq,RedirectAttributes rttr) {
		log.info("remove실행");
		if(service.remove(seq)){
			rttr.addFlashAttribute("result","success");	
		}
		return "redirect:/tenant/market/list";
	}
	
}
