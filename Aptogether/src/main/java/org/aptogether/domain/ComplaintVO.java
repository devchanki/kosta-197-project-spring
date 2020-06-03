package org.aptogether.domain;

import lombok.Data;

@Data
public class ComplaintVO {
	private String comptitle;
	private String compemail;
	private String comptel;
	private String compcontent;
	private String compdate;
	private long compbno;	
}
