package org.aptogether.controller;

import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.ComplaintCriteria;
import org.aptogether.domain.ComplaintPageDTO;
import org.aptogether.service.ComplaintService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/tenant/complaint")
@AllArgsConstructor
public class ComplaintController {

	private ComplaintService service;

	@GetMapping("/list")
	public void compList(ComplaintCriteria cri, Model model) {
		log.info("list: " + cri);
		model.addAttribute("list", service.getCompList(cri));
		// model.addAttribute("pageMaker", new ComplaintPageDTO(cri, 123));
		int total = service.getTotalComp(cri);
		log.info("total: " + total);
		model.addAttribute("pageMaker", new ComplaintPageDTO(cri, total));
	}

	@PostMapping("/register")
	public String register(ComplaintVO vo, RedirectAttributes rttr) {
		log.info("register:" + vo);
		service.registerComp(vo);
		rttr.addFlashAttribute("result", vo.getCompbno());
		return "redirect:/tenant/complist";
	}

	@GetMapping("/get")
	public void get(@RequestParam("compbno") Long compbno, Model model) {
		log.info("/compget");
		model.addAttribute("vo", service.getComp(compbno));
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("compbno") Long compbno, @ModelAttribute("cri") ComplaintCriteria cri,
			RedirectAttributes rttr) {
		log.info("remove...." + compbno);
		if (service.removeComp(compbno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getPageNum());
		return "redirect:/tenant/complist";
	}

}
