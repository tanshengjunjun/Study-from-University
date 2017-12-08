package com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.*;

/**
 * Servlet implementation class ChangeInfoAction
 */
@WebServlet("/ChangeInfoAction")
public class ChangeInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeInfoAction() {
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

	    OrdinaryUser user = (OrdinaryUser)request.getSession().getAttribute("user");
	    
        String name=request.getParameter("name");
//        name=new String(name.getBytes("iso-8859-1"),"UTF-8");
		user.setName(name);
		
        String sex=request.getParameter("sex");
//        sex=new String(sex.getBytes("iso-8859-1"),"UTF-8");
		user.setSex(sex);
		
		user.setPhone(request.getParameter("phone"));
		
		String introduction=request.getParameter("introduction");
//        introduction=new String(introduction.getBytes("iso-8859-1"),"UTF-8");
		user.setIntroduction(introduction);
		
		System.out.println(user+" changes informations: "+user.changeInfo());
        response.sendRedirect(path + "/l_user_info.jsp");
	}

}
