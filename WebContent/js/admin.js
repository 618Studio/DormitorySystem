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
	
	var result = xmlhttp.responseText;
	result = result.replace(/[ \r\n]/g,"");    //去掉空格
	if(result=='1'){
		//显示提示框
		
		//禁用button
	}
}