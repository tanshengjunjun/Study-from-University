package com.logic;

import java.util.ArrayList;

import com.dal.section.*;
import com.dal.student.*;
import com.dal.takes.*;
import com.dal.teacher.*;
import com.dal.teaches.*;

public class Teacher implements User{
	private String name;
	private String ID;
	private String password;
//	private String sex;//性别
//	private String phone;//手机（联系方式）
//	private String email;//邮件（联系方式）
//	private String dept_name;//院系
	
	private TeacherVO teacherVO;//教师值对象

	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	
	public Teacher(TeacherVO teacherVO){
		this.teacherVO=teacherVO;
	}
	
	@Override
	public Object login(String ID, String password) {
		// TODO Auto-generated method stub
		System.out.println("Teacher login method");
		TeacherDAO login = new TeacherDAOImplement();
		teacherVO=login.getTeacherVOByTeacherIDAndPassword(ID, password);
		if(teacherVO==null)
			return null;
		else{
			this.ID=ID;
			this.name=teacherVO.getName();
			return teacherVO;
		}
	}
	@Override
	public boolean changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		TeacherDAO changePassword = new TeacherDAOImplement();
		if(oldPassword.equals(teacherVO.getPassword())){
			teacherVO.setPassword(newPassword);
			return changePassword.updateTeacherInfo(teacherVO);
		}
		else
			return false;
	}
	@Override
	public ArrayList<String> showInfoToOthers(){//别人查看信息（要根据原型）
		ArrayList<String> info = new ArrayList<String>();
		info.add(teacherVO.getID());
		info.add(teacherVO.getName());
		info.add(teacherVO.getDept_name());
		info.add(teacherVO.getPhone()+" "+teacherVO.getEmail());
		return info;
	}
	@Override
	public ArrayList<String> showInfoToMyself() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean setInfo(){//
		return false;
	}

	public ArrayList<TeachesVO> showTeachesTable(){//查看授课表
		TeachesDAO teachesDAO = new TeachesDAOImplement();
		return teachesDAO.getTeachesVOListByTeacherID(ID);
	}
	
	public ArrayList<StudentVO> showStudentInClass(SectionVO sectionVO){//查看课程学生
		//参数是TeachesVO也差不多
		TakesDAO takesDAO = new TakesDAOImplement();
		StudentDAO studentDAO = new StudentDAOImplement();
		return studentDAO.getStudentVOListByStudentIDList(takesDAO.getStudentIDListBySectionVO(sectionVO));
	}
	
	public boolean setGrade(String studentID,SectionVO sectionVO,int grade){//录入学生成绩
		TakesVO takesVO = new TakesVO(studentID,sectionVO);
		takesVO.setGrade(grade);
		TakesDAO takesDAO = new TakesDAOImplement();
		return takesDAO.updateTakesInfo(takesVO);
	}
	
	public TeacherVO getTeacherVO() {
		return teacherVO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
}
