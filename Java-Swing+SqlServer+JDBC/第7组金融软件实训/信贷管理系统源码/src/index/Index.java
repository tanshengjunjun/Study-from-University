package index;
import javax.swing.*;

import java.awt.FlowLayout;
import java.lang.*;
import java.sql.Date;
import java.awt.event.*;
import java.awt.*;
import java.*;

import java.text.SimpleDateFormat;

import javax.swing.table.*;

import DataAccessLayer.*;
import jdbconnection.*;

public class Index extends JFrame{
	public static JTextField jtfUserName,jtfPassword;
	public Index(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		//create log on button and create JTextfield and so on
		JButton jbtLogOn=new JButton("log on");
		//add buttons into the frame
		JLabel jlbUserName=new JLabel("username");
		jtfUserName=new JTextField(4);
		JLabel jlbPassword=new JLabel("password");
		jtfPassword=new JTextField(4);

		/*add(new JLabel("username"));
		add(new JTextField("username"));
		add(new JLabel("password"));
		add(new JTextField("password"));
		add(jbtLogOn);
		*/
		
		//register listeners
		LogOnListenerClass logOnListener=new LogOnListenerClass();
		jbtLogOn.addActionListener(logOnListener);
		add(jbtLogOn);
		add(jlbUserName);
		add(jtfUserName);
		add(jlbPassword);
		add(jtfPassword);
		setTitle("��¼��");
		setSize(400,300);//Set functionSelectFrame size
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//ע�ᴰ�ڼ����������frame���������ڿ����¼��͹رգ��Ӷ�����ʼ��ֻ��һ������
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
			}
		});
	}
		public static void main(String[]args){
			Index index=new Index();
			/*
			Index loFrame=new Index();
			//��log on frame���Ժ�Ľ���frame��������
		loFrame.setTitle("functionSelectFrame");
		loFrame.setSize(400,300);//Set functionSelectFrame size
		loFrame.setLocationRelativeTo(null);
		loFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loFrame.setVisible(true);
		*/
	}
		//���ڷ���JTextField�Ա��ȡJTextField�е�����
	public static JTextField getJTextField(JTextField jtf){
		return jtf;
	}
}


class FunctionSelectFrame extends JFrame{
	 FunctionSelectFrame(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		//create log on button and create JTextfield and so on
		JButton jbtCustomerManage=new JButton("�ͻ�����");
		JButton jbtServiceManage=new JButton("ҵ�����");
		JButton jbtInterestManage=new JButton("��Ϣ����");
		JButton jbtStaffManage=new JButton("��Ա����");
		JButton jbtSystemManage=new JButton("ϵͳ����");
		JButton jbtQueryCount=new JButton("��ѯͳ��");
		//���ϻ��˼�
		JButton jbtLogOut=new JButton("ע��");
		//add JButtons into the frame
		add(jbtCustomerManage);
		add(jbtServiceManage);
		add(jbtInterestManage);
		add(jbtStaffManage);
		add(jbtSystemManage);
		add(jbtQueryCount);
		
		add(jbtLogOut);
		
		//register ActionListener
		JbtCustomerManageListenerClass jbtCustomerManageListener=new JbtCustomerManageListenerClass();
		JbtServiceManageListenerClass jbtServiceManageListener=new JbtServiceManageListenerClass();
		JbtInterestManageListenerClass jbtInterestManageListener=new JbtInterestManageListenerClass();
		JbtStaffManageListenerClass jbtStaffManageListener=new JbtStaffManageListenerClass();
		JbtSystemManageListenerClass jbtSystemManageListener=new JbtSystemManageListenerClass();
		JbtQueryCountListenerClass jbtQueryCountListener=new JbtQueryCountListenerClass();
		jbtCustomerManage.addActionListener(jbtCustomerManageListener);
		jbtServiceManage.addActionListener(jbtServiceManageListener);
		jbtInterestManage.addActionListener(jbtInterestManageListener);
		jbtStaffManage.addActionListener(jbtStaffManageListener);
		jbtSystemManage.addActionListener(jbtSystemManageListener);
		jbtQueryCount.addActionListener(jbtQueryCountListener);
		
		JbtLogOutListenerClass jbtLogOutListener=new JbtLogOutListenerClass();
		jbtLogOut.addActionListener(jbtLogOutListener);

		//set FunctionSelectFrame's attributes
		setTitle("����ѡ��");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
			}
		});
		/*
		//add buttons into the frame
		add(new JButton("�ͻ�����"));
		add(new JButton("ҵ�����"));
		add(new JButton("��Ϣ����"));
		add(new JButton("��Ա����"));
		add(new JButton("ϵͳ����"));
		add(new JButton("��ѯͳ��"));
		*/
	}
}
/*
 * 
 * 
 *��ӷ��ذ�ť
 * 			JButton jbtReturn=new JButton("����");
 * 			add(jbtReturn);
 * 			JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
			jbtReturn.addActionListener(jbtReturnListener);
 * 
 */
class CustomerManage extends JFrame{
		public CustomerManage(){
			setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
			JButton jbtCustomerInfoMaintain=new JButton("�ͻ���Ϣά��");
			JButton jbtCustomerCreditEvaluate=new JButton("�ͻ���������");
			JButton jbtReturn=new JButton("����");
			
			add(jbtCustomerInfoMaintain);
			add(jbtCustomerCreditEvaluate);
			add(jbtReturn);
			
			JbtCustomerInfoMaintainListenerClass jbtCustomerInfoMaintainListener=new JbtCustomerInfoMaintainListenerClass();
			jbtCustomerInfoMaintain.addActionListener(jbtCustomerInfoMaintainListener);
			JbtCustomerCreditEvaluateListenerClass jbtCustomerCreditEvaluateListener=new JbtCustomerCreditEvaluateListenerClass();
			jbtCustomerCreditEvaluate.addActionListener(jbtCustomerCreditEvaluateListener);
			JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
			jbtReturn.addActionListener(jbtReturnListener);
			
			setTitle("�ͻ�����");
			setSize(400,300);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			addWindowListener(new WindowAdapter(){
				public void windowDeactivated(WindowEvent e){
					setVisible(false);
			//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
				}
			});
			//add buttons into the frame
			/*
			add(new JButton("�ͻ���Ϣά��"));
			add(new JButton("�ͻ���������"));
			*/
		}
}

class ServiceManage extends JFrame{
	public ServiceManage(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		JButton jbtLendManage=new JButton("�Ŵ�����");
		JButton jbtFifthSeparate=new JButton("�弶���");
		JButton jbtOverdueManage=new JButton("���ڹ���");
		JButton jbtReturn=new JButton("����");
		add(jbtLendManage);
		add(jbtFifthSeparate);
		add(jbtOverdueManage);
		add(jbtReturn);
		//register ActionListener
		JbtLendManageListenerClass jbtLendManageListener=new JbtLendManageListenerClass();
		JbtFifthSeparateListenerClass jbtFifthSeparateListener=new JbtFifthSeparateListenerClass();
		JbtOverdueManageListenerClass jbtOverdueManageListener=new JbtOverdueManageListenerClass();
		jbtLendManage.addActionListener(jbtLendManageListener);
		jbtFifthSeparate.addActionListener(jbtFifthSeparateListener);
		jbtOverdueManage.addActionListener(jbtOverdueManageListener);
		
		JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
		jbtReturn.addActionListener(jbtReturnListener);
		
		setTitle("ҵ�����");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
			}
		});
		/*
		//add buttons into the frame
		add(new JButton("�Ŵ�����"));
		add(new JButton("�弶���"));
		add(new JButton("���ڹ���"));
		*/
	}
}

