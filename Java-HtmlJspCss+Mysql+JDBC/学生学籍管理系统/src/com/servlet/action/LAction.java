package com.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dal.student.StudentVO;
import com.dal.teacher.TeacherVO;
import com.logic.*;

/**
 * Servlet implementation class LAction
 */
@WebServlet("/LAction")
public class LAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
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
		
		response.setCharacterEncoding("GBK");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String ID = request.getParameter("userID");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		
		UserFactory userFactory = new UserFactory();
		User user = userFactory.getUser(userType);
		
		StudentVO studentVO = null;
		TeacherVO teacherVO = null;
		if(user instanceof Student){
			studentVO =(StudentVO) user.login(ID, password);
			if(studentVO != null){
				//Ñ§ÉúµÇÂ¼Ò³Ãæ
//				out.write(studentVO.getName()+"µÇÂ¼³É¹¦");
				List list=null;
				request.getSession().setAttribute("studentVO", studentVO); 
		        response.sendRedirect(path + "/student/studentMainPage.jsp");
			}
			else{
				//µÇÂ¼Ê§°ÜÒ³Ãæ
				out.write("µÇÂ¼Ê§°Ü");
			}
		}
		else if(user instanceof Teacher){
			teacherVO =(TeacherVO) user.login(ID, password);
			if(teacherVO != null){
				//½ÌÊ¦µÇÂ¼Ò³Ãæ
				out.write(teacherVO.getName()+"µÇÂ¼³É¹¦");
			}
			else{
				//µÇÂ¼Ê§°ÜÒ³Ãæ
				out.write("µÇÂ¼Ê§°Ü");
			}
		}
		else if(user instanceof Manager){
			//Ð´¹ÜÀíÔ±DAO
		}
		out.flush();
		out.close();
	}

}
