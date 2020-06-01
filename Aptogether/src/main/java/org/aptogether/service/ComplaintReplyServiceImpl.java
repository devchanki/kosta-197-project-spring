package org.aptogether.service;

import org.aptogether.domain.ComplaintReplyVO;
import org.aptogether.mapper.ComplaintReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ComplaintReplyServiceImpl implements ComplaintReplyService {
	@Setter(onMethod_ = @Autowired)
	private ComplaintReplyMapper mapper;

@Override
public int registerCompReply(ComplaintReplyVO vo) {
	log.info("register reply..." + vo);
	
	return mapper.insert(vo);
 }

	@Override
	public ComplaintReplyVO getCompReply(Long comprno) {
		log.info("get reply..." + comprno);
		return mapper.read(comprno);
	}

	@Override
	public int removeCompReply(Long comprno) {
		log.info("remove reply...." + comprno);
		return mapper.delete(comprno);
	}

}
