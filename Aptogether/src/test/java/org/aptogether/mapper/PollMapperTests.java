package org.aptogether.mapper;

import org.aptogether.domain.PollOptionVO;
import org.aptogether.domain.PollSelectVO;
import org.aptogether.domain.PollVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PollMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private PollMapper mapper;
	
//	@Test
//	public void testPollList(){
//		mapper.PollList().forEach(poll -> log.info(poll));
//	}
	
//	@Test
//	public void testPollInsert(){
//		PollVO poll = new PollVO();
//		
//		poll.setQuestion("새 글");
//		poll.setContents("새 내용");
//		
//		mapper.PollInsert(poll);
//		
//		log.info(poll);
//	}
	
//	@Test
//	public void testPollDetail(){
//		PollVO poll = mapper.PollDetail(20);
//		
//		log.info(poll);
//	}
	
//	@Test
//	public void testPollSelect(){
//		PollSelectVO select = new PollSelectVO();
//		
//		select.setOptionSeq(1);
//		
//		mapper.PollSelectInsert(select);
//
//	}
	
//	@Test
//	public void testPollOptionList(){
//		mapper.PollOptionList(23).forEach(PollOptionVO -> log.info(PollOptionVO));
//	}
	
	

}
