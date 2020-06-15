package org.aptogether.controller;

import java.util.List;

import org.aptogether.domain.PollVO;
import org.aptogether.service.PollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/tenant/*")
@Log4j
@AllArgsConstructor
public class PollTenantRestController {
	
	private PollService  service;
	
	@GetMapping("/pollAllList")
	public @ResponseBody ResponseEntity<List<PollVO>> tenant_List() {
		log.info("list");
		return new ResponseEntity<>(service.PollList(), HttpStatus.OK);
	}
	
	@GetMapping("/pollOnList")
	public @ResponseBody ResponseEntity<List<PollVO>> tenant_OnList(){
		log.info("OnList");
		return new ResponseEntity<>(service.PollOnList(), HttpStatus.OK);
		
	}
	
	@GetMapping("/pollEndList")
	public @ResponseBody ResponseEntity<List<PollVO>> tenant_EndList() {
		log.info("EndList");
		return new ResponseEntity<>(service.PollEndList(), HttpStatus.OK);
	}

}
