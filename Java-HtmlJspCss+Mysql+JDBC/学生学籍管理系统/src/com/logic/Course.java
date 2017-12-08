package com.logic;

import com.dal.section.*;
import com.dal.teacher.*;
import com.dal.teaches.*;
import com.dal.course.*;

import java.util.ArrayList;

//逻辑上的课是一个大类，也更加和现实中的课贴近。
//从根本上来讲，是一个Teaches数据。
//并且包含了数据库中Course、Section和Teacher的值对象。

public class Course{
	private String teacher_id;
	//以下为Section表的属性
	private String course_id;//课程代码
	private String sec_id;
	private String semester;//学期
	private int year;//学年
//	private String room_number;//上课地点
//	private int time_slot_id;//学时
//	private String classtime;//上课时间
	
//	****************没有实现上课时间功能********************
	
	//以下为Course表的属性
	private String title;//课程名
	private double credits;//课程学分
	private String dept_name;//学院
	private int capacity;//总量
	
	//包含的值对象
	private SectionVO sectionVO;
	private CourseVO courseVO;
	private TeacherVO teacherVO;
	
	//以下为用于逻辑添加的属性
	private static int left;//余量
	private String code;//合并Course_id和Sec_id，显示为课程代码
	
	public Course(TeachesVO teachesVO){
		//获得所有TeachesVO属性
		this.teacher_id=teachesVO.getID();
		this.course_id=teachesVO.getCourse_id();
		this.sec_id=teachesVO.getSec_id();
		this.semester=teachesVO.getSemester();
		this.year=teachesVO.getYear();
		
		//获得值对象
		SectionDAO sectionDAO = new SectionDAOImplement();
		this.sectionVO=sectionDAO.getSectionVOBySectionKey(course_id, sec_id, semester, year);
		
		CourseDAO courseDAO = new CourseDAOImplement();
		this.courseVO=courseDAO.getCourseVOByCourseID(course_id);
		
		TeacherDAO teacherDAO = new TeacherDAOImplement();
		this.teacherVO=teacherDAO.getTeacherVOByTeacherID(teacher_id);
		
		//处理其他逻辑上的数据
		code=course_id+sec_id;//课程代码=course_id+sec_id
		capacity=courseVO.getCapacity();
		left=capacity;
	}
	public ArrayList<String> showCourseInfo(String course_id){//显示课程信息
		return null;
//		String[] sectionInfo = {code,title,teacher.getName(),classtime,classroom,"",credits+"",capacity+"",left+""};//第一个空是课程介绍
//		return sectionInfo;
	}
//	public String showCourseList(String studentID){//
//		return null;
//	}
	//public Teacher getTeacherInfo(String course_ID){}
}
