package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.FeeVO;
import org.aptogether.domain.TenantVO;

public interface FeeService {
	
	public TenantVO findMember(TenantVO user);
	
	public int insertFee(FeeVO fee);
	
	public List<FeeVO> listFee(TenantVO user);
	
	public List<FeeVO>	listFeeRowNum(TenantVO user);

}
