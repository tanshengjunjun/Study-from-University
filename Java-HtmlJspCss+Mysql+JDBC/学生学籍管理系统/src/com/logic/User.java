package com.logic;

import java.util.ArrayList;

public interface User {
	public Object login(String ID,String password);//��¼
	public boolean changePassword(String oldPassword,String newPassword);//�޸�����
	
	public ArrayList<String> showInfoToMyself();//�Լ����ò鿴������Ϣ
	public boolean setInfo();//�Լ������޸ĸ�����Ϣ��Ҫ�б��޸ĵĲ�����
	public ArrayList<String> showInfoToOthers();//���˵��ò鿴������Ϣ��������Ϣ����ʾ��
}
