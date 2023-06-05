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

<title>Merit List Page</title>
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
	
	<h2>Student Merit List</h2> 
	<table class = "table table-striped table-bordered">
		<thead>
			<tr>
				<th>Rank</th>
				<th>Roll No</th>
				<th>Student Name</th>
				<th>Total Marks</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${meritList}" var="ml">
				<tr>
					<td>${ml.rank}</td>
					<td>${ml.rollNo}</td>
					<td>${ml.studentName}</td>
					<td>${ml.totalMarks}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>


</body>
</html>