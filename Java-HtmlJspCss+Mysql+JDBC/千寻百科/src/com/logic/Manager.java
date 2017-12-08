package com.logic;

import java.util.ArrayList;

import com.dal.entry.*;
import com.dal.manager.*;

public class Manager implements User {
	private String manager_id;
	private String name;
	private String password;
	
	public ArrayList<Entry> getAllNotPassed(){
		EntryDAO dao = new EntryDAOImplement();
		ArrayList<EntryVO> entryVOList =dao.getEntryByIsPassed(false);
		ArrayList<Entry> entryList=new ArrayList<Entry>();
		for(EntryVO entryVO : entryVOList){
			Entry entry = new Entry(entryVO);
			entryList.add(entry);
		}
		return entryList;
	}
	
	public boolean passEntry(int entry_id){
		EntryDAO dao = new EntryDAOImplement();
		EntryVO entry = dao.getEntryByEntryID(entry_id);
		if(entry.isPassed()){
			System.out.println("The entry is already passed!!!");
			return false;
		}
		else{
			entry.setPassed(true);
			return dao.updateEntry(entry);
		}
	}
	
	public boolean deleteEntry(int entry_id){
		EntryDAO dao = new EntryDAOImplement();
		return dao.deleteEntry(entry_id);
	}
	
	@Override
	public User login(String id, String password) {
		// TODO Auto-generated method stub
		ManagerDAO managerDAO = new ManagerDAOImplement();
		Manager manager = managerDAO.getManagerByManagerIDAndPassword(id, password);
		if(manager==null){
			System.out.println("Manager is null(com.logic.Manager(15))");
			return null;
		}
		else
			return manager;
	}

	@Override
	public boolean changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		ManagerDAO managerDAO = new ManagerDAOImplement();
		if(oldPassword.equals(this.getPassword())){
			this.setPassword(newPassword);
			return managerDAO.updateManager(this);
		}
		else
			return false;
	}

	@Override
	public boolean changeInfo() {
		// TODO Auto-generated method stub
		ManagerDAO managerDAO = new ManagerDAOImplement();
		return managerDAO.updateManager(this);
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
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

}
