package org.aptogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.aptogether.domain.Criteria;
import org.aptogether.domain.MarketBoardVO;

public interface MarketBoardMapper {
	
	@Select("select * from market_product")
	public List<MarketBoardVO> getList();
	
	public void insertMarketProduct(MarketBoardVO market);
	
	public List<MarketBoardVO> listMarketProduct();
	
	public MarketBoardVO detailMarketProduct(int seq);
	
	public int deleteMarketProduct(int seq);
	
	public int updateMarketProduct(MarketBoardVO market);
	
	public List<MarketBoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}	
