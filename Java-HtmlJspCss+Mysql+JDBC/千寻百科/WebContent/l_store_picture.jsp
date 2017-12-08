<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
　　<%@ page import="java.io.*"%>
　　<%@ page import="com.logic.*"%>
　　<%@ page import="com.jspsmart.upload.*"%>
<%
// 新建一个SmartUpload对象 处理文件上传
SmartUpload su = new SmartUpload(); 
// 上传初始化 
su.initialize(pageContext); 
// 设定上传限制 
// 1.限制每个上传文件的最大长度。 
// su.setMaxFileSize(10000); 
// 2.限制总上传数据的长度。 
// su.setTotalMaxFileSize(20000); 
// 3.设定允许上传的文件（通过扩展名限制）,仅允许doc,txt文件。 
su.setAllowedFilesList("jpg,png,jgeg,gif"); 
// 4.设定禁止上传的文件（通过扩展名限制）,禁止上传带有exe,bat,jsp,htm,html扩展名的文件和没有扩展名的文件。 
su.setDeniedFilesList("exe,bat,jsp,htm,html,,"); 
// 上传文件 
su.upload(); 
// 将上传文件全部保存到指定目录 
int count = su.save("D:\\Program Files (x86)\\QXBK\\temp\\");
//int count = su.save(path+"/images/temp"); 
out.println(count+"个文件上传成功！<br>"); 
%>
    <%
    String path = request.getContextPath();//path是/QXBK2
	out.println("等待跳转！<br>");
	OrdinaryUser user = (OrdinaryUser) request.getSession().getAttribute("user");
	out.println(user.getName()+" is creating entry...");

	Entry entry = (Entry) request.getSession().getAttribute("entry");
	
	//已解决中文编码
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=utf-8");

	// 利用Request对象获取参数之值 
	// out.println("TEST="+su.getRequest().getParameter("TEST")+"<BR><BR>");
	// 在Servlet中如果想要取得文本框提交的内容，不能使用request.getParameter()
	// 因为这种提交方式是以二进制进提交的，所以使用以前的取值方法取到的都是null 
	// 这时候要使用 new SmartUpload.getRequest().getParameter("name");进行取值。
	Request su_request = su.getRequest();
	String title=su_request.getParameter("title");
	String brief=su_request.getParameter("brief");
	String category=su_request.getParameter("category");
	String summary=su_request.getParameter("article_0");//概述，即第一个属性
	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="1;url=<%=path%>/QXBK2/CreateEntryAction?title=<%=title%>&brief=<%=brief%>&category=<%=category%>&summary=<%=summary%>">
<title>图片处理页面</title>
</head>
<body>
<% 
// 逐一提取上传文件信息，同时可保存文件。 
for (int i=0;i<su.getFiles().getCount();i++){ 
	com.jspsmart.upload.File file = su.getFiles().getFile(i); 

// 若文件不存在则继续 
	if (file.isMissing()) continue; 

// 显示当前文件信息 
//	out.println("<TABLE BORDER=1>"); 
//	out.println("<TR><TD>表单项名（FieldName）</TD><TD>" 
//		+ file.getFieldName() + "</TD></TR>"); 
//	out.println("<TR><TD>文件长度（Size）</TD><TD>" 
//		+ file.getSize() + "</TD></TR>"); 
//	out.println("<TR><TD>文件名（FileName）</TD><TD>"
//		+ file.getFileName() + "</TD></TR>"); 
//	out.println("<TR><TD>文件扩展名（FileExt）</TD><TD>" 
//		+ file.getFileExt() + "</TD></TR>"); 
//	out.println("<TR><TD>文件全名（FilePathName）</TD><TD>" 
//		+ file.getFilePathName() + "</TD></TR>"); 
//	out.println("</TABLE><BR>"); 

//	将文件另存 
//	另存到以WEB应用程序的根目录为文件根目录的目录下 
//	file.saveAs(path+"/images/entry/"+"entry_"+entry.getEntry_id()+"."+file.getFileExt(),su.SAVE_VIRTUAL); 
// 	另存到操作系统的根目录为文件根目录的目录下 
	file.saveAs("C:\\Users\\simba\\workspace(j2ee)\\QXBK2\\WebContent\\images\\entry\\"+"entry_"+title+"_"+brief+"_"+category+"."+file.getFileExt(),su.SAVE_PHYSICAL);
}
%> 
</body>
</html>