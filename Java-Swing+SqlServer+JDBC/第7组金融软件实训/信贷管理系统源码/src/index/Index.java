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
		setTitle("登录窗");
		setSize(400,300);//Set functionSelectFrame size
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//注册窗口监听器，令该frame监听到窗口开关事件就关闭，从而保持始终只有一个窗口
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
			}
		});
	}
		public static void main(String[]args){
			Index index=new Index();
			/*
			Index loFrame=new Index();
			//即log on frame，以后的界面frame命名类推
		loFrame.setTitle("functionSelectFrame");
		loFrame.setSize(400,300);//Set functionSelectFrame size
		loFrame.setLocationRelativeTo(null);
		loFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loFrame.setVisible(true);
		*/
	}
		//用于返回JTextField以便获取JTextField中的内容
	public static JTextField getJTextField(JTextField jtf){
		return jtf;
	}
}


class FunctionSelectFrame extends JFrame{
	 FunctionSelectFrame(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		//create log on button and create JTextfield and so on
		JButton jbtCustomerManage=new JButton("客户管理");
		JButton jbtServiceManage=new JButton("业务管理");
		JButton jbtInterestManage=new JButton("利息管理");
		JButton jbtStaffManage=new JButton("人员管理");
		JButton jbtSystemManage=new JButton("系统管理");
		JButton jbtQueryCount=new JButton("查询统计");
		//加上回退键
		JButton jbtLogOut=new JButton("注销");
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
		setTitle("功能选择窗");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
			}
		});
		/*
		//add buttons into the frame
		add(new JButton("客户管理"));
		add(new JButton("业务管理"));
		add(new JButton("利息管理"));
		add(new JButton("人员管理"));
		add(new JButton("系统管理"));
		add(new JButton("查询统计"));
		*/
	}
}
/*
 * 
 * 
 *添加返回按钮
 * 			JButton jbtReturn=new JButton("返回");
 * 			add(jbtReturn);
 * 			JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
			jbtReturn.addActionListener(jbtReturnListener);
 * 
 */
class CustomerManage extends JFrame{
		public CustomerManage(){
			setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
			JButton jbtCustomerInfoMaintain=new JButton("客户信息维护");
			JButton jbtCustomerCreditEvaluate=new JButton("客户信用评估");
			JButton jbtReturn=new JButton("返回");
			
			add(jbtCustomerInfoMaintain);
			add(jbtCustomerCreditEvaluate);
			add(jbtReturn);
			
			JbtCustomerInfoMaintainListenerClass jbtCustomerInfoMaintainListener=new JbtCustomerInfoMaintainListenerClass();
			jbtCustomerInfoMaintain.addActionListener(jbtCustomerInfoMaintainListener);
			JbtCustomerCreditEvaluateListenerClass jbtCustomerCreditEvaluateListener=new JbtCustomerCreditEvaluateListenerClass();
			jbtCustomerCreditEvaluate.addActionListener(jbtCustomerCreditEvaluateListener);
			JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
			jbtReturn.addActionListener(jbtReturnListener);
			
			setTitle("客户管理窗");
			setSize(400,300);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			addWindowListener(new WindowAdapter(){
				public void windowDeactivated(WindowEvent e){
					setVisible(false);
			//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
				}
			});
			//add buttons into the frame
			/*
			add(new JButton("客户信息维护"));
			add(new JButton("客户信用评估"));
			*/
		}
}

class ServiceManage extends JFrame{
	public ServiceManage(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		JButton jbtLendManage=new JButton("放贷管理");
		JButton jbtFifthSeparate=new JButton("五级清分");
		JButton jbtOverdueManage=new JButton("逾期管理");
		JButton jbtReturn=new JButton("返回");
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
		
		setTitle("业务管理窗");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
			}
		});
		/*
		//add buttons into the frame
		add(new JButton("放贷管理"));
		add(new JButton("五级清分"));
		add(new JButton("逾期管理"));
		*/
	}
}

class InterestManage extends JFrame{
	public InterestManage(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		JButton jbtInterestCalculate=new JButton("利息计算");
		JButton jbtInterestEnter=new JButton("利息入账");
		JButton jbtReturn=new JButton("返回");
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
		
		setTitle("利息管理窗");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
			}
		});
	}
}

