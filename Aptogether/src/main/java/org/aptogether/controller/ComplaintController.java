package org.aptogether.controller;

import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.Criteria;
import org.aptogether.service.ComplaintService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/tenant/*")
@AllArgsConstructor
public class ComplaintController {
	
	private ComplaintService service;
	
	/*@GetMapping("/complist")
	public void compList(Model model) {
		log.info("list");
		model.addAttribute("list", service.getCompList());
	}
	@PostMapping("/compregister")
	public String register(ComplaintVO vo, RedirectAttributes rttr) {
		log.info("register:" + vo);
		service.registerComp(vo);
		rttr.addFlashAttribute("result", vo.getSeq());
		return "redirect:/tenant/complist";
	}
	@GetMapping("/compget")
	public void get(@RequestParam("seq") Long seq, Model model){
		log.info("/compget");
		model.addAttribute("vo", service.getComp(seq));
	}*/
	/*@PostMapping("/compremove")
	public String remove(@RequestParam("seq") Long seq, RedirectAttributes rttr) {
		log.info("remove...." + seq);
		if (service.remove(seq)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/tenant/complist";
	}*/
	@GetMapping("/complist")
	public void list(Criteria cri, Model model) {
		log.info("list:" + cri);
		model.addAttribute("list", service.getCompList(cri));
	}
}
