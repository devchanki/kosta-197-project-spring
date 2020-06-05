package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.FeeVO;
import org.aptogether.domain.MemberVO;

public interface FeeService {
	
	public MemberVO findMember(MemberVO user);
	
	public void insertFee(FeeVO fee);
	
	public List<FeeVO> listFee(MemberVO user);
	
	public List<FeeVO>	listFeeRowNum(MemberVO user);

}
