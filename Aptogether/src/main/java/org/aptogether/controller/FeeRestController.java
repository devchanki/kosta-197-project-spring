package org.aptogether.controller;

import org.aptogether.domain.UserVO;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/keeper1/*")
@Log4j
@AllArgsConstructor
public class FeeRestController {
	
	private FeeService service;

	@GetMapping(value = "/{aptSeq}/{dong}/{ho}",
						   produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<UserVO> findMember(@PathVariable("aptSeq") int aptSeq,
																			 @PathVariable("dong") String dong,
																			 @PathVariable("ho") String ho){
		
	UserVO user = new UserVO();
		
	user.setAptSeq(aptSeq);
	user.setDong(dong);
	user.setHo(ho);
	
	
	log.info("user : " + user);
	
	return new ResponseEntity<>(service.findMember(user), HttpStatus.OK);
	}
	
}