class StaffManage extends JFrame{
	public StaffManage(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		JButton jbtStaffInfoManage=new JButton("人员信息管理");
		JButton jbtPerformanceCheck=new JButton("人员绩效考核");
		JButton jbtReturn=new JButton("返回");
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
		
		setTitle("人员管理窗");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
			}
		});
		
		/*
		//add buttons into the frame
		add(new JButton("人员信息管理"));
		add(new JButton("人员绩效考核"));
		*/
	}
}

class SystemManage extends JFrame{
	public SystemManage(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		JButton jbtAdministratorManage=new JButton("管理员管理");
		JButton jbtDataManage=new JButton("数据管理");
		JButton jbtArgumentManage=new JButton("参数管理");
		JButton jbtReturn=new JButton("返回");
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
		
		setTitle("系统管理窗");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
			}
		});	
		
		/*
		//add buttons into the frame
		add(new JButton("管理员管理"));
		add(new JButton("数据管理"));
		add(new JButton("参数管理"));
		*/
	}
}
class QueryCount extends JFrame{
	public QueryCount(){
		setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		JButton jbtQuery=new JButton("查询");
		JButton jbtReturn=new JButton("返回");
		add(jbtQuery);
		add(jbtReturn);
		
		JbtQueryListenerClass jbtQueryListener=new JbtQueryListenerClass();
		jbtQuery.addActionListener(jbtQueryListener);
		
		JbtReturnListenerClass jbtReturnListener=new JbtReturnListenerClass();
		jbtReturn.addActionListener(jbtReturnListener);
		
		setTitle("查询窗");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowDeactivated(WindowEvent e){
				setVisible(false);
		//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
			}
		});	
		
		/*
		//add buttons into the frame
		add(new JButton("查询"));
		*/
	}
}


