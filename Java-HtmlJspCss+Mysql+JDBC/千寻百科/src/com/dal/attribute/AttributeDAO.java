package com.dal.attribute;

import java.util.ArrayList;

public interface AttributeDAO {
	public AttributeVO getAttributeByEntryIDAndAttributeName
		(int entry_id,String attribute_name);
	//通过词条ID和属性ID查找词条属性
	public ArrayList<AttributeVO> getAttributeByEntryID(int entry_id);
	//通过词条ID查找词条属性列表
	public boolean updateAttribute(AttributeVO attribute);
	//更新词条属性
	public boolean insertAttribute(AttributeVO attribute);
	//插入词条属性
	public boolean deleteAttribute(AttributeVO attribute);
	//删除词条属性
}
