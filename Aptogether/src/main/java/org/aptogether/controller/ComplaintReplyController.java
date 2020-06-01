package org.aptogether.controller;

import org.aptogether.domain.ComplaintReplyVO;
import org.aptogether.service.ComplaintReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/tenant/complaintreply/")
@RestController
@Log4j
@AllArgsConstructor
public class ComplaintReplyController {

	private ComplaintReplyService service;

	@PostMapping(value = "/replynew", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> compreplycreate(@RequestBody ComplaintReplyVO vo) {
		log.info("ComplaintReplyVO:" + vo);
		int insertReplyCount = service.registerCompReply(vo);
		log.info("Reply INSERT COUNT:" + insertReplyCount);

		return insertReplyCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/{comprno}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ComplaintReplyVO> getCompReply(@PathVariable("comprno") Long comprno) {
		log.info("get compreply:" + comprno);

		return new ResponseEntity<>(service.getCompReply(comprno), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{comprno}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> compreplyremove(@PathVariable("comprno") Long comprno) {
		log.info("remove:" + comprno);

		return service.removeCompReply(comprno) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
