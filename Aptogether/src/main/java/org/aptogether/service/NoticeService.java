package org.aptogether.service;

import java.util.List;

import org.aptogether.domain.NoticeCriteria;
import org.aptogether.domain.NoticeVO;
import org.springframework.stereotype.Service;

public interface NoticeService {

	public void register(NoticeVO notice);

	public NoticeVO get(int noticeSeq);

	public boolean modify(NoticeVO notice);

	public boolean remove(int noticeSeq);

	public List<NoticeVO> getList(NoticeCriteria cri, int aptSeq);
		
	public int getTotal(NoticeCriteria cri, int aptSeq);

	public boolean plusCnt(int noticeSeq);
}