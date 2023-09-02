package com.ghost.entity.dto;

import java.sql.Date;

public class BoardDto {
	private int id;
	private String title;
	private String content;
	private int writerId;
	private Date entryDate;
	private Date modifyDate;

	public BoardDto() {
	}

	public BoardDto(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public BoardDto(int id, String title, String content, int writerId, Date entryDate, Date modifyDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.writerId = writerId;
		this.entryDate = entryDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "BoardDto [id=" + id + ", title=" + title + ", content=" + content + ", writerId=" + writerId
				+ ", entryDate=" + entryDate + ", modifyDate=" + modifyDate + "]";
	}

}
