<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet" >  -->
<title>ADD Page</title>
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

		<h1>Enter Marks Details</h1>

		<form:form method="post" modelAttribute="mark-add">
			<table >
			<tr >
				<td><form:label path="studentName">Student Name: </form:label>
				<td><form:input type="text" path="studentName" required="required" placeholder="Enter the student name"/>
				<td><form:errors path="studentName" cssClass="text-warning" />
			</tr>

			<tr>
			<td><form:label path="firstLang">First Language: </form:label></td>
			<td><form:input type="text" path="firstLang" required="required" placeholder="Enter the mark"/></td>
			<td><form:errors path="firstLang" cssClass="text-warning" /></td>
			</tr>

			<tr>
				<td><form:label path="secondLang">Second Language: </form:label></td>
				<td><form:input type="text" path="secondLang" required="required" placeholder="Enter the mark"/></td>
				<td><form:errors path="secondLang" cssClass="text-warning" /></td>
			</tr>

			<tr >
				<td><form:label path="math">Math: </form:label></td>
				<td><form:input type="text" path="math" required="required" placeholder="Enter the mark"/></td>
				<td><form:errors path="math" cssClass="text-warning" /></td>
			</tr>

			<tr>
				<td><form:label path="phys">Physics: </form:label></td>
				<td><form:input type="text" path="phys" required="required" placeholder="Enter the mark"/></td>
				<td><form:errors path="phys" cssClass="text-warning" /></td>
			</tr>

			<tr>
				<td><form:label path="chem">Chemistry: </form:label></td>
				<td><form:input type="text" path="chem" required="required" placeholder="Enter the mark"/></td>
				<td><form:errors path="chem" cssClass="text-warning" /></td>
			</tr>
			<tr><td></td><td></td></tr>
			<tr>
			<td></td>
			<td><input type="submit" class="btn btn-success" /></td>
			</tr>
		</table>
		</form:form>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>