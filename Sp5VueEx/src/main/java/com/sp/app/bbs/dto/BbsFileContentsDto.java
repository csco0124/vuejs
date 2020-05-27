package com.sp.app.bbs.dto;

import java.sql.Timestamp;

public class BbsFileContentsDto {
	private Integer seq;
	private String contents;
	private String file1_path;
	private String file2_path;
	private Timestamp insert_date;
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getFile1_path() {
		return file1_path;
	}
	public void setFile1_path(String file1_path) {
		this.file1_path = file1_path;
	}
	public String getFile2_path() {
		return file2_path;
	}
	public void setFile2_path(String file2_path) {
		this.file2_path = file2_path;
	}
	public Timestamp getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(Timestamp insert_date) {
		this.insert_date = insert_date;
	}
}
