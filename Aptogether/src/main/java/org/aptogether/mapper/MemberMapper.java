package org.aptogether.mapper;

import org.aptogether.domain.MemberVO;

public interface MemberMapper {
	int memberCount(MemberVO member);

	int joinMember(MemberVO member);
}
