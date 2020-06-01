package org.aptogether.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ComplaintCriteria {
	private int pageNum;
	private int amount;
	
	public ComplaintCriteria() {
		this(1, 10);
	}
	public ComplaintCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
