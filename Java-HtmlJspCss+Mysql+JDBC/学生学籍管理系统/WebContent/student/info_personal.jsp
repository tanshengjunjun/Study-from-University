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
<title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="../style/page/table.css">
    <!-- Buttons 库的核心文件 -->
    <link rel="stylesheet" href="../style/button/buttons.css">
</head>
<body>
<table class="personalinfo" border="1">
    <caption>学生个人信息</caption>
    <tr>
        <td>姓名</td>
        <td><%=student.getName() %></td>
        <td rowspan="4" colspan="2"><img width="129" height="172" alt="head_photo" src="../resource/photo/201430610382.png"></td>
    </tr>
    <tr>
        <td>学号</td>
        <td><%=student.getID() %></td>
    </tr>
    <tr>
        <td>性别</td>
        <td><%=student.getSex() %></td>
    </tr>
    <tr>
        <td>生日</td>
        <td><%=student.getBirthday() %></td>
    </tr>
    <tr>
        <td>民族</td>
        <td><%=student.getNation() %></td>
        <td>政治面貌</td>
        <td><%=student.getPolitic() %></td>
    </tr>
    <tr>
        <td>学院</td>
        <td><%=student.getDept_name() %></td>
        <td>专业</td>
        <td><%=student.getMajor() %></td>
    </tr>
    <tr>
        <td>班级</td>
        <td><%=student.getClassNumber() %></td>
        <td>总学分</td>
        <td><%=student.getTot_cred() %></td>
    </tr>
    <tr>
        <td>身份证</td>
        <td><%=student.getIdentification() %></td>
        <td>宿舍</td>
        <td><%=student.getAddress() %></td>
    </tr>
    <tr>
        <td>手机</td>
        <td><%=student.getPhone() %></td>
        <td>邮箱</td>
        <td><%=student.getEmail() %></td>
    </tr>
</table><br>

<a href="info_studentchange.jsp" class="change button  button-rounded button-raised button-primary">修改信息</a>
</body>
</html>