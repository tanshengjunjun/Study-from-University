package com.logic;

import java.util.ArrayList;

public class Manager implements User{
	private String name;
	private String ID;
	private String password;
//	public boolean managerLogin(String ID,String password){
//		if(ID.equals(this.ID)&&password.equals(this.password))
//			return true;
//		else
//			return false;
//	}
	public boolean studentManage(){//
		return false;
	} 
	public boolean teacherManage(){//
		return false;
	} 
	public boolean courseManage(){//
		return false;
	}

	@Override
	public Object login(String ID, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ArrayList<String> showInfoToMyself() {
		// TODO Auto-generated method stub
		return null;
	} 
	@Override
	public ArrayList<String> showInfoToOthers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean setInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
}
