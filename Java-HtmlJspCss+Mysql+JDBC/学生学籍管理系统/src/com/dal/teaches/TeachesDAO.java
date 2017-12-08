package com.dal.teaches;

import java.util.ArrayList;

public interface TeachesDAO {
	public ArrayList<TeachesVO> getTeachesVOListByTeacherID(String teacherID);
	//通过教师ID查询教师教授课程（教师调用）
	public boolean insertTeaches(TeachesVO teachesVO);
	//添加授课（管理员调用 ）
	public boolean deleteTeaches(TeachesVO teachesVO);
	//删除授课（管理员调用）
}