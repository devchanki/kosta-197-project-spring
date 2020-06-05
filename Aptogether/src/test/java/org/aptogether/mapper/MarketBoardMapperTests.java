package org.aptogether.mapper;

import java.util.List;

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
public class MarketBoardMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private MarketBoardMapper mapper;
	
	/*
	 *
	 * @Test
	public void testGetList(){
	 mapper.getList().forEach(board->log.info(board));
	}*/
	
	/*
	//게시물 삽입테스트
	@Test
	public void testinsert(){
		MarketBoardVO market=new MarketBoardVO();
		market.setWriter("a");
		market.setProductName("a");
		market.setContents("a");
		market.setPrice(1200);
		market.setIsSale("o");
		market.setFname("a");
		mapper.insertMarketProduct(market);
		log.info(market);
	}*/
	
	/*
	//게시물 리스트 테스트
	@Test
	public void testlist(){
		List<MarketBoardVO> list=mapper.listMarketProduct();
		log.info(list);
	}
	*/
	
	/*
	//디테일 테스트
	@Test
	public void testdetail(){
		MarketBoardVO page=mapper.detailMarketProduct(2);
		log.info(page);
	}
	*/
	
	/*
	//게시물 지우기
	@Test
	public void testdelete(){
		log.info("delete되었습니다.");
		mapper.deleteMarketProduct(2);
		List<MarketBoardVO> list=mapper.listMarketProduct();
		log.info(list);
	}
	*/
	
	/*
	//게시물 변경
	@Test
	public void testupdate(){
		
		MarketBoardVO market=new MarketBoardVO();
		market.setSeq(3);
		market.setWriter("b");
		market.setProductName("b");
		market.setContents("b");
		market.setPrice(1200);
		market.setIsSale("o");
		market.setFname("b");
		log.info("update되었습니다.");
		mapper.updateMarketProduct(market);
		List<MarketBoardVO> list=mapper.listMarketProduct();
		log.info(list);
	}*/
	
	
	
	
	
	
	
}
