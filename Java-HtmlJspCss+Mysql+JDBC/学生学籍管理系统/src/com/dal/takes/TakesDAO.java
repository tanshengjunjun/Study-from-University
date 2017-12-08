package com.dal.takes;

import java.util.ArrayList;

import com.dal.section.SectionVO;

public interface TakesDAO {
	public ArrayList<TakesVO> getTakesVOListByStudentID(String studentID);
	//ͨ��ѧ��ID��ѯѧ����ѡ�γ̣�ѧ�����ã�
	public ArrayList<TakesVO> getTakesVOListBySemesterAndYear(String semester,int year);
	//ͨ��ѧ��ѧ�ڲ�ѯѧ����ѡ�γ̣�ѧ�����ã�
	public ArrayList<String> getStudentIDListBySectionVO(SectionVO sectionVO);
	//ͨ���γ̲�ѯѧ��ID����ʦ���ã�
	public double getGradeByTakesVO(TakesVO takesVO);
	//ͨ��ѡ�β�ѯ�ɼ���ѧ����
	public boolean updateTakesInfo(TakesVO takesVO);
	//�޸�ѡ����Ϣ�����³ɼ�������ʦ���ã�
	public boolean insertTakes(TakesVO takesVO);
	//ѧ��ѡ�Σ�ѧ�����ã�
	public boolean deleteTakes(TakesVO takesVO);
	//ѧ���˿Σ�ѧ�����ã�
}