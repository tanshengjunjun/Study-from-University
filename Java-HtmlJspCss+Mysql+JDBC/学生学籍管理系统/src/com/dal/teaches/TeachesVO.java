package com.dal.teaches;

public class TeachesVO {
	private String ID;//教师ID
	private String course_id;
	private String sec_id;
	private String semester;//学期
	private int year;//学年
	
	public TeachesVO() {
		// TODO Auto-generated constructor stub
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getSec_id() {
		return sec_id;
	}

	public void setSec_id(String sec_id) {
		this.sec_id = sec_id;
	}
	
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
