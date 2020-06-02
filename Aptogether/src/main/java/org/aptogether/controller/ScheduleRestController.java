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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/schedule/*")
@Log4j
public class ScheduleRestController {
	
	@Autowired
	private ScheduleService service;

	@GetMapping(value = "/listSchedule/{aptSeq}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public String showSchedule(@PathVariable("aptSeq") int aptSeq) {
		List<ScheduleVO> list = service.listSchedule(1); 
		
		Gson gson = new Gson();
		JsonArray array = new JsonArray();
		for(ScheduleVO schedule: list){
			JsonObject tmp = new JsonObject();
			tmp.addProperty("_id", schedule.getScheduleSeq());
			tmp.addProperty("title", schedule.getTitle());
			tmp.addProperty("contents", schedule.getContents());
			tmp.addProperty("start", schedule.getStartDate());
			tmp.addProperty("end", schedule.getEndDate());
			tmp.addProperty("allDay", "false");
			tmp.addProperty("dong", schedule.getDong());
			tmp.addProperty("backgroundColor", schedule.getBackgroundColor());
			array.add(tmp);
		}
		return gson.toJson(array);
	}

	@PostMapping(value="/insertSchedule", produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<String> create(@RequestBody ScheduleVO vo){
		log.info("scheduleVO: " + vo);
		int intsertCount = service.insertSchedule(vo);
		
		return intsertCount == 1 
				? new ResponseEntity<>("success", HttpStatus.OK) 
						: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
