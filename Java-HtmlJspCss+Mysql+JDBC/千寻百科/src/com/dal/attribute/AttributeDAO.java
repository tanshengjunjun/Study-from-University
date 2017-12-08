package com.dal.attribute;

import java.util.ArrayList;

public interface AttributeDAO {
	public AttributeVO getAttributeByEntryIDAndAttributeName
		(int entry_id,String attribute_name);
	//ͨ������ID������ID���Ҵ�������
	public ArrayList<AttributeVO> getAttributeByEntryID(int entry_id);
	//ͨ������ID���Ҵ��������б�
	public boolean updateAttribute(AttributeVO attribute);
	//���´�������
	public boolean insertAttribute(AttributeVO attribute);
	//�����������
	public boolean deleteAttribute(AttributeVO attribute);
	//ɾ����������
}
