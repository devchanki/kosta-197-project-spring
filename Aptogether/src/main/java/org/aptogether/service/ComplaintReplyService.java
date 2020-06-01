package org.aptogether.service;

import org.aptogether.domain.ComplaintReplyVO;

public interface ComplaintReplyService {
	public int registerCompReply(ComplaintReplyVO vo);

	public ComplaintReplyVO getCompReply(Long comprno);

	public int removeCompReply(Long comprno);

}
