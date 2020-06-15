package org.aptogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.aptogether.domain.FeeVO;
import org.aptogether.domain.TenantVO;

public interface FeeMapper {
	
	public TenantVO findMember(TenantVO user);
	
	public int insertFee(FeeVO fee);
	
	public List<FeeVO> listFee(TenantVO user);
	
	public List<FeeVO>	listFeeRowNum(TenantVO user);
}
