package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.Manager;

/**
 * Servlet implementation class DeleteEntryAction
 */
@WebServlet("/DeleteEntryAction")
public class DeleteEntryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEntryAction() {
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
		
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		
		int entry_id=Integer.parseInt(request.getParameter("entry_id"));
		if(manager.deleteEntry(entry_id)){
			//µ¯»Ø¹ÜÀíÔ±Ö÷Ò³Ãæ
			response.getWriter().print("<script>alert(\"É¾³ý³É¹¦£¡\");</script>");
	        response.sendRedirect(path + "/g_index.jsp");
		}
		else
			//É¾³ýÊ§°Üµ¯¿ò
			response.getWriter().print("<script>alert(\"É¾³ýÊ§°Ü£¡\");</script>");
	}

}
