package org.aptogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.aptogether.domain.FeeRegisterVO;
import org.aptogether.domain.FeeVO;
import org.aptogether.domain.HouseholdVO;
import org.aptogether.domain.MemberVO;

public interface FeeMapper {
	
	public List<HouseholdVO> listDong(HouseholdVO dong);
	
	public List<FeeRegisterVO> listFeeReg(@Param("levyDate") String levyDate, @Param("dong") int dong);
	
	public int insertFee(FeeVO fee);
	
	public List<FeeVO> listFee(MemberVO user);
	
	public List<FeeVO>	listFeeRowNum(MemberVO user);
}
