package org.aptogether.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedule/*")
public class ExController {
	
	@GetMapping("/tenant/scheduleApt")
	public String schedule(){
		
		return "schedule";
	}

}
