package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.ComplaintCriteria;

public interface ComplaintService {
	public void registerComp(ComplaintVO vo);
	public ComplaintVO getComp(Long seq);
	public boolean modifyComp(ComplaintVO vo);
	public boolean removeComp(Long seq);
	//public List<ComplaintVO>getCompList();
	public List<ComplaintVO> getCompList(ComplaintCriteria cri);
	public int getTotalComp(ComplaintCriteria cri);
}
