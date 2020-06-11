package org.aptogether.controller;

import org.aptogether.domain.CustomUser;
import org.aptogether.service.ScheduleService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/keeper/*")
public class ScheduleKeeperController {
	
	private ScheduleService service;
	
	@GetMapping("/scheduleKeeper")
	public String keeper_Schedule(Model model, Authentication auth){
	
		log.info("admit list");
		CustomUser user = (CustomUser) auth.getPrincipal();
		System.out.println(user.getName());
		int aptSeq =	user.getAptSeq();
		System.out.println(aptSeq);
		
		model.addAttribute("list", service.listSchedule(aptSeq, "0"));
		return "scheduleKeeper";
	}

	}