//三级JFrame类
//客户管理JFrame2级

		/*
	setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
	//添加客户资料表的JLabel和JTextField
	add(new JLabel("客户号"));
	JTextField khid=new JTextField(10);
	add(khid);
	add(new JLabel("客户名称"));
	JTextField name=new JTextField(10);
	add(name);
	add(new JLabel("客户种类"));
	JTextField khzl=new JTextField(10);
	add(khzl);
	add(new JLabel("客户地址"));
	JTextField khdz=new JTextField(10);
	add(khdz);
	add(new JLabel("客户电话"));
	JTextField khdh=new JTextField(10);
	add(khdh);
	add(new JLabel("证件号码（唯一识别码）"));
	JTextField zjhm=new JTextField(10);
	add(zjhm);
	add(new JLabel("邮编"));
	JTextField post=new JTextField(10);
	add(post);
	add(new JLabel("电邮地址"));
	JTextField email=new JTextField(10);
	add(email);
	add(new JLabel("首笔贷款账号"));
	JTextField account=new JTextField(10);
	add(account);
	add(new JLabel("贷款金额"));
	JTextField dkje=new JTextField(10);
	add(dkje);
	add(new JLabel("开户行名称"));
	JTextField khhmc=new JTextField(10);
	add(khhmc);
	add(new JLabel("基本户账户"));
	JTextField jbhzh=new JTextField(10);
	add(jbhzh);
	add(new JLabel("结算账号"));
	JTextField jszh=new JTextField(10);
	add(jszh);
	add(new JLabel("信用评级"));
	JTextField xypj=new JTextField(10);
	add(xypj);
	add(new JLabel("归属信贷员号"));
	JTextField xdyh=new JTextField(10);
	add(xdyh);
	//add JButtons
	JButton add=new JButton("新增");
	JButton modify=new JButton("修改");
	JButton jbtReturn=new JButton("返回");
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
     * 初始化窗体组件 
     */  
    private void intiComponent()  
    {  setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
        /* 
         * 设置JTable的列名 
         */  
        String[] columnNames =  
        { "客户号", "客户名称", "客户种类", "客户地址", "客户电话" ,
        		"证件号码","邮编","电邮地址","首笔贷款账号","贷款金额",
        		"开户行名称","基本户账户","结算帐号","信用评级","上级单位","归属信贷员号"};  
  
        /* 
         * 初始化JTable里面各项的值，设置两个一模一样的实体"赵匡义"学生。 
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
                    obj[i][j] = "张三";  
                    break;  
                case 2:  
                    obj[i][j] = "2个人";  
                    break;  
                case 3:  
                    obj[i][j] = "华南理工大学";  
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
                	obj[i][j]="银行";
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
                	obj[i][j]="上级单位1";
                	break;
                case 15:
            	obj[i][j]="0001";
            	break;
                }  
            }  
        }  
          
          
        /* 
         * JTable的其中一种构造方法 
         */  
        table = new JTable(obj, columnNames);  
        /* 
         * 设置JTable的列默认的宽度和高度 
         */  
        //自己加的，将表插入到JFrame中
        add(table); 
        setSize(200,400);
        /* 
         * 设置JTable自动调整列表的状态，此处设置为关闭 
         */  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
          
        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
        JScrollPane scroll = new JScrollPane(table);  
        scroll.setSize(200,100); 
          
      //add JButtons
    	JButton add=new JButton("新增");
    	JButton modify=new JButton("修改");
    	JButton delete=new JButton("删除");
    	JButton jbtReturn=new JButton("返回");
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
    	//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
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
//业务管理JFrame3级
class LendManage extends JFrame{
	public static JTable table;
	public LendManage(){
	 intiComponent();
	}
	public void intiComponent(){
		setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
        /* 
         * 设置JTable的列名 
         */  
        String[] columnNames =  
        { "贷款申请号", "客户号", "贷款种类", "贷款性质", "贷款用途" ,
        		"贷款范围","贷款抵押品","抵押品金额","担保人客户号","贷款金额",
        		"资产管理号","申请日期","审批日期","放贷标志","审批人标号","贷款账户","贷款合同号","贷款合同金额","贷款合同利率","还款方式","每期还款金额","调查信贷员"};
        
        Object[][] obj=new Object[2][22];
       
        table = new JTable(obj, columnNames);  
        add(table); 
        setSize(200,400);
        /* 
         * 设置JTable自动调整列表的状态，此处设置为关闭 
         */  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
          
        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
        JScrollPane scroll = new JScrollPane(table);  
        scroll.setSize(200,100); 
        add(scroll);

	//add JButtons
	JButton add=new JButton("新增");
	JButton modify=new JButton("修改");
	JButton delete=new JButton("删除");
	JButton jbtReturn=new JButton("返回");
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
	
	setTitle("放贷管理窗");
	setSize(800,1500);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
	addWindowListener(new WindowAdapter(){
		public void windowDeactivated(WindowEvent e){
			setVisible(false);
	//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
		}
	});
	
	}
	public static JTable getTable(){
		return table;
	}
}
class FifthSeparate extends JFrame{
	//此处添加信息分类功能
	//放贷管理
	public static JTable table;
	public FifthSeparate(){
	 intiComponent();
	}
	public void intiComponent(){
		setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
        /* 
         * 设置JTable的列名 
         */  
        String[] columnNames =  
        { "贷款编号", "客户号", "贷款申请号", "科目号", "贷款使用标志" ,
        "贷款标志","贷款五级分类","贷款归属部门","贷款开始日期","贷款到期日期",
        "贷款展期日期","贷款还款日期","最后计息日期","贷款余额","实际利率","展期利率","预期利率","罚期利率"};
        
        Object[][] obj=new Object[2][18];
       
        table = new JTable(obj, columnNames);  
        add(table); 
        setSize(200,400);
        /* 
         * 设置JTable自动调整列表的状态，此处设置为关闭 
         */  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
          
        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
        JScrollPane scroll = new JScrollPane(table);  
        scroll.setSize(200,100); 
        add(scroll);

	//add JButtons
	JButton add=new JButton("新增");
	JButton modify=new JButton("修改");
	JButton delete=new JButton("删除");
	JButton jbtReturn=new JButton("返回");
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
	
	setTitle("五级清分(贷款分户表)");
	setSize(800,1500);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
	addWindowListener(new WindowAdapter(){
		public void windowDeactivated(WindowEvent e){
			setVisible(false);
	//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
		}
	});
	
	}
	public static JTable getTable(){
		return table;
	}
	
}
class OverdueManage extends JFrame{
	
}
//利息管理JFrame3级
class InterestCalculate extends JFrame{
	public static JTable table;
	public InterestCalculate(){
	 intiComponent();
	}
	public void intiComponent(){
		setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
        /* 
         * 设置JTable的列名 
         */  
        String[] columnNames =  
        { "利息编号", "父利息编号", "利息标志", "贷款账号", "贷款余额" ,
        		"复息最后日期","利息开始日期","利息到期日期","利息计算日期","利息处理日期",
        		"利率","利息额","利息处理标志"};
        
        Object[][] obj=new Object[2][13];
       
        table = new JTable(obj, columnNames);  
        add(table); 
        setSize(200,400);
        /* 
         * 设置JTable自动调整列表的状态，此处设置为关闭 
         */  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
          
        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
        JScrollPane scroll = new JScrollPane(table);  
        scroll.setSize(200,100); 
        add(scroll);

	//add JButtons
	JButton add=new JButton("新增");
	JButton modify=new JButton("修改");
	JButton delete=new JButton("删除");
	JButton jbtReturn=new JButton("返回");
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
	
	setTitle("利息管理窗");
	setSize(800,1500);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
	addWindowListener(new WindowAdapter(){
		public void windowDeactivated(WindowEvent e){
			setVisible(false);
	//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
		}
	});
	
	}
	public static JTable getTable(){
		return table;
	}
}
class InterestEnter extends JFrame{
	
}
//人员管理JFrame3级
class StaffInfoManage extends JFrame{ //JAVA不能多继承
  	    public StaffInfoManage()  
	    {  
	        intiComponent();  
	    }  
	  
	    /** 
	     * 初始化窗体组件 
	     */  
	    private void intiComponent()  
	    {  setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
	        /* 
	         * 设置JTable的列名 
	         */  
	        String[] columnNames =  
	        { "人员代号", "姓名", "性别", "家庭地址", "身份证号" ,"手机号","系统角色"};  
	  
	        /* 
	         * 初始化JTable里面各项的值，设置两个一模一样的实体"赵匡义"学生。 
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
	                    obj[i][j] = "张三";  
	                    break;  
	                case 2:  
	                    obj[i][j] = "男";  
	                    break;  
	                case 3:  
	                    obj[i][j] = "华南理工大学";  
	                    break;  
	                case 4:  
	                    obj[i][j] = "440222199101111217";  
	                    break;  
	                case 5:  
	                    obj[i][j] = "13025364591";  
	                    break;  
	                case 6:
	                	obj[i][j]="管理员";
	                	break;
	                }  
	            }  
	        }  
	          
	          
	        /* 
	         * JTable的其中一种构造方法 
	         */  
	        JTable table = new JTable(obj, columnNames);  
	        /* 
	         * 设置JTable的列默认的宽度和高度 
	         */  
	        //自己加的，将表插入到JFrame中
	        add(table); 
	        setSize(1000,1000);
	        /* 
	         * 设置JTable自动调整列表的状态，此处设置为关闭 
	         */  
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);  
	          
	        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
	        JScrollPane scroll = new JScrollPane(table);  
	        scroll.setSize(1500,1500);  
	          
	      //add JButtons
	    	JButton add=new JButton("新增");
	    	JButton modify=new JButton("修改");
	    	JButton jbtReturn=new JButton("返回");
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
	    	//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
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
//系统管理JFrame3级
class AdministratorManage extends JFrame{
	
}
class DataManage extends JFrame{
	
} 
class ArgumentManage extends JFrame{
	
}
//查询管理JFrame3级
//无，查询管理只有2级




/*
 * 
 * 
 * 
 * XListenerClass
 * 
 * 
 * 
 */
//XListenerClass 1级
class LogOnListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e)                           
	{//验证满不满足用户条件
		if(Integer.parseInt(((Index.getJTextField(Index.jtfUserName)).getText()).toString())==2014
				&&Integer.parseInt(((Index.getJTextField(Index.jtfPassword)).getText()).toString())==0000){
			FunctionSelectFrame fsfFrame =new FunctionSelectFrame();
		}
		else{
			try{
			JFrame f=new JFrame();
			JLabel l=new JLabel("账号密码错误！");
			f.add(l);
			f.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
			f.setSize(400, 150);
			f.setTitle("账号密码错误！");
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
//XListenerClass 2级
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
//XListenerClass 3级
//

//客户管理listenerclass3级
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
//业务管理listenerclass33级
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
//利息管理listenerclass3级
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
//人员管理listenerclass3级
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
//系统管理listenerclass3级
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
//查询统计listenerclass3级
class JbtQueryListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		QueryCount qFrame=new QueryCount();
	}
}
/*
 * 
 * 
 * listenerclass4级
 * 
 * 
 */

/*public void actionPerformed(ActionEvent e) {
int row = table.getSelectedRow();
System.out.println(table.getValueAt(row, 0));
System.out.println(table.getValueAt(row, 1));
}

获取JTable中的一行数据的方法
*/
class AddListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		CustomerInfoMaintain.getTable();//这个就是CustomerInfoMaintain里的table
	
	}
}
class ModifyListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//此处添加修改客户信息操作
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
		//添加客户资料表的JLabel和JTextField
		add.add(new JLabel("客户号"));
		JTextField khid=new JTextField(10);
		add.add(khid);
		add.add(new JLabel("客户名称"));
		JTextField name=new JTextField(10);
		add.add(name);
		add.add(new JLabel("客户种类"));
		JTextField khzl=new JTextField(10);
		add.add(khzl);
		add.add(new JLabel("客户地址"));
		JTextField khdz=new JTextField(10);
		add.add(khdz);
		add.add(new JLabel("客户电话"));
		JTextField khdh=new JTextField(10);
		add.add(khdh);
		add.add(new JLabel("证件号码（唯一识别码）"));
		JTextField zjhm=new JTextField(10);
		add.add(zjhm);
		add.add(new JLabel("邮编"));
		JTextField post=new JTextField(10);
		add.add(post);
		add.add(new JLabel("电邮地址"));
		JTextField email=new JTextField(10);
		add.add(email);
		add.add(new JLabel("首笔贷款账号"));
		JTextField account=new JTextField(10);
		add.add(account);
		add.add(new JLabel("贷款金额"));
		JTextField dkje=new JTextField(10);
		add.add(dkje);
		add.add(new JLabel("开户行名称"));
		JTextField khhmc=new JTextField(10);
		add.add(khhmc);
		add.add(new JLabel("基本户账户"));
		JTextField jbhzh=new JTextField(10);
		add.add(jbhzh);
		add.add(new JLabel("结算账号"));
		JTextField jszh=new JTextField(10);
		add.add(jszh);
		add.add(new JLabel("信用评级"));
		JTextField xypj=new JTextField(10);
		add.add(xypj);
		add.add(new JLabel("归属信贷员号"));
		JTextField xdyh=new JTextField(10);
		add.add(xdyh);
		//add.add JButtons
		JButton customerConfirm=new JButton("确认");//单是CUSTOMER的确认键
		add.add(customerConfirm);
		CustomerConfirmListenerClass customerConfirmListener=new CustomerConfirmListenerClass();
		customerConfirm.addActionListener(customerConfirmListener);
    	add.addWindowListener(new WindowAdapter(){
    		public void windowDeactivated(WindowEvent e){
    			add.setVisible(false);
    	//		System.exit(0);如果加上这段就直接终止了程序，退出界面。
    		}
    	});
    	
    	
    	//通过在该类中每个TextField都设置一个GETTEXT方法，就能获得JTextField里的文本内容

	}
	*/
}
class CustomerModifyListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//此处添加修改客户信息操作
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
		//String转化为Date
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
		//String转化为Date
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
		//String转化为Date
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
//利息处理
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
 * ListenerClass 5级：即各表的数据输入窗确认键的监听和事件
 * 
 */
class CustomerConfirmListenerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){

	}
}




/*
//该widow监听器在类内部实现就可以了，该代码段只是为了熟悉window监听器
class FrameWindowListener  extends JFrame implements WindowListener {
	public void windowClosing(WindowEvent e){
		setVisible(false);
		System.exit(0);		
		//暂时不知道作用,查明：System是一个Java类，调用exit(0)方法终止虚拟机也就是退出你的Java程序，括号里面的是参数，进程结束的返回值。
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
