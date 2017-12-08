package com.logic;

import com.dal.section.*;
import com.dal.teacher.*;
import com.dal.teaches.*;
import com.dal.course.*;

import java.util.ArrayList;

//�߼��ϵĿ���һ�����࣬Ҳ���Ӻ���ʵ�еĿ�������
//�Ӹ�������������һ��Teaches���ݡ�
//���Ұ��������ݿ���Course��Section��Teacher��ֵ����

public class Course{
	private String teacher_id;
	//����ΪSection�������
	private String course_id;//�γ̴���
	private String sec_id;
	private String semester;//ѧ��
	private int year;//ѧ��
//	private String room_number;//�Ͽεص�
//	private int time_slot_id;//ѧʱ
//	private String classtime;//�Ͽ�ʱ��
	
//	****************û��ʵ���Ͽ�ʱ�书��********************
	
	//����ΪCourse�������
	private String title;//�γ���
	private double credits;//�γ�ѧ��
	private String dept_name;//ѧԺ
	private int capacity;//����
	
	//������ֵ����
	private SectionVO sectionVO;
	private CourseVO courseVO;
	private TeacherVO teacherVO;
	
	//����Ϊ�����߼���ӵ�����
	private static int left;//����
	private String code;//�ϲ�Course_id��Sec_id����ʾΪ�γ̴���
	
	public Course(TeachesVO teachesVO){
		//�������TeachesVO����
		this.teacher_id=teachesVO.getID();
		this.course_id=teachesVO.getCourse_id();
		this.sec_id=teachesVO.getSec_id();
		this.semester=teachesVO.getSemester();
		this.year=teachesVO.getYear();
		
		//���ֵ����
		SectionDAO sectionDAO = new SectionDAOImplement();
		this.sectionVO=sectionDAO.getSectionVOBySectionKey(course_id, sec_id, semester, year);
		
		CourseDAO courseDAO = new CourseDAOImplement();
		this.courseVO=courseDAO.getCourseVOByCourseID(course_id);
		
		TeacherDAO teacherDAO = new TeacherDAOImplement();
		this.teacherVO=teacherDAO.getTeacherVOByTeacherID(teacher_id);
		
		//���������߼��ϵ�����
		code=course_id+sec_id;//�γ̴���=course_id+sec_id
		capacity=courseVO.getCapacity();
		left=capacity;
	}
	public ArrayList<String> showCourseInfo(String course_id){//��ʾ�γ���Ϣ
		return null;
//		String[] sectionInfo = {code,title,teacher.getName(),classtime,classroom,"",credits+"",capacity+"",left+""};//��һ�����ǿγ̽���
//		return sectionInfo;
	}
//	public String showCourseList(String studentID){//
//		return null;
//	}
	//public Teacher getTeacherInfo(String course_ID){}
}
