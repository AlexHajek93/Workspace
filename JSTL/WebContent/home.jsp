<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Trainee</title>
</head>
<body>
<form action="insertTrainee.do" method="post">
	Id: <input type="text" name="id"/><br/>
	Name: <input type="text" name="name"/><br/>
	Major: <input type="text" name="major"/><br/>
	Salary: <input type="text" name="salary"/><br/>
	<!-- Static include -->
	<!-- Skill: <%@ include file="skillbox.jsp" %> -->
	<!-- Happens at runtime. Dynamic include. can pass params -->
	Skill: 
	<jsp:include page="skillbox.jsp">
		<jsp:param name="obj" value="${skills}"/>
	</jsp:include>
	
	<input type="submit" value="Add">
</form>
</body>
</html>