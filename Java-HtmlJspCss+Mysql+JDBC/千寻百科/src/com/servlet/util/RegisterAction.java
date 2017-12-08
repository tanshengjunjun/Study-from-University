package com.servlet.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.OrdinaryUser;

/**
 * Servlet implementation class RegisterAction
 */
@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAction() {
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
		
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String sex=request.getParameter("sex");
//        sex=new String(sex.getBytes("iso-8859-1"),"UTF-8");
		String introduction=request.getParameter("introduction");
//        introduction=new String(introduction.getBytes("iso-8859-1"),"UTF-8");
        
        
        OrdinaryUser user=new OrdinaryUser
        		(email, name, password, sex, phone, introduction);
        if(user.register())
            response.sendRedirect(path + "/index.jsp");
        else
			//×¢²áÊ§°Üµ¯¿ò
			response.getWriter().print("<script>alert(\"×¢²áÊ§°Ü£¡\");</script>");
        
	}

}
