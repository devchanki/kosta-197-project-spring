package org.aptogether.service;

import org.aptogether.domain.HouseholdVO;
import org.aptogether.domain.JoinKeeperVO;
import org.aptogether.domain.JoinTenantVO;
import org.aptogether.domain.TenantVO;
import org.aptogether.mapper.AptMapper;
import org.aptogether.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	MemberMapper memberMapper;
	AptMapper aptMapper;
	TenantVO tenant;

	@Override
	public int joinTenantService(JoinTenantVO member) {
		if (memberMapper.memberCount(member.getId()) == 0) {
			HouseholdVO householdVO = aptMapper.getHousehold(member);
			if (householdVO == null) {
				aptMapper.createHousehold(member);
				return memberMapper.joinTenant(member);
			} else {
				return memberMapper.joinTenant(member);
			}
		} else {
			return -1;
		}
	}
	

	@Override
	public int countMember(String id) {
		return memberMapper.memberCount(id);
	}

	@Override
	public int joinKeeperService(JoinKeeperVO keeper) {
		// TODO Auto-generated method stub
		if (memberMapper.keeperCount(keeper.getId()) == 0) {
			return memberMapper.joinKeeper(keeper);
		} else {
			return -1;
		}
	}
}
