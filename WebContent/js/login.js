/**
 * 
 */

function Submit()
{
	var xmlhttp;
	if(window.XMLHttpRequest)
	{
		xmlhttp = new XMLHttpRequest();
	}
	else
	{
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	var studentId = document.getElementById("studentID").value;
	var passwd = document.getElementById("password").value;
	
	xmlhttp.open("post","jump.jsp",false);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("studentID="+studentId+"&password="+passwd);
	var result = xmlhttp.responseText;
	
	result = result.replace(/[ \r\n]/g,"");    //去掉空格
	if(result == '0'){
		var wrong = document.getElementById("wrong");
		wrong.style.display = "";
	}
	else if(result == '1'){
		window.location.href = "question.jsp";  
	}else if(result == '2'){
		window.location.href = "display.jsp";	
	}
	
	
		
}