package com.dal.manager;

import com.logic.*;

public interface ManagerDAO {
	public Manager getManagerByManagerIDAndPassword(String managerID,String password);
	//��¼������Ա���ã�
	public boolean updateManager(Manager manager);
	//�޸Ĺ���Ա��Ϣ������Ա���ã�
	public boolean insertManager(Manager manager);
	//�������Ա��Ϣ������Ա���ã�
	public boolean deleteManager(String managerID);
	//ɾ������Ա��Ϣ������Ա���ã�
}
