package com.dal.edit;

import java.util.ArrayList;

public interface EditDAO {
	public ArrayList<EditVO> getEditVOByEmail(String email);
	//通过用户ID查找用户编辑的词条属性
	public boolean updateEditVO(EditVO edit);
	//更新用户编辑属性表
	public boolean insertEditVO(EditVO edit);
	//插入用户编辑属性表
	public boolean deleteEditVO(EditVO edit);
	//删除用户编辑属性表
}
