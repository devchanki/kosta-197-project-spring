package org.aptogether.domain;
import java.io.Serializable;

import lombok.Data;


@Data
public class AptVO implements Serializable{
	private int aptSeq;
	private String kaptCode; 
	private String aptName;
	private String location;
	private String x;
	private String y;
}
=======
package org.aptogether.domain;

import lombok.Data;

@Data
public class AptVO {
	
	private int aptSeq;
	private String kaptCode; 
	private String aptName;
	private String location;
	private String x;
	private String y;

}
