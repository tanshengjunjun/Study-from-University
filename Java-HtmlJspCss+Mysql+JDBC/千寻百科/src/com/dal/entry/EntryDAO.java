package com.dal.entry;

import java.util.ArrayList;

public interface EntryDAO {
	public EntryVO getEntryByEntryID(int entry_id);
	//ͨ������ID���Ҵ���
	public ArrayList<EntryVO> getEntryByTitle(String title);
	//ͨ�����������Ҵ����б�
	public ArrayList<EntryVO> getEntryByCateGory(String category);
	//ͨ������������Ҵ����б�
	public ArrayList<EntryVO> getEntryByIsPassed(boolean isPassed);
	//ͨ�������Ƿ�ͨ�����Ҵ����б�
	public boolean updateEntry(EntryVO entry);
	//���´���
	public boolean insertEntry(EntryVO entry);
	//�������
	public boolean deleteEntry(int entry_id);
	//ɾ������������Ա���ã�
}
