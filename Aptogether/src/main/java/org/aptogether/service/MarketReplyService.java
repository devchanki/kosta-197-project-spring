package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.Criteria;
import org.aptogether.domain.MarketReplyVO;

public interface MarketReplyService {
	public int ReplyRegister(MarketReplyVO vo);
	public MarketReplyVO ReplyGet(int replyNo);
	public int ReplyModify(MarketReplyVO vo);
	public int ReplyRemove(int replyNo);
	public List<MarketReplyVO> ReplyGetList(Criteria cri,int seq);
}
