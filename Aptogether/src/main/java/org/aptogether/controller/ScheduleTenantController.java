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
@RequestMapping("/tenant/*")
public class ScheduleTenantController {
	
	private ScheduleService service;
	
	@GetMapping("/tenant/scheduleTenant")
	public String tenant_Schedule(){
		return "scheduleTenant";
	}

	}

