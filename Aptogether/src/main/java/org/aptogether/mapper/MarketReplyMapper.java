package org.aptogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.aptogether.domain.Criteria;
import org.aptogether.domain.MarketReplyVO;

public interface MarketReplyMapper {
	public int marketReplyInsert(MarketReplyVO vo);
	
	public MarketReplyVO marketReplyRead(int replyNo);

	public int marketReplyDelete(int replyNo);
	
	public int marketReplyUpdate(MarketReplyVO vo);
	
	public List<MarketReplyVO> getListWithPaging(@Param("cri") Criteria cri,@Param("seq") int seq);
	
	
}
