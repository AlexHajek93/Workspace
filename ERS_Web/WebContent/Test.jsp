<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./styles.css">
</head>
<body>
	<div class="centerItems2">
		<button onclick="showPending()">Show Pending</button>
		<button onclick="showApproved()">Show Approved</button>
		<button onclick="showDeny()">Show Denied</button>
		<button onclick="showResolved()">Show Resolved</button>
		<button onclick="showAll()">Show All</button>
	</div>
	<table class="table" style="outline-color: navy;">
		<tr style=""><th>Amount</th>
		<th>Submission Date</th></tr>
		<tr class="Pending"><td>HI</td><td>HI</td></tr>
		<tr class="Approved"><td>HI2</td><td>HI2</td></tr>
	</table>
	<form action="test.do" method="post" style="color:#fff; background-color: #563d7c; border-color: #563d7c;"><input type="submit"/></form>
</body>
</html>