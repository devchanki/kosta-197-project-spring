package org.aptogether.controller;

import org.aptogether.domain.UserVO;
import org.aptogether.service.FeeService;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/keeper1/*")
@Log4j
@AllArgsConstructor
public class FeeRestController {
	
	private FeeService service;

	@GetMapping(value = "/findMember", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void findMember(Model model, UserVO user){
		
		model.addAttribute("member", service.findMember(user));
	}
}
