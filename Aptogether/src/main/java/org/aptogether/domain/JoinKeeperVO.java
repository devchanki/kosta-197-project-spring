package org.aptogether.domain;

import lombok.Data;

@Data
public class JoinKeeperVO {
	String name;
	int aptSeq;
	String id;
	String password;
	String type;
}
