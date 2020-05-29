package org.aptogether.mapper;

import org.aptogether.domain.ComplaintVO;
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
public class ComplaintMapperTests {
@Setter(onMethod_= @Autowired)
private ComplaintMapper mapper;

@Test
public void testGetList(){
	mapper.compList().forEach(board -> log.info(board));
}
@Test 
public void testInsert(){
	ComplaintVO board = new ComplaintVO();
	board.setTitle("테스팅 제목");
	board.setContent("테스트 내용");
	board.setEmail("fff@naver.com");
	mapper.insert(board);
	
	log.info(board);
}
}
