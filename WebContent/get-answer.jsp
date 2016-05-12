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
	
	//第一个问题
	String q0 = request.getParameter("q0");
	int qfuture = -1;
	if(q0.equals("studyAbroad"))
	{
		qfuture = 1;
	}
	else if(q0.equals("graudateStudy"))
	{
		qfuture = 2;
	}
	else if(q0.equals("work"))
	{
		qfuture = 3;
	}
	else if(q0.equals("notSure"))
	{
		qfuture = 4;
	}
	
	//第2个到第16个问题
	String[] qpart = new String[15];
	qpart[0] = request.getParameter("q1");
	qpart[1] = request.getParameter("q2");
	qpart[2] = request.getParameter("q3");
	qpart[3] = request.getParameter("q4");
	qpart[4] = request.getParameter("q5");
	qpart[5] = request.getParameter("q6");
	qpart[6] = request.getParameter("q7");
	qpart[7] = request.getParameter("q8");
	qpart[8] = request.getParameter("q9");
	qpart[9] = request.getParameter("q10");
	qpart[10] = request.getParameter("q11");
	qpart[11] = request.getParameter("q12");
	qpart[12] = request.getParameter("q13");
	qpart[13] = request.getParameter("q14");
	qpart[14] = request.getParameter("q15");
	qpart[15] = request.getParameter("q16");
	String qpart23 = "";
	for(String s: qpart)
	{
		qpart23 += s;
	}

	//第17个问题
	String qwant = request.getParameter("q17");
	
	
	//存储到数据库
	BaseDAO<Question> baseDAO = new BaseDAO<Question>();
	Question question = new Question(id,qfuture,qpart23,qwant);
	baseDAO.create(question);
%>
