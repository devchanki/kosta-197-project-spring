package org.aptogether.domain;

import lombok.Data;

@Data
public class MemberVO {
	private int memberSeq;
	private String id;
	private String password;
	private int aptSeq;
	private int dong;
	private int ho;
	private boolean admit;
	private String type;
	private String name;
}
