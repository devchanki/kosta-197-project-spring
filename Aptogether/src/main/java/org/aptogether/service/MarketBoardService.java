package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.Criteria;
import org.aptogether.domain.MarketBoardVO;

public interface MarketBoardService {
	
	public void register(MarketBoardVO market);
	
	public MarketBoardVO get(int seq);

	public boolean modify(MarketBoardVO market);
	
	public boolean remove(int seq);
	
	public List<MarketBoardVO> getlist(Criteria cri, int apt_seq);
	
	public int getTotal(Criteria cri);
	
	
}
