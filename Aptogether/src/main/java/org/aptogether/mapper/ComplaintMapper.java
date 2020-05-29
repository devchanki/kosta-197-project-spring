package org.aptogether.mapper;

import java.util.List;


import org.aptogether.domain.ComplaintVO;

public interface ComplaintMapper {

public List<ComplaintVO> compList();
public void insert(ComplaintVO board);

}
