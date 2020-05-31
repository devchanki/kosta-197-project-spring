package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.Criteria;

public interface ComplaintService {
	public void registerComp(ComplaintVO vo);
	public ComplaintVO getComp(Long seq);
	public boolean modifyComp(ComplaintVO vo);
	public boolean remove(Long seq);
	//public List<ComplaintVO>getCompList();
	public List<ComplaintVO> getCompList(Criteria cri);
}
