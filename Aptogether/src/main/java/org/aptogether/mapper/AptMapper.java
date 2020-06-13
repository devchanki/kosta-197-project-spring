package org.aptogether.mapper;

import java.util.List;

import org.aptogether.domain.AptVO;
import org.aptogether.domain.HouseholdVO;
import org.aptogether.domain.JoinVO;
import org.aptogether.domain.MemberVO;

public interface AptMapper {
	public int aptCount(AptVO apt);
	public int insertApt(AptVO apt);
	public List<AptVO> searchWithKeyword(String keyword);
	public HouseholdVO getHousehold(JoinVO member);
	public int createHousehold(JoinVO memberVO);
}
