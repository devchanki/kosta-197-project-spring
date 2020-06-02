package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.FeeVO;
import org.aptogether.domain.UserVO;

public interface FeeService {
	
	public UserVO findMember(UserVO user);
	
	public int insertFee(FeeVO fee);
	
	public List<FeeVO> listFee(UserVO user);
	
	public List<FeeVO>	listFeeRowNum(UserVO user);

}
