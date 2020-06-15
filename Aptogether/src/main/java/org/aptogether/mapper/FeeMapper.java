package org.aptogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.aptogether.domain.FeeRegisterVO;
import org.aptogether.domain.FeeVO;
import org.aptogether.domain.HouseholdVO;
import org.aptogether.domain.MeterVO;
import org.aptogether.domain.UnitPriceVO;
import org.aptogether.domain.TenantVO;
public interface FeeMapper {
	
	public List<HouseholdVO> listDong(HouseholdVO dong);
	
	public List<FeeRegisterVO> listFeeReg(int dong);
	
	public UnitPriceVO getUnitPrice(int unitPriceSeq); 
	
	public int updateUnitPrice(UnitPriceVO unitPrice);
	
	public int addMeter(MeterVO meter);
	
	public int updateMeter(MeterVO meter);
	
	
//	public TenantVO findMember(TenantVO user);
	
	public int insertFee(FeeVO fee);
	
	public List<FeeVO> listFee(TenantVO user);
	
	public List<FeeVO>	listFeeRowNum(TenantVO user);
}
