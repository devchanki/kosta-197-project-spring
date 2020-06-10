package org.aptogether.domain;

import lombok.Data;

@Data
public class FeeVO {

	private int feeSeq;
	private int levySeq;
	private int householdSeq;
	private int generalBill;
	private int securityBill;
	private int cleaningBill;
	private int fumigationBill;
	private int elevatorBill;
	private int electricityBill;
	private int waterBill;
	
	
	public int getTotalValue() {
		return generalBill + securityBill + cleaningBill + fumigationBill
					+ elevatorBill + electricityBill + waterBill;
	}
}
