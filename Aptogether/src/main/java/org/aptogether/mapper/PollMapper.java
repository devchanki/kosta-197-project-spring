package org.aptogether.mapper;

import java.util.List;

import org.aptogether.domain.HouseholdVO;
import org.aptogether.domain.PollChartVO;
import org.aptogether.domain.PollDetailVO;
import org.aptogether.domain.PollLookupVO;
import org.aptogether.domain.PollOptionVO;
import org.aptogether.domain.PollSelectVO;
import org.aptogether.domain.PollVO;

public interface PollMapper {
	
	public List<PollVO> PollList(int aptSeq);
	
	public List<PollVO> PollOnList(int aptSeq);
	
	public List<PollVO> PollEndList(int aptSeq);
	
	public List<PollChartVO> PollChart(int pollSeq);
	
	public void PollInsert(PollVO poll);
	
	public void PollOptionInsert(List<PollOptionVO> option);
	
	public List<PollDetailVO> PollDetail(int pollSeq);
	
	public int PollSelectLookup(PollLookupVO lookup);
	
	public void PollSelectInsert(PollSelectVO select);
	
	public List<PollOptionVO> PollOptionList(int pollSeq);
	
}
