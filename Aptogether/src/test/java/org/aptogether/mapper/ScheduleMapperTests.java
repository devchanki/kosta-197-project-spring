package org.aptogether.mapper;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.aptogether.domain.ScheduleVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ScheduleMapperTests {

	
	@Setter(onMethod_ = @Autowired)
	private ScheduleMapper mapper;

	@Test
	public void testGetList() {
		int targetSeq = 1;
		mapper.listSchedule(targetSeq).forEach(schedule -> log.info(schedule));
	}
	
//	@Test
//	public void testInsertSchedule(){
//	
//		IntStream.range(1,5).forEach(i->{
//			ScheduleVO vo = new ScheduleVO();
//
//			vo.setContents("test"+i);
//			vo.setStartDate("2020/02/01 12:12");
//			vo.setEndDate("2020/03/03 12:16");
//			vo.setAptSeq(1);
//			vo.setTitle("test title" + i);
//			vo.setBackgroundColor("#wqe21");
//			vo.setDong("201");
//			
//			mapper.insertSchedule(vo);
//		});
//			
//	}
//
//	@Test
//	public void testDelete(){
//		int targetSeq = 1;
//		mapper.deleteSchedule(targetSeq);
//	}
//	
//	@Test
//	public void testUpdate(){
//
//		ScheduleVO vo = new ScheduleVO();
//		vo.setScheduleSeq(139);
//		vo.setTitle("수정 했음");
//		vo.setContents("나도 수정");
//		vo.setStartDate("2020/01/01 12:13");
//		vo.setEndDate("2020/02/17 02:17");
//		vo.setDong("233");
//		vo.setBackgroundColor("#qwe2123");
//		mapper.updateSchedule(vo);
//		
//	}
	
}