class InterestManage extends JFrame{
	public InterestManage(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		JButton jbtInterestCalculate=new JButton("��Ϣ����");
		JButton jbtInterestEnter=new JButton("��Ϣ����");
		JButton jbtReturn=new JButton("����");
		add(jbtInterestCalculate);
		add(jbtInterestEnter);
		add(jbtReturn);
		//register
		JbtInterestCalculateListenerClass jbtInterestCalculateListener=new JbtInterestCalculateListenerClass();
		JbtInterestEnterListenerClass jbtInterestEnterListener=new JbtInterestEnterListenerClass();
		jbtInterestCalculate.addActionListener(jbtInterestCalculateListener);
		jbtInterestEnter.addActionListener(jbtInterestEnterListener);
		
		JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
		jbtReturn.addActionListener(jbtReturnListener);
		
		setTitle("��Ϣ����");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
			}
		});
	}
}

class StaffManage extends JFrame{
	public StaffManage(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		JButton jbtStaffInfoManage=new JButton("��Ա��Ϣ����");
		JButton jbtPerformanceCheck=new JButton("��Ա��Ч����");
		JButton jbtReturn=new JButton("����");
		add(jbtStaffInfoManage);
		add(jbtPerformanceCheck);
		add(jbtReturn);
		//register
		JbtStaffInfoManageListenerClass jbtStaffInfoManageListener=new JbtStaffInfoManageListenerClass();
		JbtPerformanceCheckListenerClass jbtPerformanceCheckListener=new JbtPerformanceCheckListenerClass();
		jbtStaffInfoManage.addActionListener(jbtStaffInfoManageListener);
		jbtPerformanceCheck.addActionListener(jbtPerformanceCheckListener);
		
		JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
		jbtReturn.addActionListener(jbtReturnListener);
		
		setTitle("��Ա����");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
			}
		});
		
		/*
		//add buttons into the frame
		add(new JButton("��Ա��Ϣ����"));
		add(new JButton("��Ա��Ч����"));
		*/
	}
}

class SystemManage extends JFrame{
	public SystemManage(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		JButton jbtAdministratorManage=new JButton("����Ա����");
		JButton jbtDataManage=new JButton("���ݹ���");
		JButton jbtArgumentManage=new JButton("��������");
		JButton jbtReturn=new JButton("����");
		add(jbtAdministratorManage);
		add(jbtDataManage);
		add(jbtArgumentManage);
		add(jbtReturn);
		
		JbtAdministratorManageListenerClass jbtAdministratorManageListener=new JbtAdministratorManageListenerClass();
		JbtDataManageListenerClass jbtDataManageListener=new JbtDataManageListenerClass();
		JbtArgumentManageListenerClass jbtArgumentManageListener=new JbtArgumentManageListenerClass();
		jbtAdministratorManage.addActionListener(jbtAdministratorManageListener);
		jbtDataManage.addActionListener(jbtDataManageListener);
		jbtArgumentManage.addActionListener(jbtArgumentManageListener);
		
		JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
		jbtReturn.addActionListener(jbtReturnListener);
		
		setTitle("ϵͳ����");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
			}
		});	
		
		/*
		//add buttons into the frame
		add(new JButton("����Ա����"));
		add(new JButton("���ݹ���"));
		add(new JButton("��������"));
		*/
	}
}
class QueryCount extends JFrame{
	public QueryCount(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		JButton jbtQuery=new JButton("��ѯ");
		JButton jbtReturn=new JButton("����");
		add(jbtQuery);
		add(jbtReturn);
		
		JbtQueryListenerClass jbtQueryListener=new JbtQueryListenerClass();
		jbtQuery.addActionListener(jbtQueryListener);
		
		JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
		jbtReturn.addActionListener(jbtReturnListener);
		
		setTitle("��ѯ��");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
			}
		});	
		
		/*
		//add buttons into the frame
		add(new JButton("��ѯ"));
		*/
	}
}


//����JFrame��
//�ͻ�����JFrame2��

		/*
	setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
	//��ӿͻ����ϱ��JLabel��JTextField
	add(new JLabel("�ͻ���"));
	JTextField khid=new JTextField(10);
	add(khid);
	add(new JLabel("�ͻ�����"));
	JTextField name=new JTextField(10);
	add(name);
	add(new JLabel("�ͻ�����"));
	JTextField khzl=new JTextField(10);
	add(khzl);
	add(new JLabel("�ͻ���ַ"));
	JTextField khdz=new JTextField(10);
	add(khdz);
	add(new JLabel("�ͻ��绰"));
	JTextField khdh=new JTextField(10);
	add(khdh);
	add(new JLabel("֤�����루Ψһʶ���룩"));
	JTextField zjhm=new JTextField(10);
	add(zjhm);
	add(new JLabel("�ʱ�"));
	JTextField post=new JTextField(10);
	add(post);
	add(new JLabel("���ʵ�ַ"));
	JTextField email=new JTextField(10);
	add(email);
	add(new JLabel("�ױʴ����˺�"));
	JTextField account=new JTextField(10);
	add(account);
	add(new JLabel("������"));
	JTextField dkje=new JTextField(10);
	add(dkje);
	add(new JLabel("����������"));
	JTextField khhmc=new JTextField(10);
	add(khhmc);
	add(new JLabel("�������˻�"));
	JTextField jbhzh=new JTextField(10);
	add(jbhzh);
	add(new JLabel("�����˺�"));
	JTextField jszh=new JTextField(10);
	add(jszh);
	add(new JLabel("��������"));
	JTextField xypj=new JTextField(10);
	add(xypj);
	add(new JLabel("�����Ŵ�Ա��"));
	JTextField xdyh=new JTextField(10);
	add(xdyh);
	//add JButtons
	JButton add=new JButton("����");
	JButton modify=new JButton("�޸�");
	JButton jbtReturn=new JButton("����");
	add(add);
	add(modify);
	add(jbtReturn);
	
	    public StaffInfoManage()  
    {  
        intiComponent();  
    }  
  */
