<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<style>
body {
	display: flex;
	flex-direction: column;
	text-align: center;
	height: 100vh;
	background-color:lavender;
	justify-content: center;
	align-items: center;
	
}
</style>

</head>


<body ><!-- <!-- style="background-color:lavander;align:center" -->
<div class="container">
	<h1>Marksheet Portal</h1>

	<c:if test="${error!=null}">
		<p class="error">${error}</p>
	</c:if>
	<c:if test="${param.act eq 'lo'}">
		<p class="success">Logout Successfully! Thanks for using marksheet
			portal application.</p>
	</c:if>
	<form:form action="/welcome" method="post" class="col-md-6 offset-md-3" modelAttribute="login">
		<table class="table">
			<tr>
				<td><from:label path="userName"> User Name: </from:label></td>
				<td><form:input path="userName" type="text"   required="required"  placeholder="Enter your User Name"/></td>
				<td><form:errors path="userName" cssClass="text-warning" /></td>
			</tr>
			<tr>
				<td><from:label path="password"> Password: </from:label></td>
				<td><form:input path="password"  type="password" required="required" placeholder="Enter your Password"/></td>
				<td><form:errors path="password" cssClass="text-warning" /></td>
			</tr>
			<tr>
				
				<td></td>
				<td>
				<input type="submit"  class="btn offset-md-12 btn-primary" value="Login" name="submit" />
				<input type="reset"  class="btn btn-secondary" value="Cancel" />
				</td>
			</tr>
		</table>
	</form:form>

	</div>
</body>

</html>