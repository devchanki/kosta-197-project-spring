package org.aptogether.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class MemberVO implements Serializable{
	int memberSeq;
	String id;
	String password;
	int aptSeq;
	int householdSeq;
	boolean admit;
	String type;
	String name;
	int dong;
	int ho;
}
