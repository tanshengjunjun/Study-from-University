package com.dal.student;

import java.util.Date;

public class StudentVO {
	private String ID;
	private String name;
	private int classNumber;//�༶
	private String major;//רҵ
	private String dept_name;//ѧԺ
	private String sex;
	private double tot_cred;//��ѧ��
	private Date birthday;//����
	private String address;//��ַ������ţ�
	private String phone;//�ֻ�����ϵ��ʽ��
	private String email;//�ʼ�����ϵ��ʽ��
	private String password;//����
	private String identification;//���֤��
	private String nation;//���� 
	private String politic;//������ò
	
	
	public StudentVO() {
		// TODO Auto-generated constructor stub
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public double getTot_cred() {
		return tot_cred;
	}

	public void setTot_cred(double tot_cred) {
		this.tot_cred = tot_cred;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPolitic() {
		return politic;
	}

	public void setPolitic(String politic) {
		this.politic = politic;
	}
	
}
