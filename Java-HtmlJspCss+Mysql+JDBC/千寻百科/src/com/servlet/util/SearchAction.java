package com.servlet.util;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.Entry;

/**
 * Servlet implementation class SearchAction
 */
@WebServlet("/SearchAction")
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAction() {
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
		
		String search=request.getParameter("search");
//        search=new String(search.getBytes("iso-8859-1"),"UTF-8");
        
        System.out.println("Searching "+search+" from database now...");
        ArrayList<Entry> result = Entry.searchEntryByTitle(search);
        System.out.println("Obtain "+result.size()+" result(s)");

		int state = (int) request.getSession().getAttribute("state");
		switch(state){
		//弹出词条页面
			case 0:
				if(result.size()==0){
					//无结果弹框
					response.getWriter().print("<script>alert(\"没有结果！\");</script>");
					response.sendRedirect(path + "/index.jsp");
				}
				else
					response.sendRedirect(path + "/entry.jsp?entry_id="+result.get(0).getEntry_id());
				break;
			case 1:
				if(result.size()==0){
					//无结果弹框
					response.getWriter().print("<script>alert(\"没有结果！\");</script>");
					response.sendRedirect(path + "/l_index.jsp");
				}
				else
					response.sendRedirect(path + "/l_entry.jsp?entry_id="+result.get(0).getEntry_id());
		        break;
			case 2:
				if(result.size()==0){
					//无结果弹框
					response.getWriter().print("<script>alert(\"没有结果！\");</script>");
					response.sendRedirect(path + "/g_index.jsp");
				}
				else
					response.sendRedirect(path + "/g_entry.jsp?entry_id="+result.get(0).getEntry_id());
				break;
		}
	}

}
