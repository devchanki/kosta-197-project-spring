package org.aptogether.service;

import static org.junit.Assert.assertNotNull;

import org.aptogether.domain.MarketBoardVO;
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
public class MarketBoardServiceTests {
	
	@Setter(onMethod_=@Autowired)
	private MarketBoardService service;
	
//	@Test
//	public void testExist(){
//		log.info(service);
//		assertNotNull(service);
//	}
//	
//	@Test
//	public void testRegister(){
//
//		MarketBoardVO market=new MarketBoardVO();
//		market.setSeq(3);
//		market.setWriter("c");
//		market.setProductName("c");
//		market.setContents("c");
//		market.setPrice(1200);
//		market.setIsSale("o");
//		market.setFname("c");
//		
//		service.register(market);
//		
//		log.info("생성된 게시물의 번호:"+market.getSeq());
//	}
//	
	@Test
	public void testGetList(){
		service.getlist().forEach(market->log.info(market));
	}
	
	@Test
	public void testGet(){
	log.info(service.get(1));
	}
	
	@Test
	public void testDelete(){
		log.info(service.remove(3));
	}
	@Test
	public void testUpdate(){
		MarketBoardVO market=service.get(2);
		if(market==null){
			return;
		}
		market.setContents("내용수정했당");
		log.info(service.modify(market));
	}
	
	
	
}
