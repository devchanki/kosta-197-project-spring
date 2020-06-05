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
	//�Խù� �����׽�Ʈ
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
	//�Խù� ����Ʈ �׽�Ʈ
	@Test
	public void testlist(){
		List<MarketBoardVO> list=mapper.listMarketProduct();
		log.info(list);
	}
	*/
	
	/*
	//������ �׽�Ʈ
	@Test
	public void testdetail(){
		MarketBoardVO page=mapper.detailMarketProduct(2);
		log.info(page);
	}
	*/
	
	/*
	//�Խù� �����
	@Test
	public void testdelete(){
		log.info("delete�Ǿ����ϴ�.");
		mapper.deleteMarketProduct(2);
		List<MarketBoardVO> list=mapper.listMarketProduct();
		log.info(list);
	}
	*/
	
	/*
	//�Խù� ����
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
		log.info("update�Ǿ����ϴ�.");
		mapper.updateMarketProduct(market);
		List<MarketBoardVO> list=mapper.listMarketProduct();
		log.info(list);
	}*/
	
	
	
	
	
	
	
}
