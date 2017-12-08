package com.logic;

import java.util.ArrayList;

import com.dal.edit.*;
import com.dal.user.*;

public class OrdinaryUser implements User {
	private String email;//primary key
	
	private String name;
	private String password;
	private String sex;
	private String phone;
	private String introduction;//个人信息
	
	private int tot_score;//分数
	public OrdinaryUser() {
		// TODO Auto-generated constructor stub
	}
	public OrdinaryUser
	(String email,String name,String password,
			String sex,String phone,String introduction){//用于新用户注册
		this.email=email;
		this.name=name;
		this.password=password;
		this.sex=sex;
		this.phone=phone;
		this.introduction=introduction;
		tot_score=0;
	}
	
	public String toString(){
		ArrayList<String> info = new ArrayList<String>();
		info.add(email);
		info.add(name);
		info.add(password);
		info.add(sex);
		info.add(phone);
		info.add(introduction);
		info.add(""+tot_score);
		return info.toString();
	}
	
	public boolean register(){
		UserDAO userDAO = new UserDAOImplement();
        System.out.println(this+" is registered: "
        		+userDAO.insertUser(this)+" !!!(com.logic.ordinaryUser(48))");
		return userDAO.insertUser(this);
	}
	
	@SuppressWarnings("null")
	public ArrayList<Entry> getAllMyEdit(){//获得本人所有编辑过的词条属性
		EditDAO editDAO = new EditDAOImplement();
		ArrayList<EditVO> editVOList = editDAO.getEditVOByEmail(email);
		ArrayList<Entry> entryList=new ArrayList<Entry>();
		for(EditVO editVO:editVOList){
			Entry entry = new Entry(editVO);
			entryList.add(entry);
		}
		return entryList;
	}
	@Override
	public User login(String id, String password) {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAOImplement();
		OrdinaryUser ordinaryUser = userDAO.getUserByEmailAndPassword(id, password);
		if(ordinaryUser==null){
			System.out.println("ordinaryUser is null(com.logic.ordinaryUser(68))");
			return null;
		}
		else
			return ordinaryUser;
	}

	@Override
	public boolean changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAOImplement();
		if(oldPassword.equals(this.getPassword())){
			this.setPassword(newPassword);
			return userDAO.updateUser(this);
		}
		else
			return false;
	}

	@Override
	public boolean changeInfo() {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAOImplement();
		return userDAO.updateUser(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getTot_score() {
		return tot_score;
	}

	public void setTot_score(int tot_score) {
		this.tot_score = tot_score;
	}


}
