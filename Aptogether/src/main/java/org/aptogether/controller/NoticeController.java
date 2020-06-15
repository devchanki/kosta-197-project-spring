package org.aptogether.controller;

import org.aptogether.domain.NoticeVO;
import org.aptogether.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/keeper/*")
@AllArgsConstructor
public class NoticeController {

	private NoticeService service;
	
	@GetMapping("/listNotice")
	public String list(Model model){
		log.info("list");
	model.addAttribute("list", service.getList());	
	log.info(model);

	return "/listNotice";
	}
	
	@GetMapping("/registerNotice")
	public String registerNotice(){
		return "/registerNotice";
	}
	
	@PostMapping("/registerNotice")
	public String register(NoticeVO notice, RedirectAttributes rttr){
		log.info("register : " + notice);
		service.register(notice);
		
		rttr.addFlashAttribute("result", notice.getNoticeSeq());
		return "redirect:/keeper/listNotice";
	}

	
	@GetMapping("/getNotice")
	public String get(@RequestParam("noticeSeq")int noticeSeq, Model model){
		log.info("/get");
		
		model.addAttribute("notice", service.get(noticeSeq));	
		return "/getNotice";
	}
	
	@GetMapping("/modifyNotice")
	public String modify(@RequestParam("noticeSeq")int noticeSeq, Model model){
		log.info("/get");
		
		model.addAttribute("notice", service.get(noticeSeq));	
		return "/modifyNotice";
	}
	
	@PostMapping("/modifyNotice")
	public String modify(NoticeVO notice, RedirectAttributes rttr){
		log.info("modify: " + notice);
	
		if(service.modify(notice)){
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/keeper/listNotice";
	}
	
	@PostMapping("/removeNotice")
	public String remove(@RequestParam("noticeSeq")int noticeSeq, RedirectAttributes rttr){
		log.info("remove....." + noticeSeq);
		
		if(service.remove(noticeSeq)){
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/keeper/listNotice";
	}
	
	

}
