package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.*;

/**
 * Servlet implementation class PassEntryAction
 */
@WebServlet("/PassEntryAction")
public class PassEntryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassEntryAction() {
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
		
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		
		int entry_id=Integer.parseInt(request.getParameter("entry_id"));
		if(manager.passEntry(entry_id))
			//弹回Entry页面
	        response.sendRedirect(path + "/g_entry.jsp?entry_id="+entry_id);
		else
			//通过失败弹框
			response.getWriter().print("<script>alert(\"通过失败！\");</script>");
		
	}

}
