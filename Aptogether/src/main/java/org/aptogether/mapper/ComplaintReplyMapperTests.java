package org.aptogether.mapper;

import java.util.stream.IntStream;

import org.aptogether.domain.ComplaintReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ComplaintReplyMapperTests {
	
	private Long[] bnoArr = { 310L, 311L, 312L, 313L, 314L};
@Setter(onMethod_= @Autowired)
private ComplaintReplyMapper mapper;

@Test 
public void testMapper() {
	log.info(mapper);
}
/*@Test
public void testCreate(){
	IntStream.rangeClosed(1, 10).forEach(i -> {
		ReplyVO vo = new ReplyVO();
		
		vo.setCompbno(bnoArr[i % 5]);
		vo.setCompreply("´ñ±Û Å×½ºÆ®" + i);
		vo.setCompreplyer("compreplyer" + i);
		
		mapper.insert(vo);
	});
}*/
/*@Test
public void testDelete() {
	Long targetRno = 1L;
	mapper.delete(targetRno);
}*/
@Test
public void testRead() {
	Long targetRno = 5L;
	ComplaintReplyVO vo = mapper.read(targetRno);
	log.info(vo);
}
}
