package org.aptogether.domain;

import lombok.Data;

@Data
public class ComplaintVO {
	private String title;
	private String email;
	private String tel;
	private String content;
	private String date;
	private String process;
	private long bno;	
	private long userno;
}
