package org.aptogether.mapper;

import java.util.List;

import org.aptogether.domain.JoinKeeperVO;
import org.aptogether.domain.JoinTenantVO;
import org.aptogether.domain.KeeperVO;
import org.aptogether.domain.TenantVO;

public interface MemberMapper {
	int memberCount(String member);

	int joinTenant(JoinTenantVO member);

	TenantVO memberInfo(String username);

	int joinKeeper(JoinKeeperVO keeper);

	int keeperCount(String id);

	KeeperVO keeperInfo(String username);

	List<TenantVO> showNotAdmitUser(int seq);

	int admitTenant(int seq);

}
