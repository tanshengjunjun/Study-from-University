<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@page import="com.logic.*" %>
   	<%@page import="java.util.*" %>
    <%
    String path = request.getContextPath();//path是/QXBK2
	OrdinaryUser user = (OrdinaryUser)session.getAttribute("user");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template" />
	<meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	

	

  	<!-- Facebook and Twitter integration -->
	<!--<meta property="og:title" content=""/>-->
	<!--<meta property="og:image" content=""/>-->
	<!--<meta property="og:url" content=""/>-->
	<!--<meta property="og:site_name" content=""/>-->
	<!--<meta property="og:description" content=""/>-->
	<!--<meta name="twitter:title" content="" />-->
	<!--<meta name="twitter:image" content="" />-->
	<!--<meta name="twitter:url" content="" />-->
	<!--<meta name="twitter:card" content="" />-->

	<!-- <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,600,400italic,700' rel='stylesheet' type='text/css'> -->
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	<script>
		function store() {
			var th=user_info;
			if(confirm("确认保存修改？")){
			    th.submit();
			    th.action="<%=path%>/QXBK2/ChangeInfoAction";
            }
        }
	</script>
	</head>
	<body>
		
	<div class="fh5co-loader"></div>
	
	<div id="page">
	<nav class="fh5co-nav" role="navigation">
		<div class="container">
			<div class="row">
				<div class="col-xs-2">
					<div id="fh5co-logo"><a href="l_index.jsp">千寻百科</a></div>
				</div>
				<div class="col-xs-10 text-right menu-1">
					<ul>
						<li><a href="l_index.jsp">主页</a></li>
						<li><a href="l_class.jsp">分类</a></li>
						<li><a class="theme-login" href="l_create_entry.jsp">创建词条</a></li>
						<li class="active has-dropdown">
							<a href="#"><%=user.getName()%>，欢迎您！</a>
							<ul class="dropdown">
								<li><a href="l_user_info.jsp">个人信息</a></li>
								<li><a href="l_edited_entry.jsp">已编辑词条</a></li>
							</ul>
						</li>
						<li><a href="index.jsp">注销登录</a></li>
					</ul>
				</div>
			</div>
			
		</div>
	</nav>

	<header id="fh5co-header" class="fh5co-cover fh5co-cover-lm" role="banner" style="background-image:url(images/QYQX3.jpg);background-position: center; background-size: 100%;">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>个人信息</h1>
							<h2>This world need your help!</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div id="fh5co-contact">
		<div class="container">
			<div class="row">
				<div id="register" class="col-md-6 col-md-offset-3 animate-box">
					<h3>个人信息：</h3>
					<form name="user_info">
						<div class="row form-group">
							<div class="col-md-6">
								<!-- <label for="fname">First Name</label> -->
								<input type="text" name="name" class="form-control" placeholder="你的昵称*" value="<%=user.getName()%>">
							</div>
							<div class="col-md-6">
								<select name="sex" class="form-control">
								<%if(user.getSex().equals("男")){ %>
									<option selected value="男">男</option>
									<option value="女">女</option>
								<%}else if(user.getSex().equals("女")){%>
									<option selected value="女">女</option>
									<option value="男">男</option>
								<%}else{ %>
									<option selected value=""></option>
									<option value="男">男</option>
									<option value="女">女</option>
								<%} %>
								</select>
							</div>
						</div>

						<div class="row form-group">
							<div class="col-md-12">
								<!-- <label for="email">Email</label> -->
								<h2><%=user.getEmail()%></h2>
							</div>
						</div>

						<div class="row form-group">
							<div class="col-md-12">
								<!-- <label for="email">Email</label> -->
								<input type="tel" name="phone" class="form-control" placeholder="你的手机号码" value="<%=user.getPhone()%>">
							</div>
						</div>

						<div class="row form-group">
							<div class="col-md-12">
								<!-- <label for="message">Message</label> -->
								<textarea name="introduction" cols="30" rows="6" class="form-control" placeholder="个性签名。Say something about you."><%=user.getIntroduction()%></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6 col-md-offset-9 col-sm-6">
								<button onclick="store()" class="btn btn-primary">确认修改</button>
							</div>
						</div>

					</form>
				</div>
			</div>

		</div>
	</div>

	<!--<div id="fh5co-started">-->
		<!--<div class="container">-->
			<!--<div class="row animate-box">-->
				<!--<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">-->
					<!--<h2>Lets Get Started</h2>-->
					<!--<p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>-->
				<!--</div>-->
			<!--</div>-->
			<!--<div class="row animate-box">-->
				<!--<div class="col-md-8 col-md-offset-2">-->
					<!--<form class="form-inline">-->
						<!--<div class="col-md-6 col-md-offset-3 col-sm-6">-->
							<!--<button type="submit" class="btn btn-default btn-block">Get In Touch</button>-->
						<!--</div>-->
					<!--</form>-->
				<!--</div>-->
			<!--</div>-->
		<!--</div>-->
	<!--</div>-->

	<footer>
		<div class="container">

			<div class="row copyright">
				<div class="col-md-12 text-center">
					<p>
						<small class="block">&copy; 2016 Free HTML5. All Rights Reserved.</small> 
						<small class="block">More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a> Demo Images: <a href="#" target="_blank">Unsplash</a></small>
					</p>
					<p>
						<ul class="fh5co-social-icons">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-facebook"></i></a></li>
							<li><a href="#"><i class="icon-linkedin"></i></a></li>
							<li><a href="#"><i class="icon-dribbble"></i></a></li>
						</ul>
					</p>
				</div>
			</div>

		</div>
	</footer>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>

	</body>
</html>
