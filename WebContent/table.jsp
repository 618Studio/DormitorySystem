<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hibernate.*" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="java.util.List" %>
<%
	//验证是否登陆
	String admin = (String)session.getAttribute("admin");
	if(admin==null)
	{
		response.sendRedirect("LogIn.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>table</title>
	<link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
   	<link href='http://fonts.useso.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <!-- TABLE STYLES-->
    <link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div id="wrapper">
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li>
						<a href="admin.jsp"><i class="fa fa-dashboard"></i>Dashboard</a>
                    </li>
                    <li>
                    	<a href="table.jsp" class="active-menu"><i class="fa fa-table"></i> Responsive Tables</a>
                    </li>
                    <li>
                		<a href="uploadfile.jsp"><i class="fa fa-table"></i> File Uploading</a>
                	</li>
                </ul>
            </div>
        </nav>
        <div id="page-wrapper" >
        	<div class="header"> 
        		<h1 class="page-header">
        			Table 
        			<small>welcome</small>
        		</h1>
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li class="active">Tables</li>
				</ol> 
			</div>
			<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
                             	Detail
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Student ID</th>
                                            <th>Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                                            <th>Whether to fill</th>
                                            <th>Room&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    	Session sess = HibernateUtil.getSessionFactory().openSession();
                                    	Query query = sess.createQuery("select stu from Students stu");
                                    	List<Students> list = query.list();
                                    	for(Students stu: list)
                                    	{
                                    		out.println("<tr class=\"odd gradeX\">");
                                    		out.println("<td>"+stu.getSno()+"</td>");
                                    		out.println("<td>"+stu.getSname()+"</td>");
                                    		if(stu.getQuestion()==null){
                                    			out.println("<td style='color:green'>是</td>");
                                    		}
                                    		else{
                                    			out.println("<td style='color:red'>否</td>");
                                    		}
                                    		if(stu.getDormitory()!=null){
                                    			out.println("<td>"+stu.getDormitory().getDroomNr()+"</td>");
                                    		}
                                    		else
                                    		{
                                    			out.println("<td>无</td>");
                                    		}
                                    		out.println("</tr>");
                                    		
                                    	}
                                    	sess.close();
                                    %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
              	</div>
         	</div>
        </div>
		</div>
	</div>
	<script src="assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    <!-- DATA TABLE SCRIPTS -->
    <script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script>
    	$(document).ready(function () {
    		$('#dataTables-example').dataTable();
        });
    </script>

</body>
</html>