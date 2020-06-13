package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.PollDetailVO;
import org.aptogether.domain.PollOptionVO;
import org.aptogether.domain.PollSelectVO;
import org.aptogether.domain.PollVO;

public interface PollService {
	
	public void PollInsert(PollVO poll);
	
	public List<PollVO> PollList();
	
	public void PollOptionInsert(List<PollOptionVO> option);
	
	public List<PollOptionVO> PollOptionList(int pollSeq);
	
	public void PollSelectInsert(PollSelectVO select);
	
	public List<PollDetailVO> PollDetail(int pollSeq);

}