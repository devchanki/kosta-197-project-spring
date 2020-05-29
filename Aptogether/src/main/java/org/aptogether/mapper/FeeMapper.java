package org.aptogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.aptogether.domain.FeeVO;

public interface FeeMapper {
	@Select("select * from manage_fee")
	public List<FeeVO> list ();
}
