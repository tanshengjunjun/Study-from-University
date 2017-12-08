package com.dal.manager;

import com.logic.*;

public interface ManagerDAO {
	public Manager getManagerByManagerIDAndPassword(String managerID,String password);
	//登录（管理员调用）
	public boolean updateManager(Manager manager);
	//修改管理员信息（管理员调用）
	public boolean insertManager(Manager manager);
	//插入管理员信息（管理员调用）
	public boolean deleteManager(String managerID);
	//删除管理员信息（管理员调用）
}
