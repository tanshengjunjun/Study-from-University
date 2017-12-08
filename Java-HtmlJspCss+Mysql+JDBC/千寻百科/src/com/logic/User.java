package com.logic;

public interface User {
	public User login(String id,String password);//登录
	public boolean changePassword(String oldPassword,String newPassword);//修改密码
	public boolean changeInfo();//修改个人信息
}
