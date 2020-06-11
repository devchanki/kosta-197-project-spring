package org.aptogether.domain;

import lombok.Data;

@Data
public class JoinVO {
	String name;
	int aptSeq;
	String id;
	String password;
	String type;
	int dong;
	int ho;
	int householdSeq;
}
