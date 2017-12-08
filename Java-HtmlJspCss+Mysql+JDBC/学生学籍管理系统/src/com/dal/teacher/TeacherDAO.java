package com.dal.teacher;

import java.util.ArrayList;

public interface TeacherDAO {
	public TeacherVO getTeacherVOByTeacherID(String teacherID);
	//通过教师ID查找教师（管理员调用）
	public TeacherVO getTeacherVOByTeacherIDAndPassword(String teacherID,String password);
	//登录（教师调用）
	public ArrayList<TeacherVO> getTeacherVOList();//
	public boolean updateTeacherInfo(TeacherVO teacherVO);
	//修改教师个人信息（教师调用）
	public boolean insertTeacher(TeacherVO teacherVO);
	//插入教师信息（管理员调用）
	public boolean deleteTeacher(String teacherID);
	//删除教师信息（管理员调用）
}