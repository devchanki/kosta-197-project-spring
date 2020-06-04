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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping(value = "/tenant/listSchedule/{aptSeq}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
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

	@PostMapping(value="/tenant/insertSchedule", consumes="application/json", produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public String createSchedule(@RequestBody ScheduleVO vo){
		log.info("scheduleVO: " + vo);
		int insertCount = service.insertSchedule(vo);
		JsonObject obj = new JsonObject();	//status -> 하기위해 Jsonobj를 만들어줌
		Gson gson = new Gson(); //Json 형태로 뿌려줘야해 왜냐면 text라서 json을 못 가져와! 

		if(insertCount == 1 )
				obj.addProperty("status", "true");
		else
				obj.addProperty("status", "false");
		return gson.toJson(obj);
	}
	
	
	@DeleteMapping(value="/tenant/{scheduleSeq}", 
									produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public String deleteSchedule(@PathVariable("scheduleSeq")int scheduleSeq){
		log.info("schedule delete: "+ scheduleSeq);
		int seq = service.deleteSchedule(scheduleSeq);
		JsonObject obj = new JsonObject();
		Gson gson = new Gson(); 
		
		if (seq ==1)
			obj.addProperty("status", "true");
		else
			obj.addProperty("status", "false");
		
		return gson.toJson(obj);
				
	}
	
	@RequestMapping(method={RequestMethod.PUT, RequestMethod.PATCH},
			value="/tenant/{scheduleSeq}",  consumes="application/json", produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public String updateSchedule( @RequestBody ScheduleVO vo, @PathVariable("scheduleSeq")int scheduleSeq){
		log.info("schedule update seq :" + scheduleSeq);
		
		vo.setScheduleSeq(scheduleSeq);
		log.info("schedule update : "+ vo);
		int modify = service.updateSchedule(vo);
		
		JsonObject obj = new JsonObject();
		Gson gson = new Gson(); 

		if(modify == 1 )
				obj.addProperty("status", "true");
		else
				obj.addProperty("status", "false");
		return gson.toJson(obj);	
	}
	

}