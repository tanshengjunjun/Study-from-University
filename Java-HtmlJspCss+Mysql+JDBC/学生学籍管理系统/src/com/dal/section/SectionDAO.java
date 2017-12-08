package com.dal.section;

import java.util.ArrayList;
//在数据库中的Course表是一个大学以往开过的所有课程，这些课程可以理解成不是一个实例。
//而Section是一个实例，教师教的是Section表，学生学的也是Section表。
//举一个例子，假如你去餐厅吃饭，再假如这个餐厅是一个连锁餐厅。
//你看到的菜单就是一个Course表，这个菜单上的任何一道菜就是Course表中的一个value。
//在某个时间，在这个餐厅的某家连锁店中做的每一道菜加起来就是一个Section表。
//而如果你吃的是其中一道菜，就是一个takes表或者是teaches表中的一个value。
//对于大学数据库，学生和教师能看到的就是Section表，而管理员可以对Course表进行管理。
public interface SectionDAO {
	public SectionVO getSectionVOBySectionKey(String course_id,String sec_id,String semester,int year);
	//通过Section的主码查找Section课程（管理员调用）
	public ArrayList<SectionVO> getSectionVOListBySemesterAndYear(String semester,int year);
	//通过学期和学年查找Section课程表（学生调用）
	public boolean updateSectionInfo(SectionVO sectionVO);
	//更新课程（管理员调用）
	public boolean insertSection(SectionVO sectionVO);
	//插入课程（以往开过的课）（管理员调用）
	public boolean deleteSection(SectionVO sectionVO);
	//删除课程（管理员调用）
}
