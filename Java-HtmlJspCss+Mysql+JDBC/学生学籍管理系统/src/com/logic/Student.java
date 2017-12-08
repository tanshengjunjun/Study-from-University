package com.logic;

import java.util.ArrayList;
import java.util.Date;

import com.dal.section.*;
import com.dal.course.*;
import com.dal.student.*;
import com.dal.takes.*;

public class Student implements User{
	private String name;
	private String ID;
//	private String password;
//	private int class_number;//班级
//	private String major;//专业
//	private String dept_name;//学院
//	private String sex;//性别
//	private double tot_cred;//总学分
//	private Date birthday;//生日（用String）
//	private String address;//地址（宿舍号）
//	private String phone;//手机（联系方式）
//	private String email;//邮件（联系方式）

	private StudentVO studentVO;//学生值对象
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(StudentVO studentVO){
		this.studentVO=studentVO;
	}
	
	
	@Override
	public Object login(String ID, String password) {
		// TODO Auto-generated method stub
		StudentDAO login = new StudentDAOImplement();
		studentVO=login.getStudentVOByStudentIDAndPassword(ID, password);
		if(studentVO==null){
			System.out.println("studentVO is null(com.logic.Student(42))");
			return null;
		}
		else{
			//进入学生页面
			this.ID=ID;
			this.name=studentVO.getName();
			return studentVO;
		}
	}
	@Override
	public boolean changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		StudentDAO changePassword = new StudentDAOImplement();
		if(oldPassword.equals(studentVO.getPassword())){
			studentVO.setPassword(newPassword);
			return changePassword.updateStudentInfo(studentVO);
		}
		else
			return false;
	}
	@Override
	public ArrayList<String> showInfoToOthers(){//教师或管理员调用 （用于别人查看）
		ArrayList<String> info = new ArrayList<String>();
		//arrayList 如果add空值
		info.add(studentVO.getID());
		info.add(studentVO.getName());
		info.add(studentVO.getSex());
		info.add(studentVO.getMajor()+studentVO.getClassNumber());
		info.add(studentVO.getDept_name());
		info.add(studentVO.getAddress());
		info.add(studentVO.getPhone()+" "+studentVO.getEmail());
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

	public ArrayList<TakesVO> showTakesTable(){
		TakesDAO takesDAO = new TakesDAOImplement();
		return takesDAO.getTakesVOListByStudentID(ID);
	}
	
	public boolean selectCourse(SectionVO sectionVO){
		TakesVO takesVO = new TakesVO(ID,sectionVO);
		TakesDAO takesDAO = new TakesDAOImplement();
		if(takesDAO.insertTakes(takesVO))
			return true;
		else
			return false;
	}
	
	public boolean cancelCourse(SectionVO sectionVO){
		TakesVO takesVO = new TakesVO(ID,sectionVO);
		TakesDAO takesDAO = new TakesDAOImplement();
		if(takesDAO.deleteTakes(takesVO))
			return true;
		else
			return false;
	}
	
	public double showGrade(SectionVO sectionVO){
		TakesVO takesVO = new TakesVO(ID,sectionVO);
		TakesDAO takesDAO = new TakesDAOImplement();
		return takesDAO.getGradeByTakesVO(takesVO);
	}
	
	public StudentVO getStudentVO() {
		return studentVO;
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
