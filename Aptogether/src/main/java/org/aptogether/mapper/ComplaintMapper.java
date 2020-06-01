package org.aptogether.mapper;

import java.util.List;


import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.ComplaintCriteria;

public interface ComplaintMapper {

public List<ComplaintVO>getCompList();
public List<ComplaintVO>getCompListWithPaging(ComplaintCriteria cri);
public void insert(ComplaintVO vo);
public ComplaintVO read(Long compbno);
public int delete(Long compbno);
public int update(ComplaintVO vo);
public int getComplaintTotal(ComplaintCriteria cri);
}
