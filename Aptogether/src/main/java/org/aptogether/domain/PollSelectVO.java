package org.aptogether.domain;

import lombok.Data;

@Data
public class PollSelectVO {
	
	private int pollSelectSeq;
	private int memberSeq;
	private String selectDate;
	private int optionSeq;
	private String fileName;

}