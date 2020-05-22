package com.sp.app.bbs.dto;

import java.sql.Timestamp;

public class BbsDto {
	private Integer seq;
	private String title;
	private String contents;
	private Timestamp insert_date;
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(Timestamp insert_date) {
		this.insert_date = insert_date;
	}
}
