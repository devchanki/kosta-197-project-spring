package org.aptogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.aptogether.domain.FeeVO;
import org.aptogether.domain.UserVO;

public interface FeeMapper {
	
	public UserVO findMember(UserVO user);
	
	public int insertFee(FeeVO fee);
	
	public List<FeeVO> listFee(UserVO user);
	
	public List<FeeVO>	listFeeRowNum(UserVO user);
}
