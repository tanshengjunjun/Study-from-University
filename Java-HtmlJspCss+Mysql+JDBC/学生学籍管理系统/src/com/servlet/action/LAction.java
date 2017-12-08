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
				//ѧ����¼ҳ��
//				out.write(studentVO.getName()+"��¼�ɹ�");
				List list=null;
				request.getSession().setAttribute("studentVO", studentVO); 
		        response.sendRedirect(path + "/student/studentMainPage.jsp");
			}
			else{
				//��¼ʧ��ҳ��
				out.write("��¼ʧ��");
			}
		}
		else if(user instanceof Teacher){
			teacherVO =(TeacherVO) user.login(ID, password);
			if(teacherVO != null){
				//��ʦ��¼ҳ��
				out.write(teacherVO.getName()+"��¼�ɹ�");
			}
			else{
				//��¼ʧ��ҳ��
				out.write("��¼ʧ��");
			}
		}
		else if(user instanceof Manager){
			//д����ԱDAO
		}
		out.flush();
		out.close();
	}

}
