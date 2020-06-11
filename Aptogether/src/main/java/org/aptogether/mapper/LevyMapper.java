package org.aptogether.mapper;

import java.util.List;

import org.aptogether.domain.LevyVO;

public interface LevyMapper {
	
	public int addLevy(LevyVO levy);
	
	public List<LevyVO> listLevy(LevyVO levy);

}
