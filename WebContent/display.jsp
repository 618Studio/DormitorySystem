<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hibernate.*" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="java.util.List" %>
<%
	//验证是否登录
	Students user = (Students)session.getAttribute("user");
	if(user==null)
	{
		response.sendRedirect("LogIn.jsp");
		return;
	}
	List<Students> stuList = null;
	Dormitory dor = null;
	//如果寝室属性已有，说明寝室分配完毕
	if(user.getDormitory() != null)
	{
		//查找同寝室的人
		BaseDAO<Dormitory> baseDAO = new BaseDAO<Dormitory>();
		dor = baseDAO.find(Dormitory.class,user.getDormitory().getDroomNr());
		Session sess = HibernateUtil.getSessionFactory().openSession();
		//+dor.getDroomNr()
		Query query = sess.createQuery("select stu from Students stu where stu.dormitory=:dor").setParameter("dor",dor);
		stuList = query.list();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>display</title>
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<style type="text/css" media="screen">
		
		* {margin: 0; padding: 0; }
		body {
			font-family: Ubuntu, arial, verdana;
			background:#0586AD;
		}
		
		/*----------
		Blocks
		----------*/
		/*Pricing table and price blocks*/
		.pricing_table {
			line-height: 150%; 
			font-size: 12px; 
			margin: 0 auto; 
			width: 75%; 
			max-width: 800px; 
			padding-top: 10px;
			margin-top: 100px;
		}
		
		.price_block {
			text-align: center; 
			width: 100%; 
			color: #fff; 
			float: left; 
			list-style-type: none; 
			transition: all 0.25s; 
			position: relative; 
			box-sizing: border-box;
			
			margin-bottom: 10px; 
			border-bottom: 1px solid transparent; 
		}
		
		/*Price heads*/
		.pricing_table h3 {
			text-transform: uppercase; 
			padding: 5px 0; 
			background: #333; 
			margin: -10px 0 1px 0;
		}
		
		/*Price tags*/
		.price {
			display: table; 
			background: #444; 
			width: 100%; 
			height: 70px; 
		}
		.price_figure {
			font-size: 24px; 
			text-transform: uppercase; 
			vertical-align: middle; 
			display: table-cell;
		}
		.price_number {
			font-weight: bold; 
			display: block;
		}
		.price_tenure {
			font-size: 11px; 
		}
		
		/*Features*/
		.features {
			background: #DEF0F4; 
			color: #000;
		}
		.features li {
			padding: 8px 15px;
			border-bottom: 1px solid #ccc; 
			font-size: 11px; 
			list-style-type: none;
		}	
		.footer {
			padding: 15px; 
			background: #DEF0F4;
		}
		.action_button {
			text-decoration: none; 
			color: #fff; 
			font-weight: bold; 
			border-radius: 5px; 
			background: linear-gradient(#666, #333); 
			padding: 5px 20px; 
			font-size: 11px; 
			text-transform: uppercase;
		}
		
		.price_block:hover {
			box-shadow: 0 0 0px 5px rgba(0, 0, 0, 0.5); 
			transform: scale(1.04) translateY(-5px); 
			z-index: 1; 
			border-bottom: 0 none;
		}
		.price_block:hover .price {
			background:linear-gradient(#DB7224, #F9B84A); 
			box-shadow: inset 0 0 45px 1px #DB7224;
		}
		.price_block:hover h3 {
			background: #222;
		}
		.price_block:hover .action_button {
			background: linear-gradient(#F9B84A, #DB7224); 
		}
		
		
		@media only screen and (min-width : 480px) and (max-width : 768px) {
			.price_block {width: 50%;}
			.price_block:nth-child(odd) {border-right: 1px solid transparent;}
			.price_block:nth-child(3) {clear: both;}
			
			.price_block:nth-child(odd):hover {border: 0 none;}
		}
		@media only screen and (min-width : 768px){
			.price_block {width: 25%;}
			.price_block {border-right: 1px solid transparent; border-bottom: 0 none;}
			.price_block:last-child {border-right: 0 none;}
			
			.price_block:hover {border: 0 none;}
		}
		
		.skeleton, .skeleton ul, .skeleton li, .skeleton div, .skeleton h3, .skeleton span, .skeleton p {
			border: 5px solid rgba(255, 255, 255, 0.9);
			border-radius: 5px;
			margin: 7px !important;
			background: rgba(0, 0, 0, 0.05) !important;
			padding: 0 !important;
			text-align: left !important;
			display: block !important;
			
			width: auto !important;
			height: auto !important;
			
			font-size: 10px !important;
			font-style: italic !important;
			text-transform: none !important;
			font-weight: normal !important;
			color: black !important;
		}
		.skeleton .label {
			font-size: 11px !important;
			font-style: italic !important;
			text-transform: none !important;
			font-weight: normal !important;
			color: white !important;
			border: 0 none !important;
			padding: 5px !important; 
			margin: 0 !important;
			float: none !important;
			text-align: left !important;
			text-shadow: 0 0 1px white;
			background: none !important;
		}
		.skeleton {
			display: none !important;
			margin: 100px !important;
			clear: both;
		}
	</style>
</head>
<body>
	<div class="col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3">
    <div id="tablePane" class="panel panel-success ">
		<div class="panel-heading" style="text-align:center;color:black" >寝 室 分 配 结 果</div>
		
		<div class="panel-body" style="">
			<div class="page-header">
			
			<%
				if(user.getDormitory() == null)
				{
				%>
					<h3 style="text-align:center;color:red">分 配 结 果 还 未 公 布，请 耐 心 等 待！</h3>
				<%
				}
				else
				{
					%>
						<h3 style="text-align:center;color:green">寝 室 分 配 已 完 成，结 果 如 下：<br/><br/><small>寝 室 号：<%= dor.getDroomNr()%></small></h3>
					<%
				}

			%>	
			
			</div>
		</div>
		
	</div>
	</div>
			
						
		   <%	
		   if(user.getDormitory() != null)
		   {
			    %>
			    <ul class="pricing_table">
		   		<% 
			 	//列出该寝室所有人信息
				for(Students stu: stuList)
				{	
					BaseDAO<Question> baseDAO_Q = new BaseDAO<Question>();
					Session sess_Q = HibernateUtil.getSessionFactory().openSession();
					Question question = baseDAO_Q.find(Question.class, stu.getSno());
					%>
					<li class="price_block">
							<div class="price">
								<div class="price_figure">
									<span class="price_number"><%= stu.getSname()%></span>
								</div>
							</div>
							<ul class="features">
							<%
								if(question!=null && question.getQfuture()==1)
								{
								%>
									<li>未来规划：留 学</li>
								<%	
								}
								else if(question!=null && question.getQfuture()==2)
								{
								%>
									<li>未来规划：读 研</li>
								<%	
								}
								else if(question!=null && question.getQfuture()==3)
								{
								%>
									<li>未来规划：工 作</li>
								<%	
								}
								else
								{
								%>
									<li>未来规划：未 考 虑</li>
								<%	
								}
							%>
								
							<%
								if(question!=null && question.getQpart23().charAt(6)=='1'){
									out.println("<li>是否注意个人卫生：是</li>");	
								}
								else{
									out.println("<li>是否注意个人卫生：否</li>");	
								}
							
								if(question!=null && question.getQpart23().charAt(11)=='1'){
									out.println("<li>是否吸烟：是</li>");	
								}
								else{
									out.println("<li>是否吸烟：否</li>");	
								}
								
								if(question!=null && question.getQpart23().charAt(10)=='1'){
									out.println("<li>是否睡觉打呼噜，磨牙，梦游：是</li>");	
								}
								else{
									out.println("<li>是否睡觉打呼噜，磨牙，梦游：否</li>");	
								}
								
								if(question!=null && question.getQpart23().charAt(8)=='1'){
									out.println("<li>是否熬夜：是</li>");	
								}
								else{
									out.println("<li>是否熬夜：否</li>");	
								}
				%>
						</ul>
					</li>
				
				<%
				}
		   		%>
		   		</ul>
		   		<%
		   }
		   else
		   {
			%>
				<ul class="pricing_table">
					<li class="price_block">
						<div class="price">
							<div class="price_figure">
								<span class="price_number">未 匹 配</span>
							</div>
						</div>
						<ul class="features">
							<li>是否注意个人卫生：</li>
							<li>是否吸烟：</li>
							<li>是否睡觉打呼噜，磨牙，梦游：</li>
							<li>是否熬夜：</li>
							<li>未来规划：</li>
						</ul>
					</li>
					<li class="price_block">
						<div class="price">
							<div class="price_figure">
								<span class="price_number">未 匹 配</span>
							</div>
						</div>
						<ul class="features">
							<li>是否注意个人卫生：</li>
							<li>是否吸烟：</li>
							<li>是否睡觉打呼噜，磨牙，梦游：</li>
							<li>是否熬夜：</li>
							<li>未来规划：</li>
						</ul>
					</li>
					<li class="price_block">
						<div class="price">
							<div class="price_figure">
								<span class="price_number">未 匹 配</span>
							</div>
						</div>
						<ul class="features">
							<li>是否注意个人卫生：</li>
							<li>是否吸烟：</li>
							<li>是否睡觉打呼噜，磨牙，梦游：</li>
							<li>是否熬夜：</li>
							<li>未来规划：</li>
						</ul>
					</li>
					<li class="price_block">
						<div class="price">
							<div class="price_figure">
								<span class="price_number">未 匹 配</span>
							</div>
						</div>
						<ul class="features">
							<li>是否注意个人卫生：</li>
							<li>是否吸烟：</li>
							<li>是否睡觉打呼噜，磨牙，梦游：</li>
							<li>是否熬夜：</li>
							<li>未来规划：</li>
						</ul>
					</li>
				</ul>   
			<%
		   			
		   }
			%>
		   		
		   		
				
							
							
					
	
		
</body>
</html>