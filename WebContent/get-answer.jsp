<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hibernate.*" %>
<% 
	//验证是否登录
	String id = (String)session.getAttribute("user");
	if(id==null)
	{
		response.sendRedirect("LogIn.jsp");
	}
	
	String q1 = request.getParameter("q1");
	String q2 = request.getParameter("q2");
	String q3 = request.getParameter("q3");
	String q4 = request.getParameter("q4");
	String q5 = request.getParameter("q5");
	String q6 = request.getParameter("q6");
	String q7 = request.getParameter("q7");
	String q8 = request.getParameter("q8");
	String q9 = request.getParameter("q9");
	String q10 = request.getParameter("q10");
	String q11 = request.getParameter("q11");
	String q12 = request.getParameter("q12");
	String q13 = request.getParameter("q13");
	String q14 = request.getParameter("q14");
	String q15 = request.getParameter("q15");
	String q16 = request.getParameter("q16");
	String q17 = request.getParameter("q17");
	
	BaseDAO<Students> baseDAO = new BaseDAO<Students>();
	Students stu = baseDAO.find(Students.class,id);
	
	
%>