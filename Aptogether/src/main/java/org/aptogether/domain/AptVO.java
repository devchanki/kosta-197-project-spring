package org.aptogether.domain;
import java.io.Serializable;

import lombok.Data;

@Data
public class AptVO implements Serializable{
	
	private int aptSeq;
	private String aptCode; 
	private String aptName;
	private String location;
	private String x;
	private String y;
}
