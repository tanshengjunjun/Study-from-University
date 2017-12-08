package com.dal.entry;

import java.util.ArrayList;

public interface EntryDAO {
	public EntryVO getEntryByEntryID(int entry_id);
	//通过词条ID查找词条
	public ArrayList<EntryVO> getEntryByTitle(String title);
	//通过词条名查找词条列表
	public ArrayList<EntryVO> getEntryByCateGory(String category);
	//通过词条种类查找词条列表
	public ArrayList<EntryVO> getEntryByIsPassed(boolean isPassed);
	//通过词条是否通过查找词条列表
	public boolean updateEntry(EntryVO entry);
	//更新词条
	public boolean insertEntry(EntryVO entry);
	//插入词条
	public boolean deleteEntry(int entry_id);
	//删除词条（管理员调用）
}
