package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.LevyVO;
import org.aptogether.domain.UnitPriceVO;

public interface LevyService {

	public int addLevy(LevyVO levy);
	
	public List<LevyVO> listLevy(LevyVO levy);
	
	public UnitPriceVO findUnitPriceSeq(String levyDate);
}
