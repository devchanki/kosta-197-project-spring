package org.aptogether.mapper;

import org.aptogether.domain.ComplaintReplyVO;

public interface ComplaintReplyMapper {
	public int insert(ComplaintReplyVO vo);

	public int delete(Long comprno);
	
	public ComplaintReplyVO read(Long compbno);
}
