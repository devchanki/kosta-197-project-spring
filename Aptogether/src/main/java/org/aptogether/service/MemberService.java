package org.aptogether.service;

import org.aptogether.domain.JoinVO;
import org.springframework.transaction.annotation.Transactional;

public interface MemberService {
	
	@Transactional
	public int joinService(JoinVO member);
}
