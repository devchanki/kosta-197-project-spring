package org.aptogether.controller;

import org.aptogether.service.FeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/keeper1/*")
public class FeeController {
	
	private FeeService service;

	@GetMapping("/manager")
	public String managerDashBoard(){
		return "managerDashBoard";
	}
	
	@GetMapping("/levyRegister/{aptSeq}")
	public String levyRegister(@PathVariable("aptSeq") int aptSeq){
		
		return "levyRegister";
	}
	
	@GetMapping("/feeRegister/{levyDateNum}")
	public String feeRegister(@PathVariable("levyDateNum") String levyDateNum){
		
		return "feeRegister";
	}

}
