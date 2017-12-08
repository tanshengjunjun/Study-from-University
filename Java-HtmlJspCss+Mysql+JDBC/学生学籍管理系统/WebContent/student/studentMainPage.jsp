<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.dal.student.*" %>
    <%
String path = request.getContextPath();
StudentVO student = (StudentVO)session.getAttribute("studentVO");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生主页</title>
    <link rel="stylesheet" type="text/css" href="../style/page/style.css">
    <link rel="stylesheet" type="text/css" href="../style/button/style2.css">
    <!-- Buttons 库的核心文件 -->
    <link rel="stylesheet" href="../style/button/buttons.css">
</head>
<body>
<header>
    <h1>学生学籍管理系统</h1>
</header>

<nav>
    <a href="info_personal.jsp" target="iframe" class="button button-block button-rounded button-primary button-width-small">个人信息</a>
    <a href="course_table.html" target="iframe" class="button button-block button-rounded button-primary button-width-small">查看课表</a>
    <a href="course_grade.html" target="iframe" class="button button-block button-rounded button-primary button-width-small">成绩查询</a>
    <a href="take_system.html" target="iframe" class="button button-block button-rounded button-primary button-width-small">选课系统</a>
</nav>

<section>
    <iframe src="info_personal.jsp" width=100% height="500" frameborder="0" name="iframe"></iframe>
</section>

<footer>
    <%=student.getName()%>同学，欢迎你！<a href="../login.jsp">注销登录</a>
</footer>


</body>
</html>