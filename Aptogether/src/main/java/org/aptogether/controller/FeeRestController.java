package org.aptogether.controller;

import java.util.List;

import org.aptogether.domain.FeeVO;
import org.aptogether.domain.LevyVO;
import org.aptogether.domain.TenantVO;
import org.aptogether.service.FeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	

/*	@GetMapping(value = "/findMember", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void findMember(Model model, MemberVO user){
		
		model.addAttribute("member", service.findMember(user));
	}*/
	
	
//	@GetMapping(value = "/listFee/{memberSeq}",
//						   produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
//	public ResponseEntity<List<FeeVO>> listFee(@PathVariable("memberSeq") int memberSeq){
//		
//		MemberVO user = new MemberVO();
//		
//		user.setMemberSeq(memberSeq);
//		user.setAptSeq(6);
//		
//		return new ResponseEntity<>(service.listFee(user), HttpStatus.OK);
//	}
	
	
	@PostMapping(value = "/insertFee", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE} )
	public ResponseEntity<String> insertFee(@RequestBody FeeVO fee){
		log.info("FeeVO : " + fee);
		
		int insertCount = service.insertFee(fee);
		
		log.info("Insert Fee COUNT : " + insertCount);
		
		return insertCount == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
