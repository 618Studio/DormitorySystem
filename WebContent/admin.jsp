<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hibernate.*" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//验证是否登陆
	String admin = (String)session.getAttribute("admin");
	if(admin==null)
	{
		response.sendRedirect("LogIn.jsp");
		return;
	}	
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Administrator</title>
	<link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
   
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <link href='http://fonts.useso.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">
</head>
<body>
	<div id="wrapper">
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li>
						<a class="active-menu" href="admin.jsp"><i class="fa fa-dashboard"></i> Dashboard</a>
					</li>
                	<li>
                		<a href="table.jsp"><i class="fa fa-table"></i> Table</a>
                	</li>
                	<li>
                		<a href="uploadfile.jsp"><i class="fa fa-table"></i> File Uploading</a>
                	</li>
            	</ul>
        	</div>
    	</nav>
		<div id="page-wrapper">
			<div class="header"> 
				<h1 class="page-header">
					Dashboard 
					<small>Welcome</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li class="active">Dashboard</li>
				</ol> 
			</div>
			<div id="page-inner">
				<div class="row" >
					<div class="col-md-4 col-md-offset-1" style="top:20px;">
						<div class="panel panel-default">
							<div class="panel-body easypiechart-panel">
							<% 
								//计算总人数
								Session sess = HibernateUtil.getSessionFactory().openSession();
								Query query = sess.createQuery("select count(*) from Students stu");
								int totalCount = Integer.valueOf(query.uniqueResult().toString());
								System.out.println(totalCount);
								//计算填写问卷人数
								query = sess.createQuery("select count(*) from Question q");
								int sumbitCount = Integer.valueOf(query.uniqueResult().toString());
								System.out.println(sumbitCount);
								int percent = 0;
								if(totalCount!=0)
								{
									percent = sumbitCount*100/totalCount;
								}
								else{
									percent = 0;
								}
								
								
								int percent2 = 100 - percent;
															
							%>
								<h4>Completed Percentage</h4>
								<div class="easypiechart" id="easypiechart-blue" data-percent="<%= percent %>" >
									<span class="percent"><%= percent %>%</span>
								</div>
								
								

      							</div>
							</div>
						</div>
						
						<div class="col-md-4 col-md-offset-1" style="top:20px;">
							<div class="panel panel-default">
								<div class="panel-body easypiechart-panel">
								
									 <h4>Number of Uncompleted</h4>
									 <div class="easypiechart" id="easypiechart-teal" data-percent="<%= percent2 %>" >
										<span class="percent"><%= totalCount-sumbitCount %></span>
									 </div>
									 
								</div>
							</div>		
						</div>
					
				</div>
				
				<div class="col-md-6 col-md-offset-4" style="top:50px">
					<p>
					<%
					query = sess.createQuery("select count(*) from Students stu where stu.dormitory is not null");
					int ifmatching = Integer.valueOf(query.uniqueResult().toString());			
					if(ifmatching==0)
					{
						%>
							<button  id="button" type="button" class="btn btn-primary btn-lg" onclick="Submit()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;START&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MATCHING&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>		
						<% 
					}
					else{
						%>
							<button  id="button" type="button" class="btn btn-primary btn-lg" onclick="Submit()" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;START&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MATCHING&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>		
						<%
					}
					%>
					  		
					</p>
						
				</div>
				<div id="alert" class="alert alert-success alert-dismissible col-md-7 col-md-offset-2" role="alert" style="text-align:center;margin-top:80px;display:none">
					<input type="button" class="close" data-dismiss="alert" aria-label="Close" /><h3>&nbsp;&nbsp;&nbsp;&nbsp;Match&nbsp; Successfully &nbsp;!</h3></div>
				
				
					
			</div>
		</div>
	</div>
	
	<script src="assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Morris Chart Js -->
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	<script src="js/admin.js"></script>

	

    
</body>
</html>