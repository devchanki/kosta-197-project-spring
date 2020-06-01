package org.aptogether.mapper;

import org.aptogether.domain.AptVO;

public interface AptMapper {
	public int aptCount(AptVO apt);
	public int insertApt(AptVO apt);
}
