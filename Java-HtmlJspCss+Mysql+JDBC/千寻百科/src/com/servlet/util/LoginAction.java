package com.servlet.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.*;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getContextPath();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("userID");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		System.out.println("id: "+id+" password: "+password+" userType: "+userType);
		UserFactory userFactory = new UserFactory();
		User user = userFactory.getUser(userType);
//		request.getSession().setAttribute("userType", userType);
//		System.out.println("id&password: "+id+" "+password);
		OrdinaryUser ordinaryUser=null;
		Manager manager=null;
		if(user instanceof OrdinaryUser){
			ordinaryUser =(OrdinaryUser) user.login(id, password);
			if(ordinaryUser != null){
				//...
		        System.out.println(ordinaryUser+" login successfully !!!");
				//设置登录状态为1（用户登录）
				request.getSession().setAttribute("state", 1);
				//提交ordinaryUser
				request.getSession().setAttribute("user", ordinaryUser);
				//弹出登录用户主页面
		        response.sendRedirect(path + "/l_index.jsp");
				
			}
			else{
				//设置登录状态为0（未登录）
				request.getSession().setAttribute("state", 0);
				//登录失败弹框
				response.getWriter().print("<script>alert(\"账号或密码错误！\");</script>");
			}
		}
		else if(user instanceof Manager){
			manager =(Manager) user.login(id, password);
			if(manager != null){
				//...
				//设置登录状态为2（管理员登录）
				request.getSession().setAttribute("state", 2);
				//提交Manager
				request.getSession().setAttribute("manager", manager);
				//弹出管理员主页面
		        response.sendRedirect(path + "/g_index.jsp");
			}
			else{
				//设置登录状态为0（未登录）
				request.getSession().setAttribute("state", 0);
				//登录失败弹框
				response.getWriter().print("<script>alert(\"账号或密码错误！\");</script>");
			}
		}
	}

}
