package com.logic;

import java.util.ArrayList;

public interface User {
	public Object login(String ID,String password);//登录
	public boolean changePassword(String oldPassword,String newPassword);//修改密码
	
	public ArrayList<String> showInfoToMyself();//自己调用查看个人信息
	public boolean setInfo();//自己调用修改个人信息（要有被修改的参数）
	public ArrayList<String> showInfoToOthers();//别人调用查看个人信息（部分信息不显示）
}
