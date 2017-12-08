package com.logic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import com.dal.attribute.*;
import com.dal.edit.*;
import com.dal.entry.*;

public class Entry {
	private int entry_id;
	private String title;
	private String brief;//��Ҫ���ܣ��������
	private String category;//����
	private boolean isPassed;//�Ƿ�ͨ�����
	private Date create_date;//����ʱ��

	//���������û����ã����Բ鿴�Լ��༭�Ĵ�������
	//attribute�������
	private String attribute_name;
	private String content;
	private int order;//���
	
	//edit�������
	private int score;//��������

	public String toString(){
		ArrayList<String> list = new ArrayList<String>();
		list.add(title);
		list.add(brief);
		list.add(category);
		list.add(create_date+"");
		return list.toString();
	}
	
	private void extractEntryFromEntryVO(EntryVO entryVO){
		this.entry_id=entryVO.getEntry_id();
		this.title=entryVO.getTitle();
		this.brief=entryVO.getBrief();
		this.category=entryVO.getCategory();
		this.isPassed=entryVO.isPassed();
		this.create_date=entryVO.getCreate_date();
	}
	
	private void extractEntryFromAttributeVO(AttributeVO attributeVO){
		this.entry_id=attributeVO.getEntry_id();
		this.attribute_name=attributeVO.getAttribute_name();
		this.content=attributeVO.getContent();
		this.order=attributeVO.getOrder();
		
	}
	
	public Entry() {
		// TODO Auto-generated constructor stub
	}
	
	public Entry(String title,String brief,String category){//���ڴ�������
		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR); 
		int m = c.get(Calendar.MONTH)+1; 
		int d = c.get(Calendar.DATE); 
		String create_date=y+"-"+m+"-"+d;
		Date date = Date.valueOf(create_date);
		
		this.setTitle(title);
		this.setBrief(brief);
		this.setCategory(category);
		this.setCreate_date(date);
	}
	
	public Entry(EntryVO entryVO){
		this.extractEntryFromEntryVO(entryVO);
	}
	
	public Entry(EditVO editVO) {
		// TODO Auto-generated constructor stub
		this.entry_id=editVO.getEntry_id();
		this.attribute_name=editVO.getAttribute_name();
		this.score=editVO.getScore();
		
		//�����ݿ���Ҵ���
		EntryDAO entryDAO=new EntryDAOImplement();
		EntryVO entryVO = entryDAO.getEntryByEntryID(entry_id);
		this.extractEntryFromEntryVO(entryVO);
		//�����ݿ���Ҹô���������
		AttributeDAO attributeDAO=new AttributeDAOImplement();
		AttributeVO attributeVO=attributeDAO.getAttributeByEntryIDAndAttributeName
				(entry_id, attribute_name);
		this.extractEntryFromAttributeVO(attributeVO);
	}
	
	public static Entry searchEntry(int entry_id){
		EntryDAO dao = new EntryDAOImplement();
		Entry entry = new Entry(dao.getEntryByEntryID(entry_id));
		return entry;
	}
	
	public static ArrayList<Entry> searchEntryByTitle(String title){
		EntryDAO dao = new EntryDAOImplement();
		ArrayList<Entry> entryList = new ArrayList<Entry>();
		for(EntryVO entryVO : dao.getEntryByTitle(title)){
			Entry entry = new Entry(entryVO);
			entryList.add(entry);
		}
		return entryList;
	}
	
	public static ArrayList<Entry> searchEntryByCategory(String category){
		EntryDAO dao = new EntryDAOImplement();
		ArrayList<Entry> entryList = new ArrayList<Entry>();
		for(EntryVO entryVO : dao.getEntryByCateGory(category)){
			Entry entry = new Entry(entryVO);
			entryList.add(entry);
		}
		return entryList;
	}
	
	public boolean createEntry(){
		EntryVO entryVO = new EntryVO();
		entryVO.setTitle(title);
		entryVO.setBrief(brief);
		entryVO.setCategory(category);
		entryVO.setCreate_date(create_date);
		System.out.println("Creating entry "+this+" now...");
		
		EntryDAO dao = new EntryDAOImplement();
		boolean result = dao.insertEntry(entryVO);
		System.out.println(this+" is created: "+result);
		return result;
	}
	
	public void updateIndex(){//���ڲ��������Entry_id
		EntryDAO dao = new EntryDAOImplement();
		ArrayList<EntryVO> list = dao.getEntryByTitle(title);
		EntryVO entryVO = list.get(list.size()-1);
		this.setEntry_id(entryVO.getEntry_id());
	}
	
	public String getSummary(){//��ø��� Ҳ���ǵ�һ����������
		AttributeDAO attributeDAO=new AttributeDAOImplement();
		return attributeDAO.getAttributeByEntryIDAndAttributeName(entry_id, "����").getContent();
	}
	
	public boolean insertSummary(String summary,String userEmail){//������������ݿ� Ҳ���ǵ�һ����������
		AttributeDAO attributeDAO=new AttributeDAOImplement();
		//�������ݿ�����attribute��
		AttributeVO attribute = new AttributeVO();
		attribute.setEntry_id(entry_id);
		attribute.setAttribute_name("����");
		attribute.setContent(summary);
		attribute.setOrder(1);
		//�������ݿ�༭edit��
		EditDAO editDAO = new EditDAOImplement();
		EditVO edit = new EditVO();
		edit.setEntry_id(entry_id);
		edit.setEmail(userEmail);
		edit.setAttribute_name("����");
		edit.setScore(2);
		return attributeDAO.insertAttribute(attribute)&&editDAO.insertEditVO(edit);
	}
	
	public ArrayList<AttributeVO> getAllAttribute(){
		AttributeDAO attributeDAO=new AttributeDAOImplement();
		return attributeDAO.getAttributeByEntryID(entry_id);
	}
	
	public int getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(int entry_id) {
		this.entry_id = entry_id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isPassed() {
		return isPassed;
	}
	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getAttribute_name() {
		return attribute_name;
	}

	public void setAttribute_name(String attribute_name) {
		this.attribute_name = attribute_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
