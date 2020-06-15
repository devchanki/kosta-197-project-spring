package org.aptogether.controller;

import java.util.List;

import org.aptogether.domain.LevyVO;
import org.aptogether.domain.UnitPriceVO;
import org.aptogether.service.LevyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class LevyRestController {
	
	private LevyService service;
	
	
	@PostMapping(value = "/addLevy", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> addLevy(@RequestBody LevyVO levy){
		log.info("LevyVO : " + levy);
		
		int insertCount = service.addLevy(levy);
		
		log.info("Levy Add COUNT : " + insertCount);
		
		return insertCount == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/listLevy/{aptSeq}",
	   produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<LevyVO>> listLevy(@PathVariable("aptSeq") int aptSeq){
		
		LevyVO levy = new LevyVO();
		
		levy.setAptSeq(aptSeq);
		
		return new ResponseEntity<>(service.listLevy(levy), HttpStatus.OK);
		}
	
	@GetMapping(value = "/findUnitPriceSeq/{levyDate}",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE } )
	public ResponseEntity<UnitPriceVO> findUnitPriceSeq(@PathVariable("levyDate") String levyDate ){
		
		return new ResponseEntity<>(service.findUnitPriceSeq(levyDate), HttpStatus.OK);
	}
	
}
