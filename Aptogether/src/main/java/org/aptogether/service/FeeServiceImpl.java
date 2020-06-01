package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.FeeVO;
import org.aptogether.domain.UserVO;
import org.aptogether.mapper.FeeMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class FeeServiceImpl implements FeeService {
	
	private FeeMapper mapper;
	
	

	@Override
	public UserVO findMember(UserVO user) {
		
		log.info("findMember....." + user);
		
		return mapper.findMember(user);
	}

	@Override
	public void insertFee(FeeVO fee) {
		
		log.info("insertFee....." + fee);
		
		mapper.insertFee(fee);
	}

	@Override
	public List<FeeVO> listFee(UserVO user) {
		
		log.info("listFee.....");
		
		return mapper.listFee(user);
	}

	@Override
	public List<FeeVO> listFeeRowNum(UserVO user) {
		
		log.info("list fee up to 6 order by paydate desc");
		
		return mapper.listFeeRowNum(user);
	}

}
