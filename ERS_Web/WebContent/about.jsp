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
            <li><a id="reimcolor" href="./reimburse.jsp">Reimburse System</a></li>
            <li class="active"><a id="faqcolor" href="./about.jsp">FAQ & About</a></li>
            <li><a id="contcolor" href="./contact.jsp">Contact Information</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="container theme-showcase" role="main" style="background-color: black;">
      <div class="jumbotron">
        <h1 style="text-align: center;">FAQ & About</h1>
        <p>This is the about tab where more information will be filled in as we go.</p>
        <ol class="list-group revcolor">
            <li class="list-group-item">Q: What's your favorite color?<br/>A: 0xF26A25</li>
            <li class="list-group-item">Q: When will the reimbursement be processed?<br/>A: When we get around to it. Maybe next Thursday...</li>
            <li class="list-group-item">Q: Where are you located?<br/>A: (In terms of the Earth's Human's System)Dimension 0,Universe 0,Virgo Supercluster,Local Group,Milky Way Galaxy,Orion Arm,Local Bubble,Solar System,Earth,United States of America,Virginia,Reston,11730 Plaza America Dr #205</li>
        </ol>
      </div>
    </div>
	<img data-src="./photo.png" id="imagerev" alt="200x200" src="./photo.png" data-holder-rendered="true"></body>
</body>
</html>