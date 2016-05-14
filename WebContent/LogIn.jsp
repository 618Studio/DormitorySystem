<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Log In</title>
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-gray">
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">Log In</h1>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="jump.jsp" method="post">
				<div class="form-group">
					<div class="col-xs-12">		            
		            	<div class="control-wrapper">
		            		<label for="Student ID" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
		            		<input type="text" class="form-control" id="studentID" name="studentID" placeholder="Student ID" pattern="[0-9]{12}" title="如：201419630101" required>
		            	</div>
		            </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		            	<input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
		            </div>
		          </div>
		        </div>
		        <div style="display:none" id="wrong">
			        <div class="col-md-5 col-md-offset-9" >
			        	<h3 class="label label-danger">wrong password!</h3>
			        </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		          		<input type="button" value="Log in" class="btn btn-info" onclick="Submit()">
		          		<a href="javascript:;" class="text-right pull-right" data-toggle="modal" data-target="#templatemo_modal">Forget Password?</a>
		          	</div>
		          </div>
		        </div>
			</form>
		</div>
	</div>
	
	
	<!-- Modal -->
	<div class="modal fade" id="templatemo_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">About Forget Password</h4>
	      </div>
	      <div class="modal-body">
	      	<p>If you forget your password and didn't reset password,you can try your student id as password.</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>	
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
</body>
</html>