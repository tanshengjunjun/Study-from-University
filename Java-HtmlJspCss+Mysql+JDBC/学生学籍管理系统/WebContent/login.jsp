<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();//path是/SSMS2 
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //basePath是http://localhost:8080/SSMS2/
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生学籍管理系统</title>
    <script type="text/javascript" >
        function dosubmit() {
            var th = loginform;
            if (th.userID.value == "") {
                alert("用户名不能为空");
                th.userID.focus();
                return;
            }

            if (th.password.value == "") {
                alert("密码不能为空");
                th.password.focus();
                return;
            }
            th.action="<%=path%>/SSMS2/LAction"
            th.submit();
        }
        function lostpassword() {

            alert("初始密码一般为生日如：19950101\n或者与班主任联系。")
        }
    </script>
    <link rel="stylesheet" type="text/css" href="style/page/login.css">
    <link rel="stylesheet" type="text/css" href="style/page/style.css">
</head>
<body>
    <header>
        <h1>学生学籍管理系统</h1>
    </header>

        <div class="login">
            <div class="login-screen">
                <div class="app-title">
                    <h1>登录</h1>
                </div>
                <form name="loginform">
                    <div class="login-form">
                     <div class="control-group">
                        <input type="number" class="login-field"  name="userID" value="" placeholder="userID" id="login-name">
                        <label class="login-field-icon fui-user" for="login-name"></label>
                     </div>

                     <div class="control-group">
                        <input type="password" class="login-field"  name="password" value="" placeholder="password" id="login-pass">
                        <label class="login-field-icon fui-lock" for="login-pass"></label>
                     </div>

                        <button class="btn btn-primary btn-large btn-block" onclick="dosubmit()" name="userType" value="student">学生登录</button>
                        <button class="btn btn-primary btn-large btn-block" onclick="dosubmit()" name="userType" value="teacher">教师登录</button>
                        <button class="btn btn-primary btn-large btn-block" onclick="dosubmit()" name="userType" value="manager">管理员登录</button>
                        <a class="login-link"  href="login.jsp" onclick="lostpassword()">Lost your password?</a>
                    </div>
                </form>
            </div>
        </div>

    <footer class="loginfooter">
        小组成员：戴春辉，崔楚文，谭声俊，刘新禧，程瑞起
    </footer>
</body>
</html>