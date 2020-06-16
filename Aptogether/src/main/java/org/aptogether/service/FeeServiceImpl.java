package org.aptogether.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.aptogether.domain.FeeRegisterVO;
import org.aptogether.domain.FeeVO;
import org.aptogether.domain.HouseholdVO;
import org.aptogether.domain.LevyVO;
import org.aptogether.domain.MeterVO;
import org.aptogether.domain.TenantVO;
import org.aptogether.domain.UnitPriceVO;
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
	public List<HouseholdVO> listDong(HouseholdVO dong) {
		
		log.info("listdong....." + dong);
		
		return mapper.listDong(dong);
	}
	
	@Override
	public List<FeeRegisterVO>  listFeeReg(int dong) {
		
		log.info("dong : "+ dong);
		
		return mapper.listFeeReg(dong);
	}
	
	@Override
	public LevyVO levyInfo(@Param("aptSeq") int aptSeq, @Param("levyDate") String levyDate) {
		
		
		return mapper.levyInfo(aptSeq, levyDate);
	}
	
	
	
	
	@Override
	public List<HouseholdVO> householdInfo(int aptSeq) {
		
		return mapper.householdInfo(aptSeq);
	}	
	

	@Override
	public int addFee(FeeVO fee) {
		
		return mapper.addFee(fee);
	}
	

	@Override
	public int updateFee(FeeVO fee) {
		
		
		return mapper.updateFee(fee);
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