class CustomerInfoMaintain extends JFrame{
	public static JTable table;
	public CustomerInfoMaintain(){
	 intiComponent();
	}
    /** 
     * ��ʼ��������� 
     */  
    private void intiComponent()  
    {  setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
        /* 
         * ����JTable������ 
         */  
        String[] columnNames =  
        { "�ͻ���", "�ͻ�����", "�ͻ�����", "�ͻ���ַ", "�ͻ��绰" ,
        		"֤������","�ʱ�","���ʵ�ַ","�ױʴ����˺�","������",
        		"����������","�������˻�","�����ʺ�","��������","�ϼ���λ","�����Ŵ�Ա��"};  
  
        /* 
         * ��ʼ��JTable��������ֵ����������һģһ����ʵ��"�Կ���"ѧ���� 
         */  
        Object[][] obj = new Object[2][16];  
        for (int i = 0; i < 1; i++)  
        {  
            for (int j = 0; j < 16; j++)  
            {  
                switch (j)  
                {  
                case 0:  
                    obj[i][j] = "001";  
                    break;  
                case 1:  
                    obj[i][j] = "����";  
                    break;  
                case 2:  
                    obj[i][j] = "2����";  
                    break;  
                case 3:  
                    obj[i][j] = "��������ѧ";  
                    break;  
                case 4:  
                    obj[i][j] = "188";  
                    break;  
                case 5:  
                    obj[i][j] = "440";  
                    break;  
                case 6:
                	obj[i][j]="510006";
                	break;
                case 7:
                	obj[i][j]="163";
                	break;
                case 8:
                	obj[i][j]="111";
                	break;
                case 9:
                	obj[i][j]="100000";
                	break;
                case 10:
                	obj[i][j]="����";
                	break;
                case 11:
                	obj[i][j]="112";
                	break;
                case 12:
                	obj[i][j]="11 3";
                	break;
                case 13:
                	obj[i][j]="5";
                	break;
                case 14:
                	obj[i][j]="�ϼ���λ1";
                	break;
                case 15:
            	obj[i][j]="0001";
            	break;
                }  
            }  
        }  
          
          
        /* 
         * JTable������һ�ֹ��췽�� 
         */  
        table = new JTable(obj, columnNames);  
        /* 
         * ����JTable����Ĭ�ϵĿ�Ⱥ͸߶� 
         */  
        //�Լ��ӵģ�������뵽JFrame��
        add(table); 
        setSize(200,400);
        /* 
         * ����JTable�Զ������б��״̬���˴�����Ϊ�ر� 
         */  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
          
        /*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/  
        JScrollPane scroll = new JScrollPane(table);  
        scroll.setSize(200,100); 
          
      //add JButtons
    	JButton add=new JButton("����");
    	JButton modify=new JButton("�޸�");
    	JButton delete=new JButton("ɾ��");
    	JButton jbtReturn=new JButton("����");
    	add(add);
    	add(modify);
    	add(delete);
    	add(jbtReturn);
    	
    	//register ActionListener
    	CustomerAddListenerClass addListener=new CustomerAddListenerClass();
    	CustomerModifyListenerClass modifyListener=new CustomerModifyListenerClass(); 
    	CustomerDeleteListenerClass deleteListener=new CustomerDeleteListenerClass();
    	add.addActionListener(addListener);
    	modify.addActionListener(modifyListener);
    	delete.addActionListener(deleteListener);
    	JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
    	jbtReturn.addActionListener(jbtReturnListener);
          
    	addWindowListener(new WindowAdapter(){
    		public void windowDeactivated(WindowEvent e){
    			setVisible(false);
    	//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
    		}
    	});
    	
        add(scroll);  
        this.setVisible(true);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.pack();  

        }
        	public static JTable getTable(){
        		return table;
        	}
       }

   
    	
  


class CustomerCreditEvaluate extends JFrame{
	
}
//ҵ�����JFrame3��
class LendManage extends JFrame{
	public static JTable table;
	public LendManage(){
	 intiComponent();
	}
	public void intiComponent(){
		setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
        /* 
         * ����JTable������ 
         */  
        String[] columnNames =  
        { "���������", "�ͻ���", "��������", "��������", "������;" ,
        		"���Χ","�����ѺƷ","��ѺƷ���","�����˿ͻ���","������",
        		"�ʲ������","��������","��������","�Ŵ���־","�����˱��","�����˻�","�����ͬ��","�����ͬ���","�����ͬ����","���ʽ","ÿ�ڻ�����","�����Ŵ�Ա"};
        
        Object[][] obj=new Object[2][22];
       
        table = new JTable(obj, columnNames);  
        add(table); 
        setSize(200,400);
        /* 
         * ����JTable�Զ������б��״̬���˴�����Ϊ�ر� 
         */  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
          
        /*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/  
        JScrollPane scroll = new JScrollPane(table);  
        scroll.setSize(200,100); 
        add(scroll);

	//add JButtons
	JButton add=new JButton("����");
	JButton modify=new JButton("�޸�");
	JButton delete=new JButton("ɾ��");
	JButton jbtReturn=new JButton("����");
	add(add);
	add(modify);
	add(delete);
	add(jbtReturn);
	
	//register ActionListener
	LendManageAddListenerClass lendManageaddListener=new LendManageAddListenerClass();
	LendManageModifyListenerClass lendManagemodifyListener=new LendManageModifyListenerClass(); 
	LendManageDeleteListenerClass lendManagedeleteListener=new LendManageDeleteListenerClass();
	add.addActionListener(lendManageaddListener);
	modify.addActionListener(lendManagemodifyListener);
	delete.addActionListener(lendManagedeleteListener);
	JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
	jbtReturn.addActionListener(jbtReturnListener);
	
	setTitle("�Ŵ�����");
	setSize(800,1500);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
	addWindowListener(new WindowAdapter(){
		public void windowDeactivated(WindowEvent e){
			setVisible(false);
	//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
		}
	});
	
	}
	public static JTable getTable(){
		return table;
	}
}
class FifthSeparate extends JFrame{
	//�˴������Ϣ���๦��
	//�Ŵ�����
	public static JTable table;
	public FifthSeparate(){
	 intiComponent();
	}
	public void intiComponent(){
		setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
        /* 
         * ����JTable������ 
         */  
        String[] columnNames =  
        { "������", "�ͻ���", "���������", "��Ŀ��", "����ʹ�ñ�־" ,
        "�����־","�����弶����","�����������","���ʼ����","���������",
        "����չ������","���������","����Ϣ����","�������","ʵ������","չ������","Ԥ������","��������"};
        
        Object[][] obj=new Object[2][18];
       
        table = new JTable(obj, columnNames);  
        add(table); 
        setSize(200,400);
        /* 
         * ����JTable�Զ������б��״̬���˴�����Ϊ�ر� 
         */  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
          
        /*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/  
        JScrollPane scroll = new JScrollPane(table);  
        scroll.setSize(200,100); 
        add(scroll);

	//add JButtons
	JButton add=new JButton("����");
	JButton modify=new JButton("�޸�");
	JButton delete=new JButton("ɾ��");
	JButton jbtReturn=new JButton("����");
	add(add);
	add(modify);
	add(delete);
	add(jbtReturn);
	
	//register ActionListener
	FifthSeparateAddListenerClass fifthSeparateaddListener=new FifthSeparateAddListenerClass();
	FifthSeparateModifyListenerClass fifthSeparatemodifyListener=new FifthSeparateModifyListenerClass(); 
	FifthSeparateDeleteListenerClass fifthSeparatedeleteListener=new FifthSeparateDeleteListenerClass();
	add.addActionListener(fifthSeparateaddListener);
	modify.addActionListener(fifthSeparatemodifyListener);
	delete.addActionListener(fifthSeparatedeleteListener);
	JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
	jbtReturn.addActionListener(jbtReturnListener);
	
	setTitle("�弶���(����ֻ���)");
	setSize(800,1500);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
	addWindowListener(new WindowAdapter(){
		public void windowDeactivated(WindowEvent e){
			setVisible(false);
	//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
		}
	});
	
	}
	public static JTable getTable(){
		return table;
	}
	
}
class OverdueManage extends JFrame{
	
}
//��Ϣ����JFrame3��
class InterestCalculate extends JFrame{
	public static JTable table;
	public InterestCalculate(){
	 intiComponent();
	}
	public void intiComponent(){
		setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
        /* 
         * ����JTable������ 
         */  
        String[] columnNames =  
        { "��Ϣ���", "����Ϣ���", "��Ϣ��־", "�����˺�", "�������" ,
        		"��Ϣ�������","��Ϣ��ʼ����","��Ϣ��������","��Ϣ��������","��Ϣ��������",
        		"����","��Ϣ��","��Ϣ�����־"};
        
        Object[][] obj=new Object[2][13];
       
        table = new JTable(obj, columnNames);  
        add(table); 
        setSize(200,400);
        /* 
         * ����JTable�Զ������б��״̬���˴�����Ϊ�ر� 
         */  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
          
        /*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/  
        JScrollPane scroll = new JScrollPane(table);  
        scroll.setSize(200,100); 
        add(scroll);

	//add JButtons
	JButton add=new JButton("����");
	JButton modify=new JButton("�޸�");
	JButton delete=new JButton("ɾ��");
	JButton jbtReturn=new JButton("����");
	add(add);
	add(modify);
	add(delete);
	add(jbtReturn);
	
	//register ActionListener
	InterestCalculateAddListenerClass interestCalculateaddListener=new InterestCalculateAddListenerClass();
	InterestCalculateModifyListenerClass interestCalculatemodifyListener=new InterestCalculateModifyListenerClass(); 
	InterestCalculateDeleteListenerClass interestCalculatedeleteListener=new InterestCalculateDeleteListenerClass();
	add.addActionListener(interestCalculateaddListener);
	modify.addActionListener(interestCalculatemodifyListener);
	delete.addActionListener(interestCalculatedeleteListener);
	JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
	jbtReturn.addActionListener(jbtReturnListener);
	
	setTitle("��Ϣ����");
	setSize(800,1500);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
	addWindowListener(new WindowAdapter(){
		public void windowDeactivated(WindowEvent e){
			setVisible(false);
	//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
		}
	});
	
	}
	public static JTable getTable(){
		return table;
	}
}
class InterestEnter extends JFrame{
	
}
//��Ա����JFrame3��
class StaffInfoManage extends JFrame{ //JAVA���ܶ�̳�
  	    public StaffInfoManage()  
	    {  
	        intiComponent();  
	    }  
	  
	    /** 
	     * ��ʼ��������� 
	     */  
	    private void intiComponent()  
	    {  setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
	        /* 
	         * ����JTable������ 
	         */  
	        String[] columnNames =  
	        { "��Ա����", "����", "�Ա�", "��ͥ��ַ", "���֤��" ,"�ֻ���","ϵͳ��ɫ"};  
	  
	        /* 
	         * ��ʼ��JTable��������ֵ����������һģһ����ʵ��"�Կ���"ѧ���� 
	         */  
	        Object[][] obj = new Object[2][8];  
	        for (int i = 0; i < 2; i++)  
	        {  
	            for (int j = 0; j < 8; j++)  
	            {  
	                switch (j)  
	                {  
	                case 0:  
	                    obj[i][j] = "001";  
	                    break;  
	                case 1:  
	                    obj[i][j] = "����";  
	                    break;  
	                case 2:  
	                    obj[i][j] = "��";  
	                    break;  
	                case 3:  
	                    obj[i][j] = "��������ѧ";  
	                    break;  
	                case 4:  
	                    obj[i][j] = "440222199101111217";  
	                    break;  
	                case 5:  
	                    obj[i][j] = "13025364591";  
	                    break;  
	                case 6:
	                	obj[i][j]="����Ա";
	                	break;
	                }  
	            }  
	        }  
	          
	          
	        /* 
	         * JTable������һ�ֹ��췽�� 
	         */  
	        JTable table = new JTable(obj, columnNames);  
	        /* 
	         * ����JTable����Ĭ�ϵĿ�Ⱥ͸߶� 
	         */  
	        //�Լ��ӵģ�������뵽JFrame��
	        add(table); 
	        setSize(1000,1000);
	        /* 
	         * ����JTable�Զ������б��״̬���˴�����Ϊ�ر� 
	         */  
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);  
	          
	        /*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/  
	        JScrollPane scroll = new JScrollPane(table);  
	        scroll.setSize(1500,1500);  
	          
	      //add JButtons
	    	JButton add=new JButton("����");
	    	JButton modify=new JButton("�޸�");
	    	JButton jbtReturn=new JButton("����");
	    	add(add);
	    	add(modify);
	    	add(jbtReturn);
	    	
	    	//register ActionListener
	    	AddListenerClass addListener=new AddListenerClass();
	    	ModifyListenerClass modifyListener=new ModifyListenerClass(); 
	    	add.addActionListener(addListener);
	    	modify.addActionListener(modifyListener);
	    	JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
	    	jbtReturn.addActionListener(jbtReturnListener);
	          
	    	addWindowListener(new WindowAdapter(){
	    		public void windowDeactivated(WindowEvent e){
	    			setVisible(false);
	    	//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
	    		}
	    	});
	    	
	        add(scroll);  
	        this.setVisible(true);  
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        this.pack();  
	    }  
}
class PerformanceCheck extends JFrame{
	
}
//ϵͳ����JFrame3��
class AdministratorManage extends JFrame{
	
}
class DataManage extends JFrame{
	
} 
class ArgumentManage extends JFrame{
	
}
//��ѯ����JFrame3��
//�ޣ���ѯ����ֻ��2��




/*
 * 
 * 
 * 
 * XListenerClass
 * 
 * 
 * 
 */
//XListenerClass 1��
class LogOnListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e)                           
	{//��֤���������û�����
		if(Integer.parseInt(((Index.getJTextField(Index.jtfUserName)).getText()).toString())==2014
				&&Integer.parseInt(((Index.getJTextField(Index.jtfPassword)).getText()).toString())==0000){
			FunctionSelectFrame fsfFrame =new FunctionSelectFrame();
		}
		else{
			try{
			JFrame f=new JFrame();
			JLabel l=new JLabel("�˺��������");
			f.add(l);
			f.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
			f.setSize(400, 150);
			f.setTitle("�˺��������");
			f.setVisible(true);
			Thread.sleep(5000);
			f.setVisible(false);
			Index index=new Index(); 
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		/*
		frame.setSize(400,300);//Set functionSelectFrame size
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loFrame.setVisible(false);
		frame.setVisible(true);
		*/
	}
}
//XListenerClass 2��
class JbtCustomerManageListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		CustomerManage cmFrame=new CustomerManage();
	}
}
class JbtServiceManageListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		ServiceManage smFrame=new ServiceManage();
	}
}
class JbtInterestManageListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		InterestManage imFrame=new InterestManage();
	}
}
class JbtStaffManageListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		StaffManage staffmFrame=new StaffManage();
	}
}
class JbtSystemManageListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		SystemManage systemmFrame=new SystemManage();
	}
}
class JbtQueryCountListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		QueryCount qcFrame=new QueryCount();
	}
}
class JbtLogOutListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		Index index=new Index();
	}
}

