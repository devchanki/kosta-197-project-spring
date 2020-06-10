package org.aptogether.domain;

import lombok.Data;

@Data
public class LevyVO {

	private int levySeq;
	private int aptSeq;
	private String levyDate;
	private String startCalDate;
	private String endCalDate;
	private String deadlineDate;
	private boolean status;
}
