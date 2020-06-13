package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.PollDetailVO;
import org.aptogether.domain.PollOptionVO;
import org.aptogether.domain.PollSelectVO;
import org.aptogether.domain.PollVO;
import org.aptogether.mapper.PollMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class PollServiceImpl implements PollService {
	
	private PollMapper mapper;

	@Override
	public void PollInsert(PollVO poll) {
		
		log.info("PollInsert......" + poll);
		
		mapper.PollInsert(poll);
	}

	@Override
	public List<PollVO> PollList() {
		
		log.info("PollList......");
		
		return mapper.PollList();
	}

	@Override
	public void PollOptionInsert(List<PollOptionVO> option) {

		log.info("PollOptionInsert......");
		
		mapper.PollOptionInsert(option);
	}
	
	@Override
	public List<PollOptionVO> PollOptionList(int pollSeq) {

		log.info("PollOptionList.........");
		
		return mapper.PollOptionList(pollSeq);
	}

	@Override
	public void PollSelectInsert(PollSelectVO select) {

		log.info("PollSelectInsert......");
		
		mapper.PollSelectInsert(select);
	}

	@Override
	public List<PollDetailVO> PollDetail(int pollSeq) {
		log.info("PollDatail....");
		return mapper.PollDetail(pollSeq);
	}

}
