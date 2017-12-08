package com.dal.course;

import java.util.ArrayList;
//�����ݿ��е�Course����һ����ѧ�������������пγ̣���Щ�γ̿������ɲ���һ��ʵ����
//��Section��һ��ʵ������ʦ�̵���Section��ѧ��ѧ��Ҳ��Section��
//��һ�����ӣ�������ȥ�����Է����ټ������������һ������������
//�㿴���Ĳ˵�����һ��Course������˵��ϵ��κ�һ���˾���Course���е�һ��value��
//��ĳ��ʱ�䣬�����������ĳ��������������ÿһ���˼���������һ��Section��
//�������Ե�������һ���ˣ�����һ��takes�������teaches���е�һ��value��
//���ڴ�ѧ���ݿ⣬ѧ���ͽ�ʦ�ܿ����ľ���Section��������Ա���Զ�Course����й���
public interface CourseDAO {
	public CourseVO getCourseVOByCourseID(String course_id);
	//ͨ���γ�ID���ҿγ̣�����Ա���ã�
	public CourseVO getCourseVOByTitle(String title);
	//ͨ���γ������ҿγ̣�����Ա���ã�
	public ArrayList<CourseVO> getCourseVOListByDeptName(String dept_name);
	//ͨ���γ�Ժϵ���ҿγ̱�����Ա���ã�
	public boolean updateCourseInfo(CourseVO courseVO);
	//���¿γ̣�����Ա���ã�
	public boolean insertCourse(CourseVO courseVO);
	//����γ̣�һ������û�п����ĿΣ�������Ա���ã�
	public boolean deleteCourse(String course_id);
	//ɾ���γ̣�����Ա���ã�
}