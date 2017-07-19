<%@page import="java.util.Collections"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.example.Spring.model.Task"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.example.Spring.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
	<jsp:include page="imports.jsp"/>
</head>
<body>
	
	<div class="jumbotron">
		<h1>Error</h1>
		<p><a href="/home">home</a></p>
	</div>
	
	
    
    <jsp:include page="scripts.jsp"></jsp:include>
    <script src="js/freebitcoin.js"></script>
    <script src="js/home.js"></script>
    <script>
    document.getElementsByClassName("side-nav")[0].getElementsByTagName("li")[0].setAttribute("class","active");
    </script>
</body>
</html>