package org.aptogether.service;

import static org.junit.Assert.assertNotNull;

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
public class PollServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private PollService service;
	
//	@Test
//	public void testExist(){
//		
//		log.info(service);
//		assertNotNull(service);
//	}
	
//	@Test
//	public void PollInsertTest(){
//		
//		PollVO poll = new PollVO();
//		poll.setQuestion("새 글");
//		poll.setContents("새 내용");
//		
//		service.PollInsert(poll);
//		
//		log.info(poll);
//		
//	}
	
//	@Test
//	public void PollListTest(){
//		service.PollList().forEach(poll -> log.info(poll));
//	}
	
//	@Test
//	public void PollSelectTest(){
//		PollSelectVO select = new PollSelectVO();
//		select.setOptionSeq(1);
//		
//		service.PollSelectInsert(select);
//		log.info(select);
//	}
	
//	@Test
//	public void PollOptionListTest(){
//		service.PollOptionList(23).forEach(PollOptionVO -> log.info(PollOptionVO));
//	}

}
