<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<title>Uploading</title>
	<link href="fileinput/css/default.css" rel="stylesheet" />
	    
	<link href="assets/css/bootstrap.css" rel="stylesheet" />
	<!-- File -->
	<link href="fileinput/css/fileinput.css" type="text/css" rel="stylesheet" type="text/css" />

    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
   	<link href='http://fonts.useso.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   

 

    	
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
                    	<a href="table.jsp"><i class="fa fa-table"></i> Table</a>
                    </li>
                    <li>
                		<a  class="active-menu" href="uploadfile.jsp"><i class="fa fa-table"></i> File Uploading</a>
                	</li>
                </ul>
            </div>
        </nav>
        <div id="page-wrapper" >
        	<div class="header"> 
        		<h1 class="page-header">
        			Uploading
        			<small>welcome</small>
        		</h1>
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li class="active">Uploading</li>
				</ol> 
			</div>
			<div id="page-inner">
				<form  class="form-horizontal" enctype="multipart/form-data" method="post" action="getfile">
					<div class="form-group"  style="padding-top:50px">
						<label  class="col-lg-2 col-lg-offset-2 control-label">Submit Dormitories</label>
						<div class="col-lg-4">
							<input id="file1" type="file" class="file" name="file1">
						</div>
					</div>
						
					<div class="form-group" style="padding-top:30px">
						<label  class="col-lg-2 col-lg-offset-2 control-label">Submit Students</label>
						<div class="col-lg-4">
							<input id="file2" type="file" class="file" name="file2">
						</div>
					</div>
						
					<div class="form-group" ></div>
					<div class="form-group" style="padding-top:30px">
						<div class="col-lg-offset-5 col-lg-3">
							<button type="submit" class="btn btn-success btn-default  btn-lg" onclick="return Submit()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; SUBMIT &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
						</div>
					</div>
			  	</form>	
        	</div>
		</div>
	</div>
	<script src="assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->

    <!-- File -->
    <script src="fileinput/js/fileinput.js"></script>

	
	<script type="text/javascript">
		$("#file1").fileinput({
		    showUpload: false,
			maxFilesNum: 1,
			 maxFileSize: 10000,
			allowedFileExtensions: ['csv'],
		    previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
		});
		
		$("#file2").fileinput({
		    showUpload: false,
			maxFilesNum: 1,
			 maxFileSize: 10000,
			allowedFileExtensions: ['csv'],
		    previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
		});
	</script>
	

</body>
</html>