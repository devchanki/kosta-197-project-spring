package org.aptogether.controller;

import java.util.List;

import org.aptogether.domain.CustomKeeper;
import org.aptogether.domain.FeeRegisterVO;
import org.aptogether.domain.FeeVO;
import org.aptogether.domain.HouseholdVO;
import org.aptogether.domain.LevyVO;
import org.aptogether.domain.MeterVO;
import org.aptogether.domain.UnitPriceVO;
import org.aptogether.service.FeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/keeper/*")
@Log4j
@AllArgsConstructor
public class FeeRestController {
	
	private FeeService service;
	
	@GetMapping(value = "/listDong",
			   produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
			public ResponseEntity<List<HouseholdVO>> listDong(Authentication auth){
				CustomKeeper keeper = (CustomKeeper) auth.getPrincipal();
				keeper.getAptSeq();
				
				HouseholdVO dong = new HouseholdVO();
				
				dong.setAptSeq(keeper.getAptSeq());
				
				return new ResponseEntity<>(service.listDong(dong), HttpStatus.OK);
				}
	
	
	@GetMapping(value = "/listFeeReg/{dong}",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE } )
	public ResponseEntity<List<FeeRegisterVO>> listFeeReg(@PathVariable("dong") int dong){
		
		FeeRegisterVO feeRegister = new FeeRegisterVO();

		feeRegister.setDong(dong);
		
		return new ResponseEntity<>(service.listFeeReg(dong), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/householdInfo",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE } )
	public ResponseEntity<List<HouseholdVO>> householdInfo(Authentication auth){
		
		//HouseholdVO householdInfo = new HouseholdVO();
		
		CustomKeeper keeper = (CustomKeeper) auth.getPrincipal();
		
		//householdInfo.setAptSeq(keeper.getAptSeq());
		
		return new ResponseEntity<>(service.householdInfo(keeper.getAptSeq()), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/levyInfo/{aptSeq}/{levyDate}",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE } )
	public ResponseEntity<LevyVO> levyInfo(@PathVariable("aptSeq") int aptSeq, @PathVariable("levyDate") String levyDate){
		
		

/*		log.info(levyDate);
		CustomKeeper keeper = (CustomKeeper) auth.getPrincipal();
		
		int aptSeq = keeper.getAptSeq();*/
		
		log.info("aptSeq : " + aptSeq + ", levyDate : " + levyDate);

		return new ResponseEntity<>(service.levyInfo(aptSeq, levyDate), HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/addFee", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> addFee(@RequestBody FeeVO fee){
		

		int insertCount = service.addFee(fee);
		
		log.info(" Add COUNT : " + insertCount);
		
		return insertCount == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, value = "/updateFee",
		    consumes= "application/json" ,produces = { MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> updateUnitPrice(@RequestBody FeeVO fee){
	

		
		return service.updateFee(fee) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	

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
	

	
	
}
