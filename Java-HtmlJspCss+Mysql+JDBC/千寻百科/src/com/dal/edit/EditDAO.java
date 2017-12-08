package com.dal.edit;

import java.util.ArrayList;

public interface EditDAO {
	public ArrayList<EditVO> getEditVOByEmail(String email);
	//ͨ���û�ID�����û��༭�Ĵ�������
	public boolean updateEditVO(EditVO edit);
	//�����û��༭���Ա�
	public boolean insertEditVO(EditVO edit);
	//�����û��༭���Ա�
	public boolean deleteEditVO(EditVO edit);
	//ɾ���û��༭���Ա�
}
