<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hibernate.*" %>
<%
	String user = (String)session.getAttribute("user");
	if(user!=null)
	{
		response.sendRedirect("question.jsp");
	}
	
	if(request.getParameter("studentID")!=null)
	{
		String id = request.getParameter("studentID");
		String passwd = request.getParameter("password");
		BaseDAO<Students> baseDAO = new BaseDAO<Students>();
		Students stu = baseDAO.find(Students.class,id);
		
		//页面重定向
		if(stu!=null)
		{
			//有该账号下
			if(stu.getSpassword().equals(passwd))
			{
			//密码输入正确
				session.setAttribute("user",id);
				response.sendRedirect("question.jsp");
			}
			else
			{
				//密码输入错误
				response.sendRedirect("LogIn.jsp");
			}	
		}
		else
		{
			//没有该账号下
			response.sendRedirect("LogIn.jsp");
		}
	}
	
	
	%>