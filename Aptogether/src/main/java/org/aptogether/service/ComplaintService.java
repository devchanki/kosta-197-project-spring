package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.ComplaintCriteria;

public interface ComplaintService {
	public void registerComplaint(ComplaintVO vo);
	public ComplaintVO getComplaint(Long seq);
	public boolean modifyComplaint(ComplaintVO vo);
	public boolean removeComplaint(Long seq);
	//public List<ComplaintVO>getComplaintList();
	public List<ComplaintVO>getComplaintList(ComplaintCriteria cri);
	public int getTotalComp(ComplaintCriteria cri);
}