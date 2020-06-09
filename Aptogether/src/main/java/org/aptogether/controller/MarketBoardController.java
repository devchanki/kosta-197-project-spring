package org.aptogether.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/tenant/market/*")
@Log4j
@AllArgsConstructor
public class MarketBoardController {
	
	private MarketBoardService service;

	@RequestMapping("/insertform")
	public String insert(){
		log.info("insertform����");
		return "marketinsertform";
	}
//	@RequestMapping("/list")
//	public String list(Model model){
//		log.info("list����");
//		model.addAttribute("list",service.getlist());
//		return "marketlist";
//	}
	@RequestMapping("/list")
	public String list(Criteria cri,Model model){
		log.info("list����"+cri);
		model.addAttribute("list",service.getlist(cri));
		int total=service.getTotal(cri);
		log.info("controller�� ��Ż"+total);
		model.addAttribute("pageMarker", new PageDTO(cri,total));
		return "marketlist";
	}
	@PostMapping("/register")
	public String register(MarketBoardVO market,RedirectAttributes rttr){
		log.info("register����");
		service.register(market);
		rttr.addFlashAttribute("result",market.getSeq());
		return "redirect:/tenant/market/list";
	}
	
	@RequestMapping("/get")
	public String get(@RequestParam("seq") int seq,Model model){
		log.info("get����");
		model.addAttribute("product",service.get(seq));
		return "marketdetail";
	}
	
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	public String modify(MarketBoardVO market,RedirectAttributes rttr){
		log.info("modify����");
		if(service.modify(market)){
			rttr.addFlashAttribute("result","success");	
		}
		
		return "redirect:/tenant/market/list";
	}
	@RequestMapping(value="/modify",method={RequestMethod.GET})
	public String modify(@RequestParam("seq") int seq,Model model){
		model.addAttribute("product",service.get(seq));
		
		return "marketupdate";
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam("seq") int seq,RedirectAttributes rttr){
		log.info("remove����");
		if(service.remove(seq)){
			rttr.addFlashAttribute("result","success");	
		}
		return "redirect:/tenant/market/list";
	}
	
	
	
}
