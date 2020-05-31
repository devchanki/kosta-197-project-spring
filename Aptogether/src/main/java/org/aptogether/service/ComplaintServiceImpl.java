package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.Criteria;
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
	public ComplaintVO getComp(Long seq) {
		log.info("get detailcomp.......");
		return mapper.read(seq);
	}

	@Override
	public boolean modifyComp(ComplaintVO vo) {
		log.info("modify......" + vo);
		return mapper.update(vo) ==1;
	}

	/*@Override
	public List<ComplaintVO>getCompList() {
		log.info("get List...........");
		return mapper.getCompList();
	}*/

	@Override
	public boolean remove(Long seq) {
		log.info("remove...." + seq);
		return mapper.delete(seq) == 1;
	}

	@Override
	public List<ComplaintVO> getCompList(Criteria cri) {
		log.info("get List with criteira: " + cri);
		return mapper.getCompListWithPaging(cri);
	}
	
	


	
	
	
}
