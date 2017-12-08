package com.dal.teacher;

import java.util.ArrayList;

public interface TeacherDAO {
	public TeacherVO getTeacherVOByTeacherID(String teacherID);
	//ͨ����ʦID���ҽ�ʦ������Ա���ã�
	public TeacherVO getTeacherVOByTeacherIDAndPassword(String teacherID,String password);
	//��¼����ʦ���ã�
	public ArrayList<TeacherVO> getTeacherVOList();//
	public boolean updateTeacherInfo(TeacherVO teacherVO);
	//�޸Ľ�ʦ������Ϣ����ʦ���ã�
	public boolean insertTeacher(TeacherVO teacherVO);
	//�����ʦ��Ϣ������Ա���ã�
	public boolean deleteTeacher(String teacherID);
	//ɾ����ʦ��Ϣ������Ա���ã�
}