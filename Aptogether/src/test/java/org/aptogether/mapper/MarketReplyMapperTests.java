package org.aptogether.mapper;

import java.util.stream.IntStream;

import org.aptogether.domain.MarketReplyVO;
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
public class MarketReplyMapperTests {

	private int[] seqArr={42,43};
	
	@Setter(onMethod_=@Autowired)
	private MarketReplyMapper mapper;
	
	@Test
	public void testCreate(){
		IntStream.rangeClosed(0,2).forEach(i->{MarketReplyVO vo=new MarketReplyVO();
		vo.setSeq(seqArr[i%5]);
		vo.setReply_writer("janna");
		vo.setReply_contents("ang");
		
		
		mapper.marketReplyInsert(vo);
		
		});
	}
	@Test
	public void testMapper(){
		log.info(mapper);
	}
	
}
