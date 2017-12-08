package com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.logic.Entry;
import com.logic.OrdinaryUser;

/**
 * Servlet implementation class CreateEntryAction
 */
@WebServlet("/CreateEntryAction")
public class CreateEntryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEntryAction() {
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
		
		OrdinaryUser user = (OrdinaryUser)request.getSession().getAttribute("user");

		String title=request.getParameter("title");
//		title=new String(title.getBytes("iso-8859-1"),"UTF-8");
		String brief=request.getParameter("brief");
//		brief=new String(brief.getBytes("iso-8859-1"),"UTF-8");
		String category=request.getParameter("category");
//		category=new String(category.getBytes("iso-8859-1"),"UTF-8");
		String summary=request.getParameter("summary");

		//�����������������ݿ�entry��
		Entry entry=new Entry(title,brief,category);
		entry.createEntry();
		entry.updateIndex();
		
		//�������ݿ�attribute���edit��
		if(entry.insertSummary(summary, user.getEmail())){
			//���û��ӷ֣��������ݿ�user��
			user.setTot_score(user.getTot_score()+2);
			user.changeInfo();
		}

		//��ȥ�ô���ҳ��
        response.sendRedirect(path + "/l_entry.jsp?entry_id="+entry.getEntry_id());
	}

}
