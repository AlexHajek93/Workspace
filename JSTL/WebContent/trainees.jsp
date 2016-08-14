<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Congratulations</title>
</head>
<body>
<c:if test="${empty traineeList[0]}">
	<jsp:forward page="home.jsp"></jsp:forward>
</c:if>
<jsp:useBean id="bean" scope="page" class="com.revature.beans.Trainee">
<jsp:setProperty property="id" name="bean" value="-1"/>
<jsp:setProperty property="name" name="bean" value="Marcus Fenix"/>
<jsp:setProperty property="major" name="bean" value="Killin Grubs"/>
</jsp:useBean>
<table>
	<tr><th>ID</th>
	<th>Name</th>
	<th>Major</th>
	<th>Salary</th>
	<th>Skill</th>
	<th>Coolness</th></tr>
	<td><jsp:getProperty name="bean" property="id"/></td>
	<td><jsp:getProperty name="bean" property="name"/></td>
	<td><jsp:getProperty name="bean" property="major"/></td>
	<c:forEach var="t" items="${traineeList}">
		<tr>
			<td><c:out value="${t.id}"></c:out></td>
			<td><c:out value="${t.name}"></c:out></td>
			<td><c:out value="${t.major}"></c:out></td>
			<td>
				<c:choose>
					<c:when test="${t.salary >= 10.00}">
						<font style="color: green"></font>
						<fmt:formatNumber value="${t.salary}" type="currency"></fmt:formatNumber>
					</c:when>
					<c:when test="${t.salary lt 10.00}">
						<font style="color: red"></font>
						<fmt:formatNumber value="${t.salary}" type="currency"></fmt:formatNumber>
					</c:when>
					<c:otherwise>
						<fmt:formatNumber value="${t.salary}" type="currency"></fmt:formatNumber>
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				<c:out value="${t.skill.skill}"></c:out>
				<c:if test="${t.skill.skill eq J2EE}"></c:if>
					<c:out value="!!!"></c:out>
				<c:out value=""></c:out>
			</td>
			<td><c:out value="${t.skill.coolnessFactor}"></c:out></td>
		</tr>
	</c:forEach>
</table>
	You've won an <a href="home.jsp">iPod</a>!!!
</body>
</html>