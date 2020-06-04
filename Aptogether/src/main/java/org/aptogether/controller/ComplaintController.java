package org.aptogether.controller;

import org.aptogether.domain.ComplaintVO;

import javax.servlet.http.HttpServletRequest;

import org.aptogether.domain.ComplaintCriteria;
import org.aptogether.domain.ComplaintPageDTO;
import org.aptogether.service.ComplaintService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/tenant/complaint")
@AllArgsConstructor
public class ComplaintController {

	private ComplaintService service;


	/*@GetMapping("/list")
	public void getcompList(ComplaintCriteria cri, Model model) {
		log.info("list: " + cri);
		model.addAttribute("list", service.getComplaintList(cri));
		// model.addAttribute("pageMaker", new ComplaintPageDTO(cri, 123));
		int total = service.getTotalComp(cri);
		log.info("total: " + total);
		model.addAttribute("pageMaker", new ComplaintPageDTO(cri, total));
	}*/

	@PostMapping("/write")
	public String register(ComplaintVO vo, RedirectAttributes rttr, HttpServletRequest request) {
		String test = request.getParameter("comptitle");
		String comptel = request.getParameter("comptel");
		System.out.println(test);
		System.out.println(comptel);
		log.info("register:" + vo);
		System.out.println(vo);
		service.registerComplaint(vo);
		rttr.addFlashAttribute("result", vo.getCompbno());
		System.out.println("여기까지 됨");
		return "redirect:/tenant/complaint/getlist";
	}

	@GetMapping("/get")
	public void get(@RequestParam("compbno") Long compbno, Model model) {
		log.info("/compget");
		model.addAttribute("vo", service.getComplaint(compbno));
	}

	@GetMapping("/select")
	public String complaintMainPage(){
		log.info("select");
		return "complaint_select";
	}

	@GetMapping("/getlist")	
	public String complaintList(ComplaintCriteria cri, Model model) {
		log.info("list: " + cri);
		model.addAttribute("list", service.getComplaintList(cri));
		int total = service.getTotalComp(cri);
		log.info("total:" + total);
		model.addAttribute("pageMaker", new ComplaintPageDTO(cri, total));
		return "complaint_board";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam("compbno") Long compbno, @ModelAttribute("cri") ComplaintCriteria
			cri, RedirectAttributes rttr) {
		log.info("remove...." + compbno);
		System.out.println("여기까지 들어옴");
		if (service.removeComplaint(compbno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
	
		return "redirect:/tenant/complaint/getlist";
	}
}
