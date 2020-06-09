package org.aptogether.domain;

import lombok.Data;

@Data
public class MemberVO {
	
	private int memberSeq;
	private int householdSeq;
	private String name;
	private String id;
	private String password;
}
