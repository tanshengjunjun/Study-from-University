package com.logic;

public interface User {
	public User login(String id,String password);//��¼
	public boolean changePassword(String oldPassword,String newPassword);//�޸�����
	public boolean changeInfo();//�޸ĸ�����Ϣ
}
