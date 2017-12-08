package com.dal.takes;

import com.dal.section.SectionVO;

public class TakesVO {
	private String ID;//学生ID
	private String course_id;
	private String sec_id;
	private String semester;//学期
	private int year;//学年
	private int grade;//学生成绩
	
	public TakesVO() {
		// TODO Auto-generated constructor stub
	}
	
	public TakesVO(String studentID,SectionVO sectionVO){
		this.setID(studentID);
		this.setCourse_id(sectionVO.getCourse_id());
		this.setSec_id(sectionVO.getSec_id());
		this.setSemester(sectionVO.getSemester());
		this.setYear(sectionVO.getYear());
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
