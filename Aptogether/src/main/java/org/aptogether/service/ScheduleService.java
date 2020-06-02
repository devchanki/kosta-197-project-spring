package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.ScheduleVO;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;


public interface ScheduleService {

	public List<ScheduleVO> listSchedule(int aptSeq);
	public int insertSchedule(ScheduleVO vo);
	public int deleteSchedule(int scheduleSeq);
	public int updateSchedule(ScheduleVO vo);
}
