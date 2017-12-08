package com.dal.section;

import java.util.ArrayList;
//�����ݿ��е�Course����һ����ѧ�������������пγ̣���Щ�γ̿������ɲ���һ��ʵ����
//��Section��һ��ʵ������ʦ�̵���Section��ѧ��ѧ��Ҳ��Section��
//��һ�����ӣ�������ȥ�����Է����ټ������������һ������������
//�㿴���Ĳ˵�����һ��Course������˵��ϵ��κ�һ���˾���Course���е�һ��value��
//��ĳ��ʱ�䣬�����������ĳ��������������ÿһ���˼���������һ��Section��
//�������Ե�������һ���ˣ�����һ��takes�������teaches���е�һ��value��
//���ڴ�ѧ���ݿ⣬ѧ���ͽ�ʦ�ܿ����ľ���Section��������Ա���Զ�Course����й���
public interface SectionDAO {
	public SectionVO getSectionVOBySectionKey(String course_id,String sec_id,String semester,int year);
	//ͨ��Section���������Section�γ̣�����Ա���ã�
	public ArrayList<SectionVO> getSectionVOListBySemesterAndYear(String semester,int year);
	//ͨ��ѧ�ں�ѧ�����Section�γ̱�ѧ�����ã�
	public boolean updateSectionInfo(SectionVO sectionVO);
	//���¿γ̣�����Ա���ã�
	public boolean insertSection(SectionVO sectionVO);
	//����γ̣����������ĿΣ�������Ա���ã�
	public boolean deleteSection(SectionVO sectionVO);
	//ɾ���γ̣�����Ա���ã�
}
