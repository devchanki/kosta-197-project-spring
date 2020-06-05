package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.ComplaintCriteria;
import org.aptogether.mapper.ComplaintMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ComplaintServiceImpl implements ComplaintService{
	@Setter(onMethod_= @Autowired)
	private ComplaintMapper mapper;

	@Override
	public void registerComplaint(ComplaintVO vo) {
		log.info("register......" + vo);
		mapper.insert(vo);
		
	}

	@Override
	public ComplaintVO getComplaint(Long bno) {
		log.info("get detailcomp.......");
		return mapper.read(bno);
	}

	@Override
	public boolean modifyComplaint(ComplaintVO vo) {
		log.info("modify......" + vo);
		return mapper.update(vo) ==1;
	}

	@Override
	public boolean removeComplaint(Long bno) {
		log.info("remove......." + bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<ComplaintVO> getComplaintList(ComplaintCriteria cri) {
		log.info("get List with criteria:" + cri);
		return mapper.getComplaintListWithPaging(cri);
	}

	@Override
	public int getTotalComp(ComplaintCriteria cri) {
		log.info("get total Complaint count");
		return mapper.getComplaintTotal(cri);
	}

	
	
	


	
	
	
}
