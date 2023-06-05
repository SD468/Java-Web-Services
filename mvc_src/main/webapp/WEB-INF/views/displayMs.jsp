<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
<form:form action="/client/home/search" modelAttribute="search" > 
	<h1>Student Marksheet Details</h1>
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
			
				<tr>
					<td>${search.rollNo}</td>
					<td>${search.studentName}</td>
					<td>${search.firstLang}</td>
					<td>${search.secondLang}</td>
					<td>${search.math}</td>
					<td>${search.phys}</td>
					<td>${search.chem}</td>
					<td>${search.totalMarks}</td>
					<td>${search.percentage}</td>
					<td>${search.grade}</td>
					<td> <a href="/client/home/delete-ms?rollNo=${search.rollNo}" class="btn btn-danger">Delete</a>   </td>
					<td> <a href="/client/home/update-ms?rollNo=${search.rollNo}" class="btn btn-success">Update</a>   </td>
					<td> <a href="/download/data?rollNo=${search.rollNo}" class="btn btn-success">Download</a>   </td>
				</tr>
			
		</tbody>
	</table>
</form:form> 
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>