package org.aptogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.aptogether.domain.FeeRegisterVO;
import org.aptogether.domain.FeeVO;
import org.aptogether.domain.HouseholdVO;
import org.aptogether.domain.MemberVO;
import org.aptogether.domain.MeterVO;
import org.aptogether.domain.UnitPriceVO;

public interface FeeMapper {
	
	public List<HouseholdVO> listDong(HouseholdVO dong);
	
	public List<FeeRegisterVO> listFeeReg(int dong);
	
	public UnitPriceVO getUnitPrice(int unitPriceSeq); 
	
	public int updateUnitPrice(UnitPriceVO unitPrice);
	
	public int addMeter(MeterVO meter);
	
	public int updateMeter(MeterVO meter);
	
	
	
	
	
	public int insertFee(FeeVO fee);
	
	public List<FeeVO> listFee(MemberVO user);
	
	public List<FeeVO>	listFeeRowNum(MemberVO user);
	
}
