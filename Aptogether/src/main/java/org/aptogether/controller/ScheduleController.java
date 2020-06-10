package org.aptogether.controller;

import org.aptogether.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/schedule/*")
public class ScheduleController {
	
	private ScheduleService service;
	
	@GetMapping("/tenant/scheduleTenant")
	public String tenant_Schedule(){
		return "scheduleTenant";
	}
	
	@GetMapping("/keeper/scheduleKeeper")
	public String keeper_Schedule(Model model){
	
		log.info("list");
		model.addAttribute("list", service.listSchedule(1));
		return "scheduleKeeper";
	}

	}


