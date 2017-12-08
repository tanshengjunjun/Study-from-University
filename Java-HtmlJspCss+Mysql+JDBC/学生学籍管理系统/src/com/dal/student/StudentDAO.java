package com.dal.student;

import java.util.ArrayList;

public interface StudentDAO {
	public StudentVO getStudentVOByStudentID(String studentID);
	//ͨ��ѧ��ID��ѯѧ����Ϣ����ʦ������Ա���ã�
	public StudentVO getStudentVOByStudentIDAndPassword(String studentID,String password);
	//��¼��ѧ�����ã�
	public ArrayList<StudentVO> getStudentVOListByStudentIDList(ArrayList<String> studentIDList);
	//ͨ��ѧ��ID���ѯѧ����Ϣ����ʦ���ã�
	public boolean updateStudentInfo(StudentVO studentVO);
	//�޸�ѧ��������Ϣ��ѧ�����ã�
	public boolean insertStudent(StudentVO studentVO);
	//����ѧ����Ϣ������Ա���ã�
	public boolean deleteStudent(String studentID);
	//ɾ��ѧ����Ϣ������Ա���ã�
}
