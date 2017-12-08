<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改个人信息</title>
    <link rel="stylesheet" type="text/css" href="../style/page/table.css">
    <!-- Buttons 库的核心文件 -->
    <link rel="stylesheet" href="../style/button/buttons.css">
    
    <script>
        function besure() {
            var th = personalinfoform;
            if (confirm("确认修改信息？"))  {
                th.action="";
                alert('修改成功');
                th.submit();
            }  else  {
                ;
            };
        }
    </script>
</head>
<body>

<form name="personalinfoform">
    <table class="personalinfo" border="1">
        <caption>学生个人信息</caption>
        <tr>
            <td>姓名</td>
            <td>程瑞起</td>
            <td rowspan="4" colspan="2"><img width="129" height="172" alt="head_photo" src="../resource/photo/201430610382.png"></td>
        </tr>
        <tr>
            <td>学号</td>
            <td>201430610382</td>
        </tr>
        <tr>
            <td>性别</td>
            <td>男</td>
        </tr>
        <tr>
            <td>生日</td>
            <td>19951128</td>
        </tr>
        <tr>
            <td>民族</td>
            <td><input type="text" value="汉族" name=""></td>
            <td>政治面貌</td>
            <td><input type="text" value="共青团员" name=""></td>
        </tr>
        <tr>
            <td>学院</td>
            <td>软件学院</td>
            <td>专业</td>
            <td>软件工程</td>
        </tr>
        <tr>
            <td>班级</td>
            <td>14级1班</td>
            <td>总学分</td>
            <td>188</td>
        </tr>
        <tr>
            <td>身份证</td>
            <td>530124199511280018</td>
            <td>宿舍</td>
            <td><input type="text" value="C10-623" name=""></td>
        </tr>
        <tr>
            <td>手机</td>
            <td><input type="tel" value="18813298859" name=""></td>
            <td>邮箱</td>
            <td><input type="email" value="738170818@qq.com" name=""></td>
        </tr>
</table><br>
</form>
<a onclick="besure()" class="change button  button-rounded button-raised button-primary">保存修改</a>
</body>
</html>