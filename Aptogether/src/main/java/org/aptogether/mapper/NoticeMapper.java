package org.aptogether.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.aptogether.domain.NoticeVO;

public interface NoticeMapper {

// 	@Select("select * from notice where notice_seq > 0")
	public List<NoticeVO> getList();
	public void insertNotice(NoticeVO notice);
	public NoticeVO readNotice(int noticeSeq);
	public int deleteNotice(int noticeSeq);
	public int updateNotice(NoticeVO notice);
	
	
	
}
