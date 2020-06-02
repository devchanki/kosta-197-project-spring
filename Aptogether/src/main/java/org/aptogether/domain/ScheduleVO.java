package org.aptogether.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ScheduleVO {
	private int scheduleSeq;
	private String title;
	private String contents;
	private String startDate;
	private String endDate;
	private int aptSeq;
	private String backgroundColor;
	private String dong;
}
