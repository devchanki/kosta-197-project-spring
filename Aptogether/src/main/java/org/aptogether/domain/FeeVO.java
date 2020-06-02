package org.aptogether.domain;

import lombok.Data;

@Data
public class FeeVO {

	private int feeSeq;
	private int memberSeq;
	private int generalFee;
	private int securityFee;
	private int cleaningFee;
	private int fumigationFee;
	private int liftMaintenanceFee;
	private int electricityFee;
	private int waterFee;
	private int heatingFee;
	private String payDate;
	
	
	public int getTotalValue() {
		return generalFee + securityFee + cleaningFee + fumigationFee
					+ liftMaintenanceFee + electricityFee + waterFee + heatingFee;
	}
}
