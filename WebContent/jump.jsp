<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hibernate.*" %>


<%
		if(request.getParameter("studentID")!=null)
		{
			String id = request.getParameter("studentID");
			String passwd = request.getParameter("password");
			BaseDAO<Students> baseDAO = new BaseDAO<Students>();
			Students stu = baseDAO.find(Students.class,id);

			
			if(stu!=null)
			{
				//有该账号下
				if(stu.getSpassword().equals(passwd))
				{
					//密码输入正确
					session.setAttribute("user",stu);
					//页面重定向
					out.print("1");
				}
				else
				{
					//密码输入错误
					out.print("0");
				}	
			}
			else
			{
				//没有该账号下
				out.print("0");
			}
		}
	%>