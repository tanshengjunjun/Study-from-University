package com.dal.teaches;

import java.util.ArrayList;

public interface TeachesDAO {
	public ArrayList<TeachesVO> getTeachesVOListByTeacherID(String teacherID);
	//ͨ����ʦID��ѯ��ʦ���ڿγ̣���ʦ���ã�
	public boolean insertTeaches(TeachesVO teachesVO);
	//����ڿΣ�����Ա���� ��
	public boolean deleteTeaches(TeachesVO teachesVO);
	//ɾ���ڿΣ�����Ա���ã�
}