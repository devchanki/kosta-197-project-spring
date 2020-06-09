package org.aptogether.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.aptogether.domain.Criteria;
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

	private int[] seqArr={380,381,382,383,384};
	
	@Setter(onMethod_=@Autowired)
	private MarketReplyMapper mapper;
	
/*	@Test
	public void testCreate(){
		IntStream.rangeClosed(1,10).forEach(i->{MarketReplyVO vo=new MarketReplyVO();
		vo.setSeq(seqArr[i%5]);
		vo.setReplyWriter("writer"+i);
		vo.setReplyContents("댓글"+i);
		
		
		mapper.marketReplyInsert(vo);
		
		});
	}
	@Test
	public void testMapper(){
		log.info(mapper);
	}
	*/
	
	/*@Test
	public void testRead(){
		int target_Reply_no=24;
		MarketReplyVO vo=mapper.marketReplyRead(target_Reply_no);
		log.info(vo);
	}*/
	
/*	@Test
	public void testDelete(){
		int target_Reply_no=2;
		mapper.marketReplyDelete(target_Reply_no);
	}*/
	
	/*@Test
	public void testupdate(){
		int target_Reply_no=24;
		MarketReplyVO vo=mapper.marketReplyRead(target_Reply_no);
		vo.setReplyContents("update되었습니다.");
		int count=mapper.marketReplyUpdate(vo);
		log.info("update count 업데이트 카운트:"+count);
	}*/
	
	@Test
	public void testList(){
	Criteria cri=new Criteria();
	List<MarketReplyVO> replies=mapper.getListWithPaging(cri,seqArr[0]);
	replies.forEach(reply->log.info(reply));
	}
	
}
