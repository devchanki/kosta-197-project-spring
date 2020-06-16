package org.aptogether.mapper;

import java.util.List;

import org.aptogether.domain.AptVO;
import org.aptogether.domain.HouseholdVO;
import org.aptogether.domain.JoinTenantVO;

public interface AptMapper {
	public AptVO aptInfo(int aptSeq);
	public int aptCount(AptVO apt);
	public int insertApt(AptVO apt);
	public List<AptVO> searchWithKeyword(String keyword);
	public HouseholdVO getHousehold(JoinTenantVO member);
	public int createHousehold(JoinTenantVO memberVO);
}
