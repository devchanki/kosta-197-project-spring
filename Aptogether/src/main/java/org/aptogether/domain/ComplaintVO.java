package org.aptogether.domain;

import lombok.Data;

@Data
public class ComplaintVO {
	String title;
	String email;
	String tel;
	String content;
	String fname;
	String compdate;
	int seq;	
	
}
