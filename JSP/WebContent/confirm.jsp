<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.revature.beans.UserBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
<%!
	public void jspInit(){
		System.out.println("calling jspInit()");
	}
	public void jspDestroy(){
		System.out.println("callingDestroy()");
	}
 %>

<%!
	String pageScopedVariable = "TEsting";
 %>
<h2>Confimation</h2>
Registration complete for <%= ((UserBean) session.getAttribute("userData")).getFullname() %>!!!
<br/> Test variable:
<%
	if(request.getAttribute("requestScopedVariable") != null)
		out.println(request.getAttribute("requestScopedVariable"));
 %>
 <br/> App Variable;
 <%
 	if(application.getAttribute("applicationScopeVariable") != null)
 		out.println(application.getAttribute("applicationScopeVariable"));
  %>
<%
 	pageContext.getAttribute("pageScopedVariable");
 %>
</body>
</html>