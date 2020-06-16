package org.aptogether.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.aptogether.domain.FeeRegisterVO;
import org.aptogether.domain.FeeVO;
import org.aptogether.domain.HouseholdVO;
import org.aptogether.domain.LevyVO;
import org.aptogether.domain.MeterVO;
import org.aptogether.domain.TenantFeeInfoVO;
import org.aptogether.domain.TenantVO;
import org.aptogether.domain.UnitPriceVO;

public interface FeeService {
	
	public List<HouseholdVO> listDong(int aptSeq);
	
	public List<FeeRegisterVO> listFeeReg(@Param("levySeq") int levySeq, @Param("dong") int dong);
	
	public List<HouseholdVO> householdInfo(int aptSeq);
	
	public LevyVO levyInfo(@Param("aptSeq") int aptSeq, @Param("levyDate") String levyDate);
	
	public int addFee(FeeVO fee);
	
	public int updateFee(FeeVO fee);
	
	public List<TenantFeeInfoVO> tenantFeeInfo(@Param("memberSeq") int memberSeq, @Param("rownum") int rownum);

}
