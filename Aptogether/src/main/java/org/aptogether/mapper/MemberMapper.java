package org.aptogether.mapper;

import org.aptogether.domain.JoinVO;
import org.aptogether.domain.MemberVO;

public interface MemberMapper {
	int memberCount(JoinVO member);
	int joinMember(JoinVO member);
	MemberVO memberInfo(String id);
}
