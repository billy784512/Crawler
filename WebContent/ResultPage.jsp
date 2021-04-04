<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
	<link href="resources/styles/kendo.common.min.css" rel="stylesheet" type="text/css" />
    <link href="resources/styles/kendo.default.min.css" rel="stylesheet" type="text/css" />
    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/kendo.all.min.js"></script>
</head>
<script>
    function onClick(e) {
    	document.getElementById("div1").style.display = 'none';
    	document.getElementById("div2").style.display = 'block';
        document.form1.submit();   
    }
</script>
<body bgcolor="#FFCE6B">
<div id="div1">
<div style="height:10px;"></div>
<img src="resources/title1.png"></img>
<div style="height:10px;"></div>
<div>
<form action='${requestUri}' method='get' name='form1'>
<kendo:textBox name='keyword' placeholder = '${keyword}' style="width:410px;height:30px;"></kendo:textBox>
<kendo:button name="button" type="button" click='onClick' imageUrl="resources/magnifying-glass.png"></kendo:button>
</form>
</div>
<div style="height:20px;"></div>
<%
String[][] orderList = (String[][])  request.getAttribute("query");
for(int i =0 ; i < orderList.length;i++){%>
	<a href='<%= orderList[i][1] %>'><font face='微軟正黑體' size='4'><%= orderList[i][0] %></font></a><br>
	<h style="font-size:7px ;"><%= orderList[i][1] %></h><br><br>
<%
}
%>
</div>
<div id="div2" style="text-align:center;display:none;" >
<div style="height:100px;"></div>
<kendo:loader name="loader" type="pulsing" size="large"></kendo:loader>
<h1>Loading...</h1>
</div>
</body>
</html>