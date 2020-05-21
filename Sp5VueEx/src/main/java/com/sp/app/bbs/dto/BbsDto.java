package com.sp.app.bbs.dto;

import java.sql.Timestamp;

public class BbsDto {
	private Integer seq;
	private String title;
	private String contents;
	private Timestamp insert_data;
	
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
	public Timestamp getInsert_data() {
		return insert_data;
	}
	public void setInsert_data(Timestamp insert_data) {
		this.insert_data = insert_data;
	}
}
