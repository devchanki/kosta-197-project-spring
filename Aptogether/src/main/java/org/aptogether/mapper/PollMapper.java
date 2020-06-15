package org.aptogether.mapper;

import java.util.List;

import org.aptogether.domain.PollDetailVO;
import org.aptogether.domain.PollOptionVO;
import org.aptogether.domain.PollSelectVO;
import org.aptogether.domain.PollVO;

public interface PollMapper {
	
	//@Select("select * from poll where poll_seq > 0")
	public List<PollVO> PollList();
	
	public List<PollVO> PollOnList();
	
	public List<PollVO> PollEndList();
	
	public void PollInsert(PollVO poll);
	
	public void PollOptionInsert(List<PollOptionVO> option);
	
	public List<PollDetailVO> PollDetail(int pollSeq);
	
	public void PollSelectInsert(PollSelectVO select);
	
	public List<PollOptionVO> PollOptionList(int pollSeq);
	
}
