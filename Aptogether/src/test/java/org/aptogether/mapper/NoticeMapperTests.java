package org.aptogether.mapper;

import static org.junit.Assert.*;

import org.aptogether.domain.NoticeVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class NoticeMapperTests {

	@Setter(onMethod_ = @Autowired)
	private NoticeMapper mapper;
	
	
	// @Test
	// public void testGetList() {
	// mapper.getList().forEach(notice -> log.info(notice));
	// }

	
//	  @Test public void testInsert(){
//	  NoticeVO notice = new NoticeVO();
//	  
//	  notice.setTitle("테스트 중입니다"); 
//	  notice.setContent("테스트 내용입니다");
//	  notice.setCategory("일반");
//	 
//	 mapper.insertNotice(notice);
//	  log.info(notice);
//	 }
	 

//	@Test
//	public void testRead() {
//		NoticeVO notice = mapper.readNotice(6);
//		log.info(notice);
//	}

	// @Test
	// public void testDelete(){
	// log.info("Delete count : " + mapper.deleteNotice(6));
	// }

	
//	@Test
//	public void testUpdate(){
//		NoticeVO notice = new NoticeVO();
//		notice.setNoticeSeq(4);
//		notice.setTitle("수정된 제목");
//		notice.setContent("수정된 내용");
//		notice.setCategory("공지");
//		
//		int count = mapper.updateNotice(notice);
//		log.info("update count : " + count);
//	}
	
	
	
}
