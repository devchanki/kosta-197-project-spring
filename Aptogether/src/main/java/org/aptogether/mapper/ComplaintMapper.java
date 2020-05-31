package org.aptogether.mapper;

import java.util.List;


import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.Criteria;

public interface ComplaintMapper {

public List<ComplaintVO>getCompList();
public List<ComplaintVO>getCompListWithPaging(Criteria cri);
public void insert(ComplaintVO vo);
public ComplaintVO read(Long seq);
public int delete(Long seq);
public int update(ComplaintVO vo);

}
