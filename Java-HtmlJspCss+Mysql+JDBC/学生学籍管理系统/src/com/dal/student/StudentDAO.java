package com.dal.student;

import java.util.ArrayList;

public interface StudentDAO {
	public StudentVO getStudentVOByStudentID(String studentID);
	//通过学生ID查询学生信息（教师、管理员调用）
	public StudentVO getStudentVOByStudentIDAndPassword(String studentID,String password);
	//登录（学生调用）
	public ArrayList<StudentVO> getStudentVOListByStudentIDList(ArrayList<String> studentIDList);
	//通过学生ID表查询学生信息表（教师调用）
	public boolean updateStudentInfo(StudentVO studentVO);
	//修改学生个人信息（学生调用）
	public boolean insertStudent(StudentVO studentVO);
	//插入学生信息（管理员调用）
	public boolean deleteStudent(String studentID);
	//删除学生信息（管理员调用）
}
