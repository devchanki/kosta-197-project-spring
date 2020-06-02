package org.aptogether.service;

import java.util.List;
import java.util.Map;

import org.aptogether.domain.ScheduleVO;
import org.aptogether.mapper.ScheduleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

	@Setter
	private ScheduleMapper mapper;

	// @Override
	// public List<ScheduleVO> listSchedule() {
	// ScheduleVO schedule = new ScheduleVO();
	// log.info("get list..............!");
	// return mapper.listSchedule(1);
	// }

	@Override
	public List<ScheduleVO> listSchedule(int aptSeq) {
		log.info("get list....");
		aptSeq = 1;
		return mapper.listSchedule(aptSeq);
	}

	@Override
	public int insertSchedule(ScheduleVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSchedule(int scheduleSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSchedule(ScheduleVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
