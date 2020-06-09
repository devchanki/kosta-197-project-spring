package org.aptogether.service;

import org.aptogether.domain.HouseholdVO;
import org.aptogether.domain.JoinVO;
import org.aptogether.domain.MemberVO;
import org.aptogether.mapper.AptMapper;
import org.aptogether.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	AptMapper aptMapper;
	
	
	@Override
	public int joinService(JoinVO member) {
		if(memberMapper.memberCount(member) == 0) {
			HouseholdVO householdVO = aptMapper.getHousehold(member);
			if(householdVO == null) {
				aptMapper.createHousehold(member);
				return memberMapper.joinMember(member);
			} else {
				member.setHouseholdSeq(householdVO.getHouseholdSeq());
				return memberMapper.joinMember(member);
			}
		} else {
			return -1; 
		}
	}
}