//
//XListenerClass 3��
//

//�ͻ�����listenerclass3��
class JbtCustomerInfoMaintainListenerClass implements ActionListener{
	
	public void actionPerformed(ActionEvent e)
	{
		CustomerInfoMaintain cimFrame=new CustomerInfoMaintain();
	}
}
class JbtCustomerCreditEvaluateListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e)
	{
		CustomerCreditEvaluate cceFrame=new CustomerCreditEvaluate();
	}
}
class JbtReturnListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e)
	{
		FunctionSelectFrame fsfFrame =new FunctionSelectFrame();
	}
}
//ҵ�����listenerclass33��
class JbtLendManageListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e)
	{
		LendManage lmFrame=new LendManage();
	}
}
class JbtFifthSeparateListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e)
	{
		FifthSeparate fsFrame=new FifthSeparate();
	}
}
class JbtOverdueManageListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		OverdueManage omFrame=new OverdueManage();
	}
}
//��Ϣ����listenerclass3��
class JbtInterestCalculateListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		InterestCalculate icFrame=new InterestCalculate();
	}
}
class JbtInterestEnterListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		InterestEnter ieFrame=new InterestEnter();
	}
}
//��Ա����listenerclass3��
class JbtStaffInfoManageListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		StaffInfoManage simFrame=new StaffInfoManage();
	}
}
class JbtPerformanceCheckListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		PerformanceCheck pcFrame=new PerformanceCheck();
	}
}
//ϵͳ����listenerclass3��
class JbtAdministratorManageListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		AdministratorManage amFrame=new AdministratorManage();
	}
}
class JbtDataManageListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		DataManage dmFrame=new DataManage();
	}
}
class JbtArgumentManageListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		ArgumentManage argumentmFrame=new ArgumentManage();
	}
}
//��ѯͳ��listenerclass3��
class JbtQueryListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		QueryCount qFrame=new QueryCount();
	}
}
/*
 * 
 * 
 * listenerclass4��
 * 
 * 
 */

