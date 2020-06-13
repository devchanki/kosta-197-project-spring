package org.aptogether.domain;

import lombok.Data;

@Data
public class UserVO {
	private int member_seq;
	private String id;
	private String password;
	private int apt_seq;
	private int dong;
	private int ho;
	private boolean admit;
	private String type;
	private String name;
}
