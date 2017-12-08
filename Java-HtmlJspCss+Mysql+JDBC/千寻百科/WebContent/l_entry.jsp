<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@page import="com.logic.*" %>
   	<%@page import="com.dal.attribute.*" %>
   	<%@page import="java.util.*" %>
    <%
    String path = request.getContextPath();//path是/QXBK2
	OrdinaryUser user = (OrdinaryUser)session.getAttribute("user");
    
    int entry_id= Integer.parseInt(request.getParameter("entry_id"));
    Entry entry= Entry.searchEntry(entry_id);
    ArrayList<Entry> entryList= Entry.searchEntryByTitle(entry.getTitle());//用于多义
    ArrayList<AttributeVO> attributeList =entry.getAllAttribute();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=entry.getTitle()%>_千寻百科</title>
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
	<script type="text/javascript">
	function doedit(){
		var th=edit_entry;
		th.submit();
		th.action="l_edit_entry.jsp";
	}</script>

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
							<li class="active"><a href="l_index.jsp">主页</a></li>
							<li><a href="l_class.jsp">分类</a></li>
							<li><a class="theme-login" href="l_create_entry.jsp">创建词条</a></li>
							<li class="has-dropdown">
								<a href="#"><%=user.getName()%>，欢迎您！</a>
								<ul class="dropdown">
								<li><a href="l_user_info.jsp">个人信息</a></li>
								<li><a href="l_edited_entry.jsp">已编辑词条</a></li>
								</ul>
							</li>
							<li><a href="index.jsp">注销登录</a></li>
							<!--<li class="has-dropdown">-->
							<!--<a href="#">Tools</a>-->
							<!--<ul class="dropdown">-->
							<!--<li><a href="#">HTML5</a></li>-->
							<!--<li><a href="#">CSS3</a></li>-->
							<!--<li><a href="#">Sass</a></li>-->
							<!--<li><a href="#">jQuery</a></li>-->
							<!--</ul>-->
							<!--</li>-->
						</ul>
					</div>
				</div>

			</div>
		</nav>

	<header id="fh5co-header" class="fh5co-cover fh5co-cover-ssm" role="banner" style="background-image:url(images/QYQX10.jpg); background-position: center; background-size: 100%;">

		<div class="overlay"></div>

		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
						<%if(entry.isPassed()){%>
							<h1><%=entry.getTitle()%></h1>
						<%}else{%>
							<h1>该词条尚未通过审核！</h1>
						<%}%>
							<!--<h2>Free html5 templates Made by <a href="#" target="_blank">freehtml5.co</a></h2>-->
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<%if(entry.isPassed()){%>
	<div id="fh5co-about">
		<div class="container">
			<%if(entryList.size()>1){%>
			<div class="row animate-box">
				<p><%=entry.getTitle() %>是一个多义词，请在下列义项上选择浏览（共<%=entryList.size() %>个义项）</p>
				<%for(Entry e: entryList){%>
				<a href="l_entry.jsp?entry_id=<%=e.getEntry_id()%>"><%=(entryList.indexOf(e)+1)+"."+e.getBrief()%></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%}%>
			</div>
			<%}%>
			
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2><%=entry.getBrief()%></h2>
				</div>
				<form name="edit_entry">
					<input type="hidden" name="entry_id" value="<%=entry.getEntry_id()%>">
				<div class="form-group col-md-offset-12">
					<button class="btn btn-primary theme-login" onclick="doedit()">&nbsp;&nbsp;&nbsp;编辑&nbsp;&nbsp;&nbsp;</button>
				</div>
				</form>
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<span>创建/更新于<%=entry.getCreate_date()%></span>
				</div>
			</div>


			<div class="about-content">
				<div class="row animate-box">
					<div class="col-md-9 col-md-push-3">
						<div class="desc">
							<h3>概述</h3>
							<p><%=entry.getSummary()%></p>
						</div>
					</div>
					<div class="col-md-3 col-md-pull-9">
						<img class="img-responsive" src="images/entry/entry_<%=entry.getTitle() %>_<%=entry.getBrief() %>_<%=entry.getCategory() %>.jpg" alt="<%=entry.getTitle()%>图片">
					</div>
				</div>
				<%for(AttributeVO attributeVO : attributeList)
					if(!attributeVO.getAttribute_name().equals("概述")){%>
				<div class="row animate-box">
					<div class="col-md-12 col-md-push-0">
						<div class="desc">
							<h3><%=attributeVO.getAttribute_name()%></h3>
							<p>这里显示属性！<%=attributeVO.getContent()%></p>
						</div>
					</div>
				</div>
				<%}%>
			</div>
		</div>
	</div>
<%}%>

		<div id="fh5co-started">
			<div class="container">
				<div class="row animate-box">
					<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
						<h2>精确查找</h2>
						<p>If you aren't satisfied with the information above, you can search what you want again here.</p>
					</div>
				</div>
				<div class="row animate-box">
					<div class="col-md-8 col-md-offset-2">
						<form class="form-inline">
							<div class="col-md-6 col-sm-6">
								<div class="form-group">
									<!--<label for="email" class="sr-only">Email</label>-->
									<input type="text" class="form-control" name="target" placeholder="what?">
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