/*public void actionPerformed(ActionEvent e) {
int row = table.getSelectedRow();
System.out.println(table.getValueAt(row, 0));
System.out.println(table.getValueAt(row, 1));
}

��ȡJTable�е�һ�����ݵķ���
*/
class AddListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		CustomerInfoMaintain.getTable();//�������CustomerInfoMaintain���table
	
	}
}
class ModifyListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//�˴�����޸Ŀͻ���Ϣ����
	}
}

class CustomerAddListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		JTable t=(CustomerInfoMaintain.getTable());

		int row=(CustomerInfoMaintain.getTable()).getSelectedRow();

		Dk_khVO dk_khVO=new Dk_khVO();
		dk_khVO.setKhid(Integer.parseInt(((t).getValueAt(row,0)).toString()));
		dk_khVO.setName(((t).getValueAt(row,1)).toString());
		dk_khVO.setKhzl(((t).getValueAt(row,2)).toString());
		dk_khVO.setKhdz(((t).getValueAt(row,3)).toString());
		dk_khVO.setKhdh(((t).getValueAt(row,4)).toString());
		dk_khVO.setZjhm(((t).getValueAt(row,5)).toString());
		dk_khVO.setPost(((t).getValueAt(row,6)).toString());	
		dk_khVO.setEmail(((t).getValueAt(row,7)).toString());
		dk_khVO.setAccount(((t).getValueAt(row,8)).toString());
		dk_khVO.setDkje(((t).getValueAt(row,9)).toString());
		dk_khVO.setKhhmc(((t).getValueAt(row,10)).toString());
		dk_khVO.setJbhzh(((t).getValueAt(row,11)).toString());
		dk_khVO.setJszh(((t).getValueAt(row,12)).toString());
		dk_khVO.setXypj(Integer.parseInt(((t).getValueAt(row,13)).toString()));	
		dk_khVO.setSjdw(((t).getValueAt(row,14)).toString());
		dk_khVO.setXdyh(Integer.parseInt(((t).getValueAt(row,15)).toString()));
		Dk_khDAOImplement m=new Dk_khDAOImplement();
		m.insertDk_kh(dk_khVO);
	}
