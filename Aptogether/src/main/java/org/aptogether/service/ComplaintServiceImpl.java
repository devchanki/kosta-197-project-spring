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
	public void registerComp(ComplaintVO vo) {
		log.info("register......" + vo);
		mapper.insert(vo);
		
	}

	@Override
	public ComplaintVO getComp(Long compbno) {
		log.info("get detailcomp.......");
		return mapper.read(compbno);
	}

	@Override
	public boolean modifyComp(ComplaintVO vo) {
		log.info("modify......" + vo);
		return mapper.update(vo) ==1;
	}

	@Override
	public boolean removeComp(Long compbno) {
		log.info("remove...." + compbno);
		return mapper.delete(compbno) == 1;
	}

	@Override
	public List<ComplaintVO> getCompList(ComplaintCriteria cri) {
		log.info("get List with criteira: " + cri);
		return mapper.getCompListWithPaging(cri);
	}

	@Override
	public int getTotalComp(ComplaintCriteria cri) {
		log.info("get total Complaint count");
		return mapper.getComplaintTotal(cri);
	}

	
	
	


	
	
	
}
