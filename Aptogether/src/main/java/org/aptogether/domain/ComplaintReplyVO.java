package org.aptogether.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ComplaintReplyVO {
	private Long comprno;
	private Long compbno;
	
	private String compreply;
	private String compreplyer;
	private Date compreplydate;
	

}
