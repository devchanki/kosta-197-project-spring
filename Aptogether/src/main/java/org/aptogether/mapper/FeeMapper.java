package org.aptogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.aptogether.domain.FeeVO;
import org.aptogether.domain.MemberVO;

public interface FeeMapper {
	
	public MemberVO findMember(MemberVO user);
	
	public void insertFee(FeeVO fee);
	
	public List<FeeVO> listFee(MemberVO user);
	
	public List<FeeVO>	listFeeRowNum(MemberVO user);
}
