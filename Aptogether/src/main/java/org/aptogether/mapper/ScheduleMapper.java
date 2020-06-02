package org.aptogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.aptogether.domain.ScheduleVO;

public interface ScheduleMapper {
//	@Select("select * from schedule")
	public ScheduleVO allSchedule(int scheduleSeq);
	public List<ScheduleVO> listSchedule(int aptSeq);
	public int insertSchedule(ScheduleVO vo);
	public int deleteSchedule(int scheduleSeq);
	public int updateSchedule(ScheduleVO vo);
}