/*		customerAddInti();
	}
	void customerAddInti(){
		JFrame add=null;
		add.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		//��ӿͻ����ϱ��JLabel��JTextField
		add.add(new JLabel("�ͻ���"));
		JTextField khid=new JTextField(10);
		add.add(khid);
		add.add(new JLabel("�ͻ�����"));
		JTextField name=new JTextField(10);
		add.add(name);
		add.add(new JLabel("�ͻ�����"));
		JTextField khzl=new JTextField(10);
		add.add(khzl);
		add.add(new JLabel("�ͻ���ַ"));
		JTextField khdz=new JTextField(10);
		add.add(khdz);
		add.add(new JLabel("�ͻ��绰"));
		JTextField khdh=new JTextField(10);
		add.add(khdh);
		add.add(new JLabel("֤�����루Ψһʶ���룩"));
		JTextField zjhm=new JTextField(10);
		add.add(zjhm);
		add.add(new JLabel("�ʱ�"));
		JTextField post=new JTextField(10);
		add.add(post);
		add.add(new JLabel("���ʵ�ַ"));
		JTextField email=new JTextField(10);
		add.add(email);
		add.add(new JLabel("�ױʴ����˺�"));
		JTextField account=new JTextField(10);
		add.add(account);
		add.add(new JLabel("������"));
		JTextField dkje=new JTextField(10);
		add.add(dkje);
		add.add(new JLabel("����������"));
		JTextField khhmc=new JTextField(10);
		add.add(khhmc);
		add.add(new JLabel("�������˻�"));
		JTextField jbhzh=new JTextField(10);
		add.add(jbhzh);
		add.add(new JLabel("�����˺�"));
		JTextField jszh=new JTextField(10);
		add.add(jszh);
		add.add(new JLabel("��������"));
		JTextField xypj=new JTextField(10);
		add.add(xypj);
		add.add(new JLabel("�����Ŵ�Ա��"));
		JTextField xdyh=new JTextField(10);
		add.add(xdyh);
		//add.add JButtons
		JButton customerConfirm=new JButton("ȷ��");//����CUSTOMER��ȷ�ϼ�
		add.add(customerConfirm);
		CustomerConfirmListenerClass customerConfirmListener=new CustomerConfirmListenerClass();
		customerConfirm.addActionListener(customerConfirmListener);
    	add.addWindowListener(new WindowAdapter(){
    		public void windowDeactivated(WindowEvent e){
    			add.setVisible(false);
    	//		System.exit(0);���������ξ�ֱ����ֹ�˳����˳����档
    		}
    	});
    	
    	
    	//ͨ���ڸ�����ÿ��TextField������һ��GETTEXT���������ܻ��JTextField����ı�����

	}
	*/
}
class CustomerModifyListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//�˴�����޸Ŀͻ���Ϣ����
		JTable t=(CustomerInfoMaintain.getTable());

		int row=(CustomerInfoMaintain.getTable()).getSelectedRow();

		Dk_khVO dk_khVO=new Dk_khVO();
		dk_khVO.setKhid(Integer.parseInt(((t).getValueAt(row,0)).toString()));
		dk_khVO.setName(((t).getValueAt(row,1)).toString());
		dk_khVO.setKhzl(((t).getValueAt(row,2)).toString());
		dk_khVO.setKhdz(((t).getValueAt(row,3)).toString());
		dk_khVO.setKhdh(((t).getValueAt(row,4)).toString());
		dk_khVO.setZjhm(((t).getValueAt(row,5)).toString());
		dk_khVO.setPost(((t).getValueAt(row,6)).toString());
		dk_khVO.setEmail(((t).getValueAt(row,7)).toString());
		dk_khVO.setAccount(((t).getValueAt(row,8)).toString());
		dk_khVO.setDkje(((t).getValueAt(row,9)).toString());
		dk_khVO.setKhhmc(((t).getValueAt(row,10)).toString());
		dk_khVO.setJbhzh(((t).getValueAt(row,11)).toString());
		dk_khVO.setJszh(((t).getValueAt(row,12)).toString());
		dk_khVO.setXypj(Integer.parseInt(((t).getValueAt(row,13)).toString()));
		dk_khVO.setSjdw(((t).getValueAt(row,14)).toString());
		dk_khVO.setXdyh(Integer.parseInt(((t).getValueAt(row,15)).toString()));
		Dk_khDAOImplement m=new Dk_khDAOImplement();
		m.updateDk_kh(dk_khVO);
	}
}
class CustomerDeleteListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		JTable t=(CustomerInfoMaintain.getTable());
		int row=(CustomerInfoMaintain.getTable()).getSelectedRow();
		Dk_khVO dk_khVO=new Dk_khVO();
		dk_khVO.setKhid(Integer.parseInt(((t).getValueAt(row,0)).toString()));
		Dk_khDAOImplement m=new Dk_khDAOImplement();
		m.deleteDk_kh(dk_khVO);
	}
}

class LendManageAddListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//Stringת��ΪDate
		//java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		JTable t=LendManage.getTable();
		int row=t.getSelectedRow();
		Dk_sqVO dk_sqVO=new Dk_sqVO();
		dk_sqVO.setDk_sqh(Integer.parseInt(t.getValueAt(row, 1).toString()));
		dk_sqVO.setDkkhid(Integer.parseInt(t.getValueAt(row, 2).toString()));
		dk_sqVO.setDkzl(t.getValueAt(row, 3).toString());
		dk_sqVO.setDkxz(t.getValueAt(row, 4).toString());
		dk_sqVO.setDkyt(t.getValueAt(row, 5).toString());
		dk_sqVO.setDkfw(t.getValueAt(row, 6).toString());
		dk_sqVO.setDkdyp(t.getValueAt(row,7).toString());
		dk_sqVO.setDypje(Float.parseFloat(t.getValueAt(row, 8).toString()));
		dk_sqVO.setDbrid(Integer.parseInt(t.getValueAt(row, 9).toString()));
		dk_sqVO.setDkje((Float.parseFloat(t.getValueAt(row, 10).toString())));
		dk_sqVO.setZcglid(Integer.parseInt(t.getValueAt(row, 11).toString()));
		dk_sqVO.setSqrq(t.getValueAt(row, 12).toString());
		dk_sqVO.setSprq(t.getValueAt(row, 13).toString());
		dk_sqVO.setFdbz(Integer.parseInt(t.getValueAt(row, 14).toString()));
		dk_sqVO.setSprid(Integer.parseInt(t.getValueAt(row, 15).toString()));
		dk_sqVO.setDkzh(t.getValueAt(row, 16).toString());
		dk_sqVO.setDkhth(t.getValueAt(row, 17).toString());
		dk_sqVO.setDkhtje(Float.parseFloat(t.getValueAt(row, 18).toString()));
		dk_sqVO.setDkhtll(Float.parseFloat(t.getValueAt(row, 19).toString()));
		dk_sqVO.setHkfs(t.getValueAt(row, 20).toString());
		dk_sqVO.setMqhkje(Float.parseFloat(t.getValueAt(row, 21).toString()));
		dk_sqVO.setDcxdyid(Integer.parseInt(t.getValueAt(row, 22).toString()));
		Dk_sqDAOImplement m=new Dk_sqDAOImplement();
		m.insertDk_sq(dk_sqVO);
	}
}
class LendManageModifyListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//Stringת��ΪDate
		//java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		JTable t=LendManage.getTable();
		int row=t.getSelectedRow();
		Dk_sqVO dk_sqVO=new Dk_sqVO();
		dk_sqVO.setDk_sqh(Integer.parseInt(t.getValueAt(row, 1).toString()));
		dk_sqVO.setDkkhid(Integer.parseInt(t.getValueAt(row, 2).toString()));
		dk_sqVO.setDkzl(t.getValueAt(row, 3).toString());
		dk_sqVO.setDkxz(t.getValueAt(row, 4).toString());
		dk_sqVO.setDkyt(t.getValueAt(row, 5).toString());
		dk_sqVO.setDkfw(t.getValueAt(row, 6).toString());
		dk_sqVO.setDkdyp(t.getValueAt(row,7).toString());
		dk_sqVO.setDypje(Float.parseFloat(t.getValueAt(row, 8).toString()));
		dk_sqVO.setDbrid(Integer.parseInt(t.getValueAt(row, 9).toString()));
		dk_sqVO.setDkje((Float.parseFloat(t.getValueAt(row, 10).toString())));
		dk_sqVO.setZcglid(Integer.parseInt(t.getValueAt(row, 11).toString()));
		dk_sqVO.setSqrq(t.getValueAt(row, 12).toString());
		dk_sqVO.setSprq(t.getValueAt(row, 13).toString());
		dk_sqVO.setFdbz(Integer.parseInt(t.getValueAt(row, 14).toString()));
		dk_sqVO.setSprid(Integer.parseInt(t.getValueAt(row, 15).toString()));
		dk_sqVO.setDkzh(t.getValueAt(row, 16).toString());
		dk_sqVO.setDkhth(t.getValueAt(row, 17).toString());
		dk_sqVO.setDkhtje(Float.parseFloat(t.getValueAt(row, 18).toString()));
		dk_sqVO.setDkhtll(Float.parseFloat(t.getValueAt(row, 19).toString()));
		dk_sqVO.setHkfs(t.getValueAt(row, 20).toString());
		dk_sqVO.setMqhkje(Float.parseFloat(t.getValueAt(row, 21).toString()));
		dk_sqVO.setDcxdyid(Integer.parseInt(t.getValueAt(row, 22).toString()));
		Dk_sqDAOImplement m=new Dk_sqDAOImplement();
		m.updateDk_sq(dk_sqVO);
}
}
class LendManageDeleteListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//Stringת��ΪDate
		//java.text.SimpleDateFormat formatter=new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		JTable t=LendManage.getTable();
		int row=t.getSelectedRow();
		Dk_sqVO dk_sqVO=new Dk_sqVO();
		dk_sqVO.setDk_sqh(Integer.parseInt(t.getValueAt(row, 1).toString()));
		dk_sqVO.setDkkhid(Integer.parseInt(t.getValueAt(row, 2).toString()));
		dk_sqVO.setDkzl(t.getValueAt(row, 3).toString());
		dk_sqVO.setDkxz(t.getValueAt(row, 4).toString());
		dk_sqVO.setDkyt(t.getValueAt(row, 5).toString());
		dk_sqVO.setDkfw(t.getValueAt(row, 6).toString());
		dk_sqVO.setDkdyp(t.getValueAt(row,7).toString());
		dk_sqVO.setDypje(Float.parseFloat(t.getValueAt(row, 8).toString()));
		dk_sqVO.setDbrid(Integer.parseInt(t.getValueAt(row, 9).toString()));
		dk_sqVO.setDkje((Float.parseFloat(t.getValueAt(row, 10).toString())));
		dk_sqVO.setZcglid(Integer.parseInt(t.getValueAt(row, 11).toString()));
		dk_sqVO.setSqrq(t.getValueAt(row, 12).toString());
		dk_sqVO.setSprq(t.getValueAt(row, 13).toString());
		dk_sqVO.setFdbz(Integer.parseInt(t.getValueAt(row, 14).toString()));
		dk_sqVO.setSprid(Integer.parseInt(t.getValueAt(row, 15).toString()));
		dk_sqVO.setDkzh(t.getValueAt(row, 16).toString());
		dk_sqVO.setDkhth(t.getValueAt(row, 17).toString());
		dk_sqVO.setDkhtje(Float.parseFloat(t.getValueAt(row, 18).toString()));
		dk_sqVO.setDkhtll(Float.parseFloat(t.getValueAt(row, 19).toString()));
		dk_sqVO.setHkfs(t.getValueAt(row, 20).toString());
		dk_sqVO.setMqhkje(Float.parseFloat(t.getValueAt(row, 21).toString()));
		dk_sqVO.setDcxdyid(Integer.parseInt(t.getValueAt(row, 22).toString()));
		Dk_sqDAOImplement m=new Dk_sqDAOImplement();
		m.deleteDk_sq(dk_sqVO);
	}
}
//��Ϣ����
class InterestCalculateAddListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		JTable t=InterestCalculate.getTable();
		int row=t.getSelectedRow();
		T_dklxVO t_dklxVO=new T_dklxVO();
		t_dklxVO.setLx_id(Integer.parseInt(t.getValueAt(row, 1).toString()));
		t_dklxVO.setFlx_id(Integer.parseInt(t.getValueAt(row, 2).toString()));
		t_dklxVO.setLxbz(t.getValueAt(row, 3).toString());
		t_dklxVO.setDk_zh(t.getValueAt(row, 4).toString());
		t_dklxVO.setDk_ye(Float.parseFloat(t.getValueAt(row, 5).toString()));
		t_dklxVO.setFxzhrq(t.getValueAt(row, 6).toString());
		t_dklxVO.setFxksrq(t.getValueAt(row,7).toString());
		t_dklxVO.setLxdqrq(t.getValueAt(row, 8).toString());
		t_dklxVO.setLxjxrq(t.getValueAt(row, 9).toString());
		t_dklxVO.setLxclrq(t.getValueAt(row, 10).toString());
		t_dklxVO.setLl(Integer.parseInt(t.getValueAt(row, 11).toString()));
		t_dklxVO.setLxe(Float.parseFloat(t.getValueAt(row, 12).toString()));
		t_dklxVO.setLxclbz(t.getValueAt(row, 13).toString());
		
		T_dklxDAOImplement m=new T_dklxDAOImplement();
		m.insertT_dklx(t_dklxVO);
	}
}
class InterestCalculateModifyListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		JTable t=InterestCalculate.getTable();
		int row=t.getSelectedRow();
		T_dklxVO t_dklxVO=new T_dklxVO();
		t_dklxVO.setLx_id(Integer.parseInt(t.getValueAt(row, 1).toString()));
		t_dklxVO.setFlx_id(Integer.parseInt(t.getValueAt(row, 2).toString()));
		t_dklxVO.setLxbz(t.getValueAt(row, 3).toString());
		t_dklxVO.setDk_zh(t.getValueAt(row, 4).toString());
		t_dklxVO.setDk_ye(Float.parseFloat(t.getValueAt(row, 5).toString()));
		t_dklxVO.setFxzhrq(t.getValueAt(row, 6).toString());
		t_dklxVO.setFxksrq(t.getValueAt(row,7).toString());
		t_dklxVO.setLxdqrq(t.getValueAt(row, 8).toString());
		t_dklxVO.setLxjxrq(t.getValueAt(row, 9).toString());
		t_dklxVO.setLxclrq(t.getValueAt(row, 10).toString());
		t_dklxVO.setLl(Integer.parseInt(t.getValueAt(row, 11).toString()));
		t_dklxVO.setLxe(Float.parseFloat(t.getValueAt(row, 12).toString()));
		t_dklxVO.setLxclbz(t.getValueAt(row, 13).toString());
		
		T_dklxDAOImplement m=new T_dklxDAOImplement();
		m.updateT_dklx(t_dklxVO);
	}
}
class InterestCalculateDeleteListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		JTable t=InterestCalculate.getTable();
		int row=t.getSelectedRow();
		T_dklxVO t_dklxVO=new T_dklxVO();
		t_dklxVO.setLx_id(Integer.parseInt(t.getValueAt(row, 1).toString()));
		t_dklxVO.setFlx_id(Integer.parseInt(t.getValueAt(row, 2).toString()));
		t_dklxVO.setLxbz(t.getValueAt(row, 3).toString());
		t_dklxVO.setDk_zh(t.getValueAt(row, 4).toString());
		t_dklxVO.setDk_ye(Float.parseFloat(t.getValueAt(row, 5).toString()));
		t_dklxVO.setFxzhrq(t.getValueAt(row, 6).toString());
		t_dklxVO.setFxksrq(t.getValueAt(row,7).toString());
		t_dklxVO.setLxdqrq(t.getValueAt(row, 8).toString());
		t_dklxVO.setLxjxrq(t.getValueAt(row, 9).toString());
		t_dklxVO.setLxclrq(t.getValueAt(row, 10).toString());
		t_dklxVO.setLl(Integer.parseInt(t.getValueAt(row, 11).toString()));
		t_dklxVO.setLxe(Float.parseFloat(t.getValueAt(row, 12).toString()));
		t_dklxVO.setLxclbz(t.getValueAt(row, 13).toString());
		
		T_dklxDAOImplement m=new T_dklxDAOImplement();
		m.deleteT_dklx(t_dklxVO);
	}
}
class FifthSeparateAddListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
	JTable t=InterestCalculate.getTable();
	int row=t.getSelectedRow();
	T_dkfhVO t_dkfhVO=new T_dkfhVO();
	t_dkfhVO.setDkbh(t.getValueAt(row, 1).toString());
	t_dkfhVO.setKhid(Integer.parseInt(t.getValueAt(row, 2).toString()));
	t_dkfhVO.setDksqid(Integer.parseInt(t.getValueAt(row, 3).toString()));
	t_dkfhVO.setKmh(t.getValueAt(row, 4).toString());
	t_dkfhVO.setSybz(t.getValueAt(row, 5).toString());
	t_dkfhVO.setDkbz(t.getValueAt(row, 6).toString());
	t_dkfhVO.setDkksrq(t.getValueAt(row,7).toString());
	t_dkfhVO.setKddqrq(t.getValueAt(row, 8).toString());
	t_dkfhVO.setDkzqrq(t.getValueAt(row, 9).toString());
	t_dkfhVO.setZhhkrq(t.getValueAt(row, 10).toString());
	t_dkfhVO.setZhjxrq(t.getValueAt(row, 11).toString());
	t_dkfhVO.setYe(Float.parseFloat(t.getValueAt(row, 12).toString()));
	t_dkfhVO.setSjll(Float.parseFloat(t.getValueAt(row, 13).toString()));
	t_dkfhVO.setZqll(Integer.parseInt(t.getValueAt(row, 14).toString()));
	t_dkfhVO.setYqll(Float.parseFloat(t.getValueAt(row, 15).toString()));
	t_dkfhVO.setFqll(Float.parseFloat(t.getValueAt(row, 16).toString()));
	
	T_dkfhDAOImplement m=new T_dkfhDAOImplement();
	m.insertT_dkfh(t_dkfhVO);
	}
}
class FifthSeparateModifyListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
	JTable t=InterestCalculate.getTable();
	int row=t.getSelectedRow();
	T_dkfhVO t_dkfhVO=new T_dkfhVO();
	t_dkfhVO.setDkbh(t.getValueAt(row, 1).toString());
	t_dkfhVO.setKhid(Integer.parseInt(t.getValueAt(row, 2).toString()));
	t_dkfhVO.setDksqid(Integer.parseInt(t.getValueAt(row, 3).toString()));
	t_dkfhVO.setKmh(t.getValueAt(row, 4).toString());
	t_dkfhVO.setSybz(t.getValueAt(row, 5).toString());
	t_dkfhVO.setDkbz(t.getValueAt(row, 6).toString());
	t_dkfhVO.setDkksrq(t.getValueAt(row,7).toString());
	t_dkfhVO.setKddqrq(t.getValueAt(row, 8).toString());
	t_dkfhVO.setDkzqrq(t.getValueAt(row, 9).toString());
	t_dkfhVO.setZhhkrq(t.getValueAt(row, 10).toString());
	t_dkfhVO.setZhjxrq(t.getValueAt(row, 11).toString());
	t_dkfhVO.setYe(Float.parseFloat(t.getValueAt(row, 12).toString()));
	t_dkfhVO.setSjll(Float.parseFloat(t.getValueAt(row, 13).toString()));
	t_dkfhVO.setZqll(Integer.parseInt(t.getValueAt(row, 14).toString()));
	t_dkfhVO.setYqll(Float.parseFloat(t.getValueAt(row, 15).toString()));
	t_dkfhVO.setFqll(Float.parseFloat(t.getValueAt(row, 16).toString()));
	
	T_dkfhDAOImplement m=new T_dkfhDAOImplement();
	m.updateT_dkfh(t_dkfhVO);
	}
}
class FifthSeparateDeleteListenerClass  implements ActionListener{
	public void actionPerformed(ActionEvent e){
	JTable t=InterestCalculate.getTable();
	int row=t.getSelectedRow();
	T_dkfhVO t_dkfhVO=new T_dkfhVO();
	t_dkfhVO.setDkbh(t.getValueAt(row, 1).toString());
	t_dkfhVO.setKhid(Integer.parseInt(t.getValueAt(row, 2).toString()));
	t_dkfhVO.setDksqid(Integer.parseInt(t.getValueAt(row, 3).toString()));
	t_dkfhVO.setKmh(t.getValueAt(row, 4).toString());
	t_dkfhVO.setSybz(t.getValueAt(row, 5).toString());
	t_dkfhVO.setDkbz(t.getValueAt(row, 6).toString());
	t_dkfhVO.setDkksrq(t.getValueAt(row,7).toString());
	t_dkfhVO.setKddqrq(t.getValueAt(row, 8).toString());
	t_dkfhVO.setDkzqrq(t.getValueAt(row, 9).toString());
	t_dkfhVO.setZhhkrq(t.getValueAt(row, 10).toString());
	t_dkfhVO.setZhjxrq(t.getValueAt(row, 11).toString());
	t_dkfhVO.setYe(Float.parseFloat(t.getValueAt(row, 12).toString()));
	t_dkfhVO.setSjll(Float.parseFloat(t.getValueAt(row, 13).toString()));
	t_dkfhVO.setZqll(Integer.parseInt(t.getValueAt(row, 14).toString()));
	t_dkfhVO.setYqll(Float.parseFloat(t.getValueAt(row, 15).toString()));
	t_dkfhVO.setFqll(Float.parseFloat(t.getValueAt(row, 16).toString()));
	
	T_dkfhDAOImplement m=new T_dkfhDAOImplement();
	m.deleteT_dkfh(t_dkfhVO);
	}
}
/*
 * 
 * 
 * ListenerClass 5������������������봰ȷ�ϼ��ļ������¼�
 * 
 */
class CustomerConfirmListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){

	}
}




/*
//��widow�����������ڲ�ʵ�־Ϳ����ˣ��ô����ֻ��Ϊ����Ϥwindow������
class FrameWindowListener  extends JFrame implements WindowListener {
	public void windowClosing(WindowEvent e){
		setVisible(false);
		System.exit(0);		
		//��ʱ��֪������,������System��һ��Java�࣬����exit(0)������ֹ�����Ҳ�����˳����Java��������������ǲ��������̽����ķ���ֵ��
	}
	public void  windowDeactivated(WindowEvent e){
		setVisible(false);
	}
	public void  windowActivated(WindowEvent e){
		setVisible(true);
	}
	public void windowDeiconified(WindowEvent e){
		setVisible(true);
	}
	public void windowIconified(WindowEvent e){
		setVisible(false);
	}
	public void windowOpened(WindowEvent e){
		setVisible(true);
	}
	public void windowClosed(WindowEvent e){
		setVisible(false);
	}
}
*/
