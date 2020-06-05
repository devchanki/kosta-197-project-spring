package org.aptogether.mapper;

import java.util.List;


import org.aptogether.domain.ComplaintVO;
import org.aptogether.domain.ComplaintCriteria;

public interface ComplaintMapper {

public List<ComplaintVO>getComplaintList();
public List<ComplaintVO>getComplaintListWithPaging(ComplaintCriteria cri);
public void insert(ComplaintVO vo);
public ComplaintVO read(Long bno);
public int delete(Long bno);
public int update(ComplaintVO vo);
public int getComplaintTotal(ComplaintCriteria cri);
public int getTotalCount(ComplaintCriteria cri);
}
