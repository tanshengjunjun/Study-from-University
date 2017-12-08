package com.dal.user;

import com.logic.*;

public interface UserDAO {
	public OrdinaryUser getUserByEmail(String email);
	//ͨ���û�ID��ѯ�û���Ϣ������Ա���ã�
	public OrdinaryUser getUserByEmailAndPassword(String email,String password);
	//��¼���û����ã�
	public boolean updateUser(OrdinaryUser ordinaryUser);
	//�޸��û�������Ϣ���û����ã�
	public boolean insertUser(OrdinaryUser ordinaryUser);
	//�����û���Ϣ��ע�ᣨ�û����ã�
	public boolean deleteUser(String email);
	//ɾ���û���Ϣ������Ա���ã�
}
