package com.dal.takes;

import java.util.ArrayList;

import com.dal.section.SectionVO;

public interface TakesDAO {
	public ArrayList<TakesVO> getTakesVOListByStudentID(String studentID);
	//通过学生ID查询学生已选课程（学生调用）
	public ArrayList<TakesVO> getTakesVOListBySemesterAndYear(String semester,int year);
	//通过学年学期查询学生已选课程（学生调用）
	public ArrayList<String> getStudentIDListBySectionVO(SectionVO sectionVO);
	//通过课程查询学生ID表（教师调用）
	public double getGradeByTakesVO(TakesVO takesVO);
	//通过选课查询成绩（学生）
	public boolean updateTakesInfo(TakesVO takesVO);
	//修改选课信息（更新成绩）（教师调用）
	public boolean insertTakes(TakesVO takesVO);
	//学生选课（学生调用）
	public boolean deleteTakes(TakesVO takesVO);
	//学生退课（学生调用）
}