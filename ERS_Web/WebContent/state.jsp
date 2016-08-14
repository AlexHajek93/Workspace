<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" ><head>
    <link rel="icon" href="./photo.ico">
    <title>Expense Reimbursement System</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="./styles.css">
	<script src="JScript.js"></script>
  </head>
  <body role="document" id="blackbody">
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" id="maincolor" href="./home.jsp">Expense Reimbursement System</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a id="homecolor" href="./home.jsp">Home</a></li>
            <li class="active"><a id="reimcolor" href="./reimburse.jsp">Reimburse System</a></li>
            <li><a id="faqcolor" href="./about.jsp">FAQ & About</a></li>
            <li><a id="contcolor" href="./contact.jsp">Contact Information</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="container theme-showcase" role="main" style="background-color: black;">
      <div class="jumbotron">
      	<c:choose>
      		<c:when test="${userRole != 2 && userRole != 0}">
		      	<c:choose>
		      		<c:when test="${ustate == 1}">
			      		<h1 style="text-align: center;">IT'S (almost) PAYDAY!!</h1>
			      		<form action="nreim.do" method="post">
				      		Amount: <br/><input type="text" name="amount" class="widthSetter" id="reimAmount"/><br/>
				      		Reimbursement Type: <br/>
				      		<select name="type">
							  <option value="Lodging">Lodging</option>
							  <option value="Travel">Travel</option>
							  <option value="Food">Food</option>
							  <option value="Other">Other</option>
							</select><br/>
				      		Description: <br/><input type="text" name="desc" class="widthSetter"/><br/>
							<input type="submit" value="Add" id="add" class="gone"/><br/>
			      		</form>
			      	</c:when>
			      	<c:when test="${ustate == 2}">
			      		<h1 style="text-align: center;">Why are they taking so long...</h1>
			      		<div class="centerItems2">
				      		<button onclick="showPending()">Show Pending</button>
				      		<button onclick="showApproved()">Show Approved</button>
				      		<button onclick="showDeny()">Show Denied</button>
				      		<button onclick="showResolved()">Show Resolved</button>
				      		<button onclick="showAll()">Show All</button>
				      	</div>
			      		<c:choose>
		      				<c:when test="${!empty list[0]}">
					      		<jsp:useBean id="bean" scope="page" class="ers.beans.ErsReimbursement">
								<jsp:setProperty property="amount" name="bean"/>
								<jsp:setProperty property="submitted" name="bean"/>
								<jsp:setProperty property="resolved" name="bean"/>
								<jsp:setProperty property="description" name="bean"/>
								<jsp:setProperty property="receipt" name="bean"/>
								<jsp:setProperty property="status" name="bean"/>
								<jsp:setProperty property="type" name="bean"/>
								</jsp:useBean>
									<table class="widthSetter table">
										<tr style=""><th>Amount</th>
										<th>Submission Date</th>
										<th>Resolved Date</th>
										<th>Description</th>
										<th>Receipt</th>
										<th>Status</th>
										<th>Type</th></tr>
										<c:forEach var="t" items="${list}">
											<tr class="trow ${t.status.getStatus()}">
												<td><c:out value="$ ${t.amount}"></c:out></td>
												<td><c:out value="${t.submitted}"></c:out></td>
												<td><c:out value="${t.resolved}"></c:out></td>
												<td><c:out value="${t.description}"></c:out></td>
												<td><c:out value="${t.receipt}"></c:out></td>
												<td><c:out value="${t.status.getStatus()}"></c:out></td>
												<td><c:out value="${t.type.getType()}"></c:out></td>
											</tr>
										</c:forEach>
									</table>
							</c:when>
							<c:when test="${empty list[0]}">
								Seems like there is nothing here...
							</c:when>
						</c:choose>
			      	</c:when>
		      	</c:choose>
		    </c:when>
		    <c:when test="${userRole == 2}">
		    	<c:choose>
		      		<c:when test="${mstate == 1}">
			      		<h1 style="text-align: center;">Get ready to empty the Bank...</h1>
			      		<form action="ntype.do" method="post">
				      		New Type Name: <br/><input type="text" name="newtype" class="widthSetter"/><br/>
							<input type="submit" value="Add"/><br/>
			      		</form>
			      	</c:when>
			      	<c:when test="${mstate == 2}">
			      		<h1 style="text-align: center;">How about an '!!!AWESOME!!!' status?</h1>
			      		<form action="nstat.do" method="post">
				      		New Status Name: <br/><input type="text" name="newstat" class="widthSetter"/><br/>
							<input type="submit" value="Add"/><br/>
			      		</form>
			      	</c:when>
			      	<c:when test="${mstate == 3}">
			      		<h1 style="text-align: center;">Does the intern really need their own type?</h1>
			      		<form action="nrole.do" method="post">
				      		New Role Name: <br/><input type="text" name="newrole" class="widthSetter"/><br/>
							<input type="submit" value="Add"/><br/>
			      		</form>
			      	</c:when>
			      	<c:when test="${mstate == 4}">
			      		<h1 style="text-align: center;">Time to break the Bank...</h1>
			      		<div style="text-align: center;">
				      		<button onclick="showPending()">Show Pending</button>
				      		<button onclick="showApproved()">Show Approved</button>
				      		<button onclick="showDeny()">Show Denied</button>
				      		<button onclick="showResolved()">Show Resolved</button>
				      		<button onclick="showAll()">Show All</button><br/>
			      		</div>
			      		<c:choose>
		      				<c:when test="${!empty list[0]}">
					      		<jsp:useBean id="bean" scope="page" class="ers.beans.ErsReimbursement">
								<jsp:setProperty property="id" name="bean"/>
								<jsp:setProperty property="amount" name="bean"/>
								<jsp:setProperty property="submitted" name="bean"/>
								<jsp:setProperty property="resolved" name="bean"/>
								<jsp:setProperty property="description" name="bean"/>
								<jsp:setProperty property="receipt" name="bean"/>
								<jsp:setProperty property="status" name="bean"/>
								<jsp:setProperty property="type" name="bean"/>
								</jsp:useBean>
									<table class="widthSetter table" id="reim_table">
										<tr><th>ID</th>
										<th>Amount</th>
										<th>Submission Date</th>
										<th>Resolved Date</th>
										<th>Description</th>
										<th>Receipt</th>
										<th>Status</th>
										<th>Type</th></tr>
										<c:forEach var="t" items="${list}">
											<tr class="trow ${t.status.getStatus()}">
												<td><c:out value="${t.id}"></c:out></td>
												<td><c:out value="$ ${t.amount}"></c:out></td>
												<td><c:out value="${t.submitted}"></c:out></td>
												<td><c:out value="${t.resolved}"></c:out></td>
												<td><c:out value="${t.description}"></c:out></td>
												<td><c:out value="${t.receipt}"></c:out></td>
												<td><c:out value="${t.status.getStatus()}"></c:out></td>
												<td><c:out value="${t.type.getType()}"></c:out></td>
												<c:if test="${t.status.getStatus()=='Pending'}">
													<td><form action="approve.do" method="post" name="id+${t.id}"><input type="text" name="reim_id" value="${t.id}" class="hidden"/><input type="submit" value="Approve"/></form></td>
													<td><form action="deny.do" method="post" ><input type="text" name="reim_id" value="${t.id}" class="hidden"/><input type="submit" value="Deny" name="id+${t.id}"/></form></td>
												</c:if>
											</tr>
										</c:forEach>
									</table>
							</c:when>
							<c:when test="${empty list[0]}">
								Seems like there is nothing here...
							</c:when>
						</c:choose>
			      	</c:when>
		      	</c:choose>
		    </c:when>
		</c:choose>
		<form action="goBack.do" method="post"><input type="submit" value="Go Back"/><br/></form>
      </div>
    </div>
	<img data-src="./photo.png" id="imagerev" alt="200x200" src="./photo.png" data-holder-rendered="true"></body>
	<!-- Datatables CSS CDN -->
	<link href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" rel='stylesheet' type='text/css' >
	<!-- jQuery CDN -->
	<script src="https://code.jquery.com/jquery-1.12.3.js" type="text/javascript" ></script>
	<!-- Datatable jQuery CDN -->
	<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js" type="text/javascript"></script>
	<script src="JScript.js"></script>
</body>
<script>
$("#reimAmount").keyup(function(){
	var amo = $("#reimAmount").val();
	if(isNaN(amo)){
		$("#add").css("display","none");
	}else{
		$("#add").css("display","inline");
	}
})
</script>
</html>