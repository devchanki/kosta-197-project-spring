package org.aptogether.controller;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.aptogether.domain.ScheduleVO;
import org.aptogether.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/schedule")
@Log4j
public class ScheduleRestController {
	
	@Autowired
	private ScheduleService service;

	@GetMapping(value = "/listSchedule/{aptSeq}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public String showSchedule(@PathVariable("aptSeq") int aptSeq) {
		List<ScheduleVO> list = service.listSchedule(1); 
		Gson gson = new Gson();

//		log.info(gson);

//		Map<String, List> map = new HashMap<String, List>();
//		map.put("schedule", list);
		return gson.toJson(list);
	}

}
