package com.dal.entry;

import java.sql.Date;

public class EntryVO {
	private int entry_id;
	private String title;
	private String brief;//简要介绍（用于义项）
	private String category;//分类
	private boolean isPassed;//是否通过审核
	private Date create_date;//创建时间
	
	public int getEntry_id() {
		return entry_id;
	}
	public void setEntry_id(int entry_id) {
		this.entry_id = entry_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isPassed() {
		return isPassed;
	}
	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
}
