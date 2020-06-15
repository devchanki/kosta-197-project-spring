package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.FeeVO;
import org.aptogether.domain.TenantVO;
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
	public TenantVO findMember(TenantVO user) {
		
		log.info("findMember....." + user);
		
		return mapper.findMember(user);
	}

	@Override
	public int insertFee(FeeVO fee) {
		
		log.info("insertFee....." + fee);
		
		return mapper.insertFee(fee);
	}

	@Override
	public List<FeeVO> listFee(TenantVO user) {
		
		log.info("listFee.....");
		
		return mapper.listFee(user);
	}

	@Override
	public List<FeeVO> listFeeRowNum(TenantVO user) {
		
		log.info("list fee up to 6 order by paydate desc");
		
		return mapper.listFeeRowNum(user);
	}

}
