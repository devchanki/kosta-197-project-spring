package org.aptogether.service;

import static org.junit.Assert.*;

import org.aptogether.domain.NoticeCriteria;
import org.aptogether.domain.NoticeVO;
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
public class NoticeServiceTests {

	@Setter(onMethod_=@Autowired)
	private NoticeService service;
	
	
	@Test
	public void test() {
		log.info(service);
		assertNotNull(service);
	}

	
//	@Test
//	public void testRegister(){
//		NoticeVO notice = new NoticeVO();
//		notice.setTitle("새로운 제목이다 어쩔래");
//		notice.setContent("새로운 내용이다 어절래");
//		notice.setCategory("공지");
//		service.register(notice);
//		log.info("생성된 게시물의 번호: "+ notice.getNoticeSeq());
//	}
	
	@Test
	public void testGetList(){
		service.getList(new NoticeCriteria(2,10)).forEach(notice -> log.info(notice));
	}
	
//	@Test
//	public void testGet(){
//		log.info(service.get(2));
//	}
//
//	@Test
//	public void testDelete(){
//		log.info("REMOVE RESULT : " + service.remove(2));
//	}
//	
//	@Test
//	public void testUpdate(){
//		
//		NoticeVO notice = service.get(4);		
//		if (notice == null){
//			return;
//		}
//	
//		notice.setTitle("제목 수정합니다");
//		log.info("MODIFY RESULT: " + service.modify(notice));
//	}
	

	
}
