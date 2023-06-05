<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<title>Home Page</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">

	<div class="collapse navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/welcome">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="/client/home">Todos</a></li>
			<li class="nav-item"><a class="nav-link" href="/client/getMeritList">Merit List</a></li>
		</ul>
	</div>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
	</ul>	
</nav>
<div class="container">
	<form action="<s:url value="/client/home/search"/>" style="position:absolute;right:70px">
	 	
		<input type="text"  value="${param.rollNo}" name="rollNo" placeholder="Enter your roll no" required="required"/>
		<input type="submit" value="Search" style="background-color: aqua; border: none;color:black; padding:2px"/>
		
	</form>
	<h2>Student Marks Details</h2> 
	<table class = "table table-striped table-bordered">
		<thead>
			<tr>
				<th>Roll No</th>
				<th>Student Name</th>
				<th>First Language</th>
				<th>Second Language</th>
				<th>Math</th>
				<th>Physics</th>
				<th>Chemistry</th>
				<th>Total Marks</th>
				<th>Percentage</th>
				<th>Grade</th>
				<th colspan="2" style="text-align:center">Action</th>
				<th>Get Marksheet</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${msList}" var="ms">
				<tr>
					<td>${ms.rollNo}</td>
					<td>${ms.studentName}</td>
					<td>${ms.firstLang}</td>
					<td>${ms.secondLang}</td>
					<td>${ms.math}</td>
					<td>${ms.phys}</td>
					<td>${ms.chem}</td>
					<td>${ms.totalMarks}</td>
					<td>${ms.percentage}</td>
					<td>${ms.grade}</td>
					<td> <a href="/client/home/delete-ms?rollNo=${ms.rollNo}" class="btn btn-danger">Delete</a>   </td>
					<td> <a href="/client/home/update-ms?rollNo=${ms.rollNo}" class="btn btn-success">Update</a>   </td>
					<td> <a href="/download/data?rollNo=${ms.rollNo}" class="btn btn-success">Download</a>   </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/client/home/addMs" class="btn btn-success">Add Marksheet</a>
	<div style="text-align:center;color:red;margin-top:100px">
		${errMsg}
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>