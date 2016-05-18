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
	
	xmlhttp.open("post","match",false);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send();
	var result = xmlhttp.responseText;
	result = result.replace(/[ \r\n]/g,"");    //去掉空格
	alert(result);
	if(result=='1'){
		alert("haha");
		//显示提示框
		var alerts = document.getElementById("alert");
		alerts.style.display="";
		//禁用button
		var button = document.getElementById("button");
		button.style = "disabled";
	}
}