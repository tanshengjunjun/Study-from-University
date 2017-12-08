<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();//path是/QXBK2 
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //basePath是http://localhost:8080/QXBK2/
    request.getSession().setAttribute("state",0);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>百科分类</title>
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


		<!--登录弹框-->
		<link rel="stylesheet" href="css/login.css">
		<script src="js/jquery.min.js"></script>
		<script>
            jQuery(document).ready(function($) {
                $('.theme-login').click(function(){
                    $('.overlay').fadeIn(100);
                    $('.acover').fadeIn(100);
                    $('.login').slideDown(200);
                })
                $('.acover').click(function(){
                    $('.acover').fadeOut(100);
                    $('.overlay').fadeOut(100);
                    $('.login').slideUp(200);
                })
				//点击图片
//				$('.project-grid').click(function(){
//                    alert("1");
//                })
            })

            function dosubmit() {
                var th = loginform;

                if (th.userID.value == "") {
                    alert("用户名不能为空");
                    th.userID.focus();
                    return false;
                }

                else if (th.password.value == "") {
                    alert("密码不能为空");
                    th.password.focus();
                    return false;
                }
                else{
                    th.action="<%=path%>/QXBK2/LoginAction";
                    th.submit();
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
					<div id="fh5co-logo"><a href="index.jsp">千寻百科</a></div>
				</div>
				<div class="col-xs-10 text-right menu-1">
					<ul>
						<li><a href="index.jsp">主页</a></li>
						<li class="active"><a href="class.jsp">分类</a></li>
						<li><a class="theme-login" href="javascript:;">创建词条</a></li>
						<!--<li class="has-dropdown">-->
							<!--<a href="services.jsp">Services</a>-->
							<!--<ul class="dropdown">-->
								<!--<li><a href="#">Web Design</a></li>-->
								<!--<li><a href="#">eCommerce</a></li>-->
								<!--<li><a href="#">Branding</a></li>-->
								<!--<li><a href="#">API</a></li>-->
							<!--</ul>-->
						<!--</li>-->
						<!--<li class="has-dropdown">-->
							<!--<a href="#">Tools</a>-->
							<!--<ul class="dropdown">-->
								<!--<li><a href="#">HTML5</a></li>-->
								<!--<li><a href="#">CSS3</a></li>-->
								<!--<li><a href="#">Sass</a></li>-->
								<!--<li><a href="#">jQuery</a></li>-->
							<!--</ul>-->
						<!--</li>-->
						<li><a href="register.jsp#fh5co-contact">注册</a></li>
						<li class="btn-cta"><a class="theme-login" href="javascript:;"><span>登录</span></a></li>
					</ul>
				</div>
			</div>

		</div>
	</nav>

	<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm" role="banner" style="background-image:url(images/QYQX2.jpg); background-position: center; background-size: 100%;">

		<div class="overlay">
			<!--登录弹框-->
			<br><br><br><br><br><br>

			<div class="acover"></div>
			<div class="login">
				<div class="login-screen">
					<div class="app-title">
						<h1 style="font-family:'Helvetica'">Login</h1>
					</div>
					<form name="loginform">
						<div class="login-form">
							<div class="control-group">
								<input type="email" class="login-field"  name="userID" value="" placeholder="  E-mail Address" id="login-name">
								<label class="login-field-icon fui-user" for="login-name"></label>
							</div>

							<div class="control-group">
								<input type="password" class="login-field"  name="password" value="" placeholder="  password" id="login-pass">
								<label class="login-field-icon fui-lock" for="login-pass"></label>
							</div>

							<label><input name="userType" type="radio" value="user" checked>用户</label>
							<label><input name="userType" type="radio" value="manager">管理员</label>
							<a class="btn blue btn-primary btn-large btn-block" onclick="dosubmit()" >Go!</a>
							<a class="login-link" style="color: black"  href="register.jsp#fh5co-contact">忘记密码</a>
							<a class="login-link" style="color: black"  href="register.jsp#fh5co-contact">注册账号</a>
						</div>
					</form>
				</div>
			</div>

		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>百科分类</h1>
							<h2>A colorful world are waiting for you!</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div id="fh5co-project">
		<div class="container">
			<div class="row">
				<div class="col-md-4 animate-box">
					<div onclick="window.open('one_class.jsp?category=艺术')" class="project-grid" style="background-image:url(images/class/art.jpg);">
						<div class="desc">
							<span>千寻百科</span>
							<h3><a href="#">艺术-Art</a></h3>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div onclick="window.open('one_class.jsp?category=科学')" class="project-grid" style="background-image:url(images/class/science.png);">
						<div class="desc">
							<span>千寻百科</span>
							<h3><a href="#">科学-Science</a></h3>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div onclick="window.open('one_class.jsp?category=自然')" class="project-grid" style="background-image:url(images/class/nature.png);">
						<div class="desc">
							<span>千寻百科</span>
							<h3><a href="#">自然-Nature</a></h3>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div onclick="window.open('one_class.jsp?category=文化')" class="project-grid" style="background-image:url(images/class/culture.png);">
						<div class="desc">
							<span>千寻百科</span>
							<h3><a href="#">文化-Culture</a></h3>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div onclick="window.open('one_class.jsp?category=地理')" class="project-grid" style="background-image:url(images/class/geography.png);">
						<div class="desc">
							<span>千寻百科</span>
							<h3><a href="#">地理-Geography</a></h3>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div onclick="window.open('one_class.jsp?category=生活')" class="project-grid" style="background-image:url(images/class/life.jpg);">
						<div class="desc">
							<span>千寻百科</span>
							<h3><a href="#">生活-Life</a></h3>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div onclick="window.open('one_class.jsp?category=社会')" class="project-grid" style="background-image:url(images/class/society.png);">
						<div class="desc">
							<span>千寻百科</span>
							<h3><a href="#">社会-Society</a></h3>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div onclick="window.open('one_class.jsp?category=人物')" class="project-grid" style="background-image:url(images/class/personage.jpg);">
						<div class="desc">
							<span>千寻百科</span>
							<h3><a href="#">人物-Personage</a></h3>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div onclick="window.open('one_class.jsp?category=经济')" class="project-grid" style="background-image:url(images/class/economic.jpg);">
						<div class="desc">
							<span>千寻百科</span>
							<h3><a href="#">经济-Economic</a></h3>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div onclick="window.open('one_class.jsp?category=体育')" class="project-grid" style="background-image:url(images/class/sports.jpg);">
						<div class="desc">
							<span>千寻百科</span>
							<h3><a href="#">体育-Sports</a></h3>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div onclick="window.open('one_class.jsp?category=历史')" class="project-grid" style="background-image:url(images/class/history.jpg);">
						<div class="desc">
							<span>千寻百科</span>
							<h3><a href="#">历史-History</a></h3>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div onclick="window.open('one_class.jsp?category=其他')" class="project-grid" style="background-image:url(images/class/others.jpg);">
						<div class="desc">
							<span>千寻百科</span>
							<h3><a href="#">其他-Others</a></h3>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	
	<div id="fh5co-started">
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>精确查找</h2>
					<p>If you aren't satisfied with the classes above, you can search what you want here.</p>
				</div>
			</div>
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2">
					<form class="form-inline">
						<div class="col-md-6 col-sm-6">
							<div class="form-group">
								<!--<label for="email" class="sr-only">Email</label>-->
								<input type="text" class="form-control" id="email" name="target" placeholder="what?">
							</div>
						</div>
						<div class="col-md-6 col-sm-6">
							<button type="submit" class="btn btn-default btn-block">Search</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

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
