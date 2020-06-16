package org.aptogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.aptogether.domain.FeeRegisterVO;
import org.aptogether.domain.FeeVO;
import org.aptogether.domain.HouseholdVO;
import org.aptogether.domain.LevyVO;
import org.aptogether.domain.MeterVO;
import org.aptogether.domain.UnitPriceVO;
import org.aptogether.domain.TenantVO;
public interface FeeMapper {
	
	public List<HouseholdVO> listDong(int aptSeq);
	
	public List<FeeRegisterVO> listFeeReg(@Param("levySeq") int levySeq, @Param("dong") int dong);
	
	public List<HouseholdVO> householdInfo(int aptSeq);
	
	public LevyVO levyInfo(@Param("aptSeq") int aptSeq, @Param("levyDate") String levyDate);
	
	public int addFee(FeeVO fee);
	
	public int updateFee(FeeVO fee);
	
	
//	public TenantVO findMember(TenantVO user);
	
	
	public List<FeeVO> listFee(TenantVO user);
	
	public List<FeeVO>	listFeeRowNum(TenantVO user);
}
