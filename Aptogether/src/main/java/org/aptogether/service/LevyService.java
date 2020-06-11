package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.LevyVO;

public interface LevyService {

	public int addLevy(LevyVO levy);
	
	public List<LevyVO> listLevy(LevyVO levy);
}
