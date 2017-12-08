package com.dal.user;

import com.logic.*;

public interface UserDAO {
	public OrdinaryUser getUserByEmail(String email);
	//通过用户ID查询用户信息（管理员调用）
	public OrdinaryUser getUserByEmailAndPassword(String email,String password);
	//登录（用户调用）
	public boolean updateUser(OrdinaryUser ordinaryUser);
	//修改用户个人信息（用户调用）
	public boolean insertUser(OrdinaryUser ordinaryUser);
	//插入用户信息、注册（用户调用）
	public boolean deleteUser(String email);
	//删除用户信息（管理员调用）
}
