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
    ArrayList<AttributeVO> attributeList =entry.getAllAttribute();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑词条</title>
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


		<script language="javascript">
            i = 2;
            function add(){
                if(i<=50){
                document.getElementById("article").innerHTML+='<div id="div_'+i+'" class="col-md-7"><br><input name="title_'+i+'" type="text" class="form-control" placeholder="正文块标题"  /></div>' +
					'<div id="div1_'+i+'" class="col-md-3"><br><button class="btn btn-danger" onclick="del('+i+')">删除</button></div>'+
					'<div id="div2_'+i+'" class="col-md-12"><textarea name="article_'+i+'" cols="30" rows="7" class="form-control" placeholder="正文内容"></textarea>';
                i = i + 1;
                }
                else
                    alert("添加数目达到最大值！");
            }


            function del(o){
                document.getElementById("article").removeChild(document.getElementById("div_"+o));
                document.getElementById("article").removeChild(document.getElementById("div1_"+o));
                document.getElementById("article").removeChild(document.getElementById("div2_"+o));

            }

            function CurentTime()
            {
                var now = new Date();

                var year = now.getFullYear();       //年
                var month = now.getMonth() + 1;     //月
                var day = now.getDate();            //日

                var hh = now.getHours();            //时
                var mm = now.getMinutes();          //分
                var ss = now.getSeconds();           //秒

                var clock = year + "-";

                if(month < 10)
                    clock += "0";

                clock += month + "-";

                if(day < 10)
                    clock += "0";

                clock += day + " ";

//                if(hh < 10)
//                    clock += "0";
//
//                clock += hh + ":";
//                if (mm < 10) clock += '0';
//                clock += mm + ":";
//
//                if (ss < 10) clock += '0';
//                clock += ss;
                return(clock);
            }

            function submitentry() {
                document.getElementById("Clock").value=CurentTime();
                var th = create_entry;
//              测试当前时间显示
// 				alert(th.create_time.value);
                if (confirm("确认提交"))  {
                    th.submit();
                    th.action="";
                    alert('提交成功，等待管理员审核。');

                }  else  {
                    ;
                };
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
						<li class="active"><a class="theme-login" href="l_create_entry.jsp">创建词条</a></li>
						<li class="has-dropdown">
							<a href="#"><%=user.getName()%>，欢迎您！</a>
							<ul class="dropdown">
								<li><a href="l_user_info.jsp">个人信息</a></li>
								<li><a href="l_edited_entry.jsp">已编辑词条</a></li>
							</ul>
						</li>

						<li><a href="index.jsp">注销登录</a></li>
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
						<!--<li class="btn-cta"><a href="#fh5co-contact"><span>登录</span></a></li>-->
					</ul>
				</div>
			</div>
			
		</div>
	</nav>

	<header id="fh5co-header" class="fh5co-cover fh5co-cover-lm" role="banner" style="background-image:url(images/QYQX8.jpg);background-position: center; background-size: 100%;">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>编辑词条</h1>
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

					<div class="col-md-9 col-md-offset-1 animate-box">
						<h3>基本信息：</h3>
						<form name="create_entry">
							<div class="row form-group">
								<div class="col-md-7">
									<!-- <label for="fname">First Name</label> -->
									词条标题：<h2><%=entry.getTitle()%></h2>
								</div>
								<div class="col-md-5">
									词条类型：<h2><%=entry.getCategory()%></h2>
								</div>
							</div>

							<!--提交时间隐藏框-->
							<input type="hidden" name="create_time" id="Clock" value="">

							<div class="row form-group">
								<div class="col-md-8">
									<!-- <label for="subject">Subject</label> -->
									词条义项名：<input type="text" name="brief" class="form-control" placeholder="如果该词条有多个意义，请您对您的词条做个说明。没有请跳过。" value="<%=entry.getBrief() %>">
								</div>

								<div class="col-md-4">
									相关图片：<input type="file" class="form-control" name="picture">
								</div>
							</div>

							<div class="row form-group">
								<div class="col-md-12">
									<!-- <label for="email">Email</label> -->
									词条概述：（对这个词条做个大概的描述，让读者读过概述就能了解词条的基本内容。）
									<textarea  name="article_0" cols="30" rows="5" class="form-control" ><%=entry.getSummary()%></textarea>
								</div>
							</div>

							<h3>正文：</h3>
							<div class="row form-group" id="article">

								<div class="col-md-7">
									<!-- <label for="fname">First Name</label> -->
									<input type="text" name="title_1"  class="form-control" placeholder="正文块标题" value="正文待写！">
								</div>
								<div class="col-md-12">
									<!-- <label for="message">Message</label> -->
									<textarea name="article_1" cols="30" rows="7" class="form-control" placeholder="正文内容" value="正文待写！"></textarea>
								</div>


							</div>
							<div class="form-group">
								<button type="button" onclick="add()" id="create" class="btn btn-success">添加块</button>
								<button class="btn btn-primary col-md-offset-9" onclick="submitentry()">提交</button>
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
