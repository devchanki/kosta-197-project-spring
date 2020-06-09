package org.aptogether.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MarketReplyVO implements Serializable{
	private int reply_no;
	private String reply_writer;
	private String reply_contents;
	private Date reply_regdate;
	private int seq;
}
